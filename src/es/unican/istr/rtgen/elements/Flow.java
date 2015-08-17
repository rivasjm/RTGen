package es.unican.istr.rtgen.elements;

import es.unican.istr.rtgen.config.LocalizationOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class Flow {

    private Double period;
    private Double deadline;
    private List<Task> tasks;

    public Flow() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task aTask){
        tasks.add(aTask);
    }

    public void locateTasks(List<Processor> procs, LocalizationOptions type, Random r){
        Processor lastProc = null;
        Processor tempProc;
        for (Task t: tasks){
            switch (type){
                case RANDOM:
                    lastProc = procs.get(r.nextInt(procs.size()));
                    t.setProcessor(lastProc);
                case AVOID_CONSECUTIVE:
                    while (true){
                        tempProc = procs.get(r.nextInt(procs.size()));
                        if ((tempProc != lastProc) || (procs.size() == 1)){
                            t.setProcessor(tempProc);
                            lastProc = tempProc;
                            break;
                        }
                    }
            }
        }


    }

    // Abstract methods
    public abstract void writeFlow(File f);

}
