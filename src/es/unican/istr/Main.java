package es.unican.istr;

import es.unican.istr.gen4mast.MastSeries;
import es.unican.istr.rtgen.system.elements.config.*;
import es.unican.istr.rtgen.tool.elements.config.RTToolConfig;
import es.unican.istr.rtgen.system.mast.MastFlow;
import es.unican.istr.rtgen.system.mast.MastProcessor;
import es.unican.istr.rtgen.system.mast.MastSystem;
import es.unican.istr.rtgen.system.mast.MastTask;
import es.unican.istr.rtgen.tool.mast.MastTool;
import es.unican.istr.rtgen.tool.mast.config.AnalysisOptions;
import es.unican.istr.rtgen.tool.mast.config.AssignmentOptions;
import es.unican.istr.rtgen.tool.mast.config.HOSPAConfig;
import es.unican.istr.rtgen.tool.mast.config.MastConfig;

public class Main {

    public static void main(String[] args) {


        PeriodConfig period = new PeriodConfig(PeriodDistributionOptions.UNIFORM,100.0,100.0);
        DeadlineConfig deadline = new DeadlineConfig("T");
        UtilizationConfig utilization = new UtilizationConfig(10, 1, 11, 0.0, WCETGenerationOptions.UUNIFAST, LoadBalancingOptions.NON_BALANCED);
        utilization.setCurrentU(10);

        SystemConfig systemConfig = new SystemConfig(new Long(10), 5,5,10,false,0.0,"FP",period,deadline, LocalizationOptions.RANDOM,utilization);

        MastConfig configTool = new MastConfig(
                "D:\\Development\\RTGen",
                "D:\\Development\\MAST\\mast-bin-win-1-5-0-1\\mast-1-5-0-1\\mast_analysis.exe",
                AnalysisOptions.HOLISTIC,
                true,
                AssignmentOptions.PD,
                new HOSPAConfig(),
                10.0,
                false,
                0.0,
                false,
                false
        );

        MastSeries.generate(systemConfig, configTool, "hola");

//        MastSystem<MastTask, MastFlow, MastProcessor> system = new MastSystem<>(systemConfig, 10);
//        system.printOverview();
//
//        RTToolConfig configTool = new MastConfig(
//                "D:\\Development\\RTGen",
//                "D:\\Development\\MAST\\mast-bin-win-1-5-0-1\\mast-1-5-0-1\\mast_analysis.exe",
//                AnalysisOptions.HOLISTIC,
//                true,
//                AssignmentOptions.PD,
//                new HOSPAConfig(),
//                10.0,
//                false,
//                0.0,
//                false,
//                false
//                );
//
//        MastTool tool = new MastTool();
//        tool.analyze(system, configTool);
//
//        system.printResultsOverview();

    }
}
