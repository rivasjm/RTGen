package es.unican.istr.rtgen.elements;

import java.io.File;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class Flow {

    private Double period;
    private Double deadline;
    private List<Task> tasks;

    public abstract void writeFlow(File f);

}
