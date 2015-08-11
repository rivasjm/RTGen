package es.unican.istr;

import es.unican.istr.rtgen.elements.LinearSystemGenerator;
import es.unican.istr.rtgen.mast.MastFlow;
import es.unican.istr.rtgen.mast.MastProcessor;
import es.unican.istr.rtgen.mast.MastSystem;
import es.unican.istr.rtgen.mast.MastTask;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        LinearSystemGenerator<MastSystem, MastProcessor, MastFlow, MastTask> generator = new LinearSystemGenerator<>();
        MastSystem system;
        try {
            system = generator.create(MastSystem.class, MastProcessor.class, MastFlow.class, MastTask.class);
            system.writeSystem(new File("null"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
