package es.unican.istr.rtgen.elements;

import java.io.File;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class Task {

    // Basic Characteristics
    private Double wcet;
    private Double bcet;
    private Double offset;
    private Integer priority;
    private Double schedulingDeadline;
    //private Processor processor;

    // Results
    private Double wcrt;
    private Double bcrt;
    private Double jitter;

    public abstract void writeTask(File f);

}
