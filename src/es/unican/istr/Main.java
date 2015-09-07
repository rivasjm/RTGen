package es.unican.istr;

import es.unican.istr.gen4mast.MastSeries;
import es.unican.istr.gen4mast.db.DBHandler;
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

        DBHandler db = new DBHandler("results.db");
        db.createTable();
        db.close();

        PeriodConfig period = new PeriodConfig(PeriodDistributionOptions.UNIFORM,100.0f,100.0f);
        DeadlineConfig deadline = new DeadlineConfig("T");
        UtilizationConfig utilization = new UtilizationConfig(10, 1, 20, 0.0f, WCETGenerationOptions.UUNIFAST, LoadBalancingOptions.NON_BALANCED);
        utilization.setCurrentU(10);





        for (int seed=1;seed<100;seed++){
            SystemConfig systemConfig = new SystemConfig(seed,5,5,5,false,0.0f,"FP",period,deadline, LocalizationOptions.RANDOM,utilization);

            MastConfig configTool = new MastConfig(
                    "Ejemplo",
                    String.format("C:\\Users\\JuanCTR\\CTR\\RTGen\\test\\%d\\",seed),
                    "C:\\Users\\JuanCTR\\CTR\\mast-bin-win-1-5-0-1\\mast-1-5-0-1\\mast_analysis.exe",
                    AnalysisOptions.HOLISTIC,
                    true,
                    AssignmentOptions.PD,
                    new HOSPAConfig(),
                    10.0f,
                    false,
                    0.0f,
                    false,
                    false
            );

            new Thread() {
                public void run() {
                    MastSeries.generate(systemConfig, configTool, "results.db");
                }
            }.start();

        }



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
