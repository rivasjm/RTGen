package es.unican.istr.rtgen.elements;

import java.io.File;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class LinearSystem {

    private String name;
    private List<Flow> flows;
    private List<Processor> processors;

    public abstract void writeSystem(File f);

}
