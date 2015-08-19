package es.unican.istr;

import es.unican.istr.rtgen.config.*;
import es.unican.istr.rtgen.mast.MastFlow;
import es.unican.istr.rtgen.mast.MastProcessor;
import es.unican.istr.rtgen.mast.MastSystem;
import es.unican.istr.rtgen.mast.MastTask;

import java.io.File;

public class Main {

    public static void main(String[] args) {


        PeriodConfig period = new PeriodConfig(PeriodDistributionOptions.UNIFORM,100.0,100.0);
        DeadlineConfig deadline = new DeadlineConfig("T");
        UtilizationConfig utilization = new UtilizationConfig(0.1, 0.01, 0.8, 0.0, WCETGenerationOptions.SCALE, LoadBalancingOptions.NON_BALANCED);
        utilization.setCurrentU(0.4);

        Config config = new Config(5,5,10,false,0.0,"FP",period,deadline, LocalizationOptions.RANDOM,utilization);

        MastSystem<MastTask, MastFlow, MastProcessor> system = new MastSystem<>(config, 10);

        system.printOverview();

        system.writeSystem(new File("out.txt"));


    }
}
