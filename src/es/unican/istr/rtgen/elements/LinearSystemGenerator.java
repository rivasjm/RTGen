package es.unican.istr.rtgen.elements;

/**
 * Created by juanm on 11/08/2015.
 */
public class LinearSystemGenerator<SystemT extends LinearSystem, ProcessorT extends Processor, FlowT extends Flow, TaskT extends Task> {

    public SystemT create(Class<SystemT> systemClass, Class<ProcessorT> processorClass, Class<FlowT> flowClass, Class<TaskT> taskClass) throws IllegalAccessException, InstantiationException {

        SystemT system = systemClass.newInstance();

        
        return system;
    }

}
