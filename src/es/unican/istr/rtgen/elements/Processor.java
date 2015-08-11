package es.unican.istr.rtgen.elements;

import java.io.File;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class Processor {

    private Integer id;
    private String schedulingPolicy;
    private List<Task> tasks;

    public abstract void writeProcessor(File f);

}
