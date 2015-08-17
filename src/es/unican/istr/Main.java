package es.unican.istr;

import es.unican.istr.rtgen.mast.MastFlow;
import es.unican.istr.rtgen.mast.MastProcessor;
import es.unican.istr.rtgen.mast.MastSystem;
import es.unican.istr.rtgen.mast.MastTask;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        LinearSystemGenerator<MastSystem, MastProcessor, MastFlow, MastTask> generator;
        generator = new LinearSystemGenerator<>(MastSystem.class, MastProcessor.class, MastFlow.class, MastTask.class);

        MastSystem system = generator.create();
        system.writeSystem(new File("null"));


    }
}
