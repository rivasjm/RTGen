package es.unican.istr.rtgen.elements;

import es.unican.istr.rtgen.config.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class LinearSystem<T extends Task, F extends Flow, P extends Processor> {

    private String name;
    private List<F> flows;
    private List<P> processors;

    private Class<T> taskClass;
    private Class<F> flowClass;
    private Class<P> processorClass;

    private Random random;

    public LinearSystem(Class<T> t, Class<F> f, Class<P> p, Config systemConfiguration, long randomSeed) {
        flows = new ArrayList<>();
        processors = new ArrayList<>();
        taskClass = t;
        flowClass = f;
        processorClass = p;
        random = new Random(randomSeed);
        create(systemConfiguration);
    }

    public Double getSystemUtilization() {
        Double u = 0.0;
        for (P p: processors) u += p.getUtilization();
        return u/processors.size();
    }

    public void printOverview() {
        for (F f: flows){
            f.printOverview();
        }
        System.out.printf("\n");
        for (P p: processors) {
            p.printOverview();
            System.out.printf(" ");
        }
        System.out.printf(": %f\n", this.getSystemUtilization());
    }

    public List<P> getProcessors() {
        return processors;
    }

    public List<F> getFlows() {
        return flows;
    }

    // Abstract methods

    public abstract void writeSystem(File f);


    // Private methods

    private void create(Config c) {
        try {

            // Add processors
            for (int i = 1; i <= c.getnProcs(); i++) {
                P proc = processorClass.newInstance();
                proc.setId(i);
                proc.setSchedulingPolicy(c.getSchedPolicy());
                processors.add(proc);
            }

            // Add e2e flows and tasks
            Integer singleFlows = (int) (c.getMonoFlows()/100.0*c.getnFlows());
            for (int i=1; i<=c.getnFlows(); i++){
                F flow = flowClass.newInstance();
                flow.setId(i);

                // Add tasks to e2e flow
                Integer nTasks;
                if (i<=singleFlows) {
                    nTasks = 1;
                } else if (c.getRandomLength()) {
                    nTasks = random.nextInt(c.getnTasks()-2)+2; // random integer between [2, number of tasks]
                } else {
                    nTasks = c.getnTasks();
                }

                P lastProc = null; // for task processor localization
                for (int j=1; j<= nTasks; j++){
                    T task = taskClass.newInstance();
                    task.setPriority(1);
                    task.setSchedulingDeadline(1.0);
                    flow.addTask(task);
                }
                flows.add(flow);
            }

            // Task localization, and flow periods and deadlines
            for (F f: flows){
                f.locateTasks((List<Processor>) processors, c.getLocalization(), random);
                f.setPeriod(c.getPeriod(), random);
                f.setDeadline(c.getDeadline(), random);
            }

            // Generate Load (task wcet)
            switch (c.getUtilization().getBalancing()){

                case BALANCED: //every processor with the same utilization
                    for (P p: processors) {
                        p.setUtilization(c.getUtilization().getWcetMethod(), 0.01, random);
                        p.scaleUtilization(c.getUtilization().getCurrentU()/0.01);
                    }
                    break;

                case NON_BALANCED: //each processor has a different utilization
                    // First create the utilization of each processor, so the system have 1% utilization
                    ArrayList<Double> us = new ArrayList<Double>();
                    for (P p: processors) {
                        us.add(random.nextDouble()+0.5);
                    }
                    Double sum = 0.0;
                    for (Double u: us){
                        sum += u;
                    }
                    ArrayList<Double> newUs = new ArrayList<Double>();
                    for (Double d: us) {
                        newUs.add(d/sum/processors.size());
                    }

                    // Set processors utilizations
                    for (int i=0; i<processors.size(); i++) {
                        processors.get(i).setUtilization(c.getUtilization().getWcetMethod(), 0.01, random);
                        processors.get(i).scaleUtilization(newUs.get(i)/0.01);
                    }
                    break;
            }

            // Set BCET of tasks
            for (P p: processors) {
                p.setBestCaseUtilization(c.getUtilization().getBcetFactor());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


