package es.unican.istr.rtgen.elements;

import es.unican.istr.rtgen.mast.MastSystem;

/**
 * Created by juanm on 11/08/2015.
 */
public class LinearSystemGenerator<SystemT extends LinearSystem, ProcessorT extends Processor, FlowT extends Flow, TaskT extends Task> {

    Class<SystemT> systemT;
    Class<ProcessorT> processorT;
    Class<FlowT> flowT;
    Class<TaskT> taskT;

    public LinearSystemGenerator(Class<SystemT> systemClass, Class<ProcessorT> processorClass, Class<FlowT> flowClass, Class<TaskT> taskClass) {
        systemT = systemClass;
        processorT = processorClass;
        flowT = flowClass;
        taskT = taskClass;
    }

    public SystemT create() {
        SystemT system = null;
        try {
            system = systemT.newInstance();



        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return system;
    }

}
