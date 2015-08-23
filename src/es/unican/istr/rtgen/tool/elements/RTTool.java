package es.unican.istr.rtgen.tool.elements;

import es.unican.istr.rtgen.system.elements.LinearSystem;
import es.unican.istr.rtgen.tool.elements.config.RTToolConfig;

/**
 * Created by juanm on 19/08/2015.
 */
public interface RTTool {

    /*
    The implementation of this method applies a Real-Time tool over a LinearSystem, and stores the results in it
    The execution is configured with an implementation of a RTToolConfig
     */
    public void analyze(LinearSystem system, RTToolConfig config);

}
