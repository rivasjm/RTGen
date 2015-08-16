package es.unican.istr.rtgen.elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class LinearSystem {

    private String name;
    private List<Flow> flows;
    private List<Processor> processors;


    public LinearSystem(){
        flows = new ArrayList<>();
        processors = new ArrayList<>();
    }

    public void addProcessor (Processor aProc){
        processors.add(aProc);
    }

    public void addFlow (Flow aFlow){
        flows.add(aFlow);
    }

    // Abstract methods

    public abstract void writeSystem(File f);

}
