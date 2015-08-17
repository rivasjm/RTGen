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

            // Add e2e flows
            Integer singleFlows = (int) (c.getMonoFlows()/100.0*c.getnFlows());
            for (int i=1; i<=c.getnFlows(); i++){
                F flow = flowClass.newInstance();

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

            // Task localization
            for (F f: flows){
                f.locateTasks((List<Processor>)processors, c.getLocalization(), random);
            }

            // Task utilization
            for (int u=c.getUtilization().getStart(); u<=c.getUtilization().getTop(); u+=c.getUtilization().getStep()){
                switch (c.getUtilization().getBalancing()){
                    case BALANCED: //every processor with the same utilization

                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


