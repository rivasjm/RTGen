package es.unican.istr.rtgen.mast;

import es.unican.istr.rtgen.config.Config;
import es.unican.istr.rtgen.elements.Flow;
import es.unican.istr.rtgen.elements.LinearSystem;
import es.unican.istr.rtgen.elements.Processor;
import es.unican.istr.rtgen.elements.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by juanm on 11/08/2015.
 */
public class MastSystem<T extends Task, F extends Flow, P extends Processor> extends LinearSystem {

    public MastSystem(Class<T> t, Class<F> f, Class<P> p, Config systemConfiguration, long randomSeed) {
        super(t, f, p, systemConfiguration, randomSeed);
    }

    public MastSystem(Config systemConfiguration, long randomSeed) {
        super(MastTask.class, MastFlow.class, MastProcessor.class, systemConfiguration, randomSeed);
    }

    @Override
    public void writeSystem(File f) {
        try {
            FileOutputStream o = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(o);

            // Processing Resources
            for (MastProcessor p: (List<MastProcessor>) getProcessors()) {
                p.writeProcessingResource(pw);
                new PrintWriter(o).write("\n");
            }

            // Schedulers
            for (MastProcessor p: (List<MastProcessor>) getProcessors()) {
                p.writeScheduler(pw);
                new PrintWriter(o).write("\n");
            }

            // Operations
            for (MastFlow mf: (List<MastFlow>) getFlows()) {
                mf.writeOperations(pw);
                new PrintWriter(o).write("\n");
            }

            // Scheduling Servers (Tasks)
            for (MastFlow mf: (List<MastFlow>) getFlows()) {
                mf.writeSchedulingServers(pw);
                new PrintWriter(o).write("\n");
            }

            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
