package es.unican.istr.gen4mast;

import com.sun.org.apache.xpath.internal.operations.Bool;
import es.unican.istr.gen4mast.db.DBHandler;
import es.unican.istr.rtgen.system.elements.Flow;
import es.unican.istr.rtgen.system.elements.config.*;
import es.unican.istr.rtgen.system.mast.MastFlow;
import es.unican.istr.rtgen.system.mast.MastProcessor;
import es.unican.istr.rtgen.system.mast.MastSystem;
import es.unican.istr.rtgen.system.mast.MastTask;
import es.unican.istr.rtgen.tool.mast.MastTool;
import es.unican.istr.rtgen.tool.mast.config.AnalysisOptions;
import es.unican.istr.rtgen.tool.mast.config.AssignmentOptions;
import es.unican.istr.rtgen.tool.mast.config.HOSPAConfig;
import es.unican.istr.rtgen.tool.mast.config.MastConfig;

/**
 * Created by juanm on 22/08/2015.
 */
public class MastSeries {

    public static void run(SystemConfig s, MastConfig m, String dbLocation) {

        // This method generates the series (of utilizations) of systems specified in SystemConfig,
        // and applies the techniques specified in MastConfig. Stores results in dbLocation (NOSQL database)

        double[] wcrtArray = new double[101];
        double[] execTimeArray = new double[101];
        int msu = 0; // Maximum Schedulable Utilization

        MastTool tool = new MastTool();
        for (int u=s.getUtilization().getStart(); u<=s.getUtilization().getTop(); u+=s.getUtilization().getStep()) {

            // Set current utilization in the series
            s.getUtilization().setCurrentU(u);

            // Create system
            MastSystem<MastTask, MastFlow, MastProcessor> system = new MastSystem(s);
            //system.printOverview();

            // Analyze (results saved in system)
            tool.analyze(system, m);
            //system.printResultsOverview();

            // Store results in series array of results
            wcrtArray[u] = system.getSystemAvgWCRT();
            execTimeArray[u] = system.getToolTimeElapsed();

            // for now break always at first not schedulable in the series
            if (!system.isSchedulable()){
                break;
            }
            msu = u;
        }

        // Store results
        DBHandler db = new DBHandler(dbLocation);
        db.addResultsRow(s, m, msu, wcrtArray, execTimeArray);
        db.close();

    }

    public static void main(String[] args) {

        String dbLocation = args[0];
        SystemConfig s = new SystemConfig();
        PeriodConfig p = new PeriodConfig();
        UtilizationConfig u = new UtilizationConfig();
        DeadlineConfig deadline;

        MastConfig m = new MastConfig();
        HOSPAConfig h = new HOSPAConfig();

        String key;
        String value;
        for (int i=1; i<args.length; i++) { // args[0] contains db location
            key = args[i].split("=")[0];    //SEED=1000, [0] is SEED, [1] is 1000
            value = args[i].split("=")[1];

            switch (key){
                // System characteristics
                case "SEED": s.setSeed(Integer.parseInt(value));break;
                case "N_PROCESSORS": s.setnProcs(Integer.parseInt(value)); break;
                case "N_FLOWS": s.setnFlows(Integer.parseInt(value)); break;
                case "N_TASKS": s.setnTasks(Integer.parseInt(value)); break;
                case "RANDOM_LENGTH": s.setRandomLength(Boolean.parseBoolean(value)); break;
                case "SINGLE_FLOWS": s.setSingleFlows(Float.parseFloat(value)); break;
                case "SCHED_POLICY": s.setSchedPolicy(value); break;
                case "PERIOD_DISTRIBUTION": p.setDistribution(PeriodDistributionOptions.valueOf(value)); break;
                case "PERIOD_BASE": p.setBase(Float.parseFloat(value));break;
                case "PERIOD_RATIO": p.setRatio(Float.parseFloat(value)); break;
                case "DEADLINE": deadline = new DeadlineConfig(value); s.setDeadline(deadline);break;
                case "TASK_LOCALIZATION": s.setLocalization(LocalizationOptions.valueOf(value)); break;
                case "UTILIZATION_START": u.setStart(Integer.parseInt(value)); break;
                case "UTILIZATION_STEP": u.setStep(Integer.parseInt(value)); break;
                case "UTILIZATION_TOP": u.setTop(Integer.parseInt(value)); break;
                case "UTILIZATION_BCET_FACTOR": u.setBcetFactor(Float.parseFloat(value)); break;
                case "UTILIZATION_WCET_METHOD": u.setWcetMethod(WCETGenerationOptions.valueOf(value)); break;
                case "UTILIZATION_BALANCING": u.setBalancing(LoadBalancingOptions.valueOf(value)); break;

                // MAST characteristics
                case "NAME": m.setName(value); break;
                case "WORK_PATH": m.setWorkPath(value); break;
                case "MAST_PATH": m.setMastPath(value); break;
                case "ANALYSIS_TOOL": m.setAnalysis(AnalysisOptions.valueOf(value)); break;
                case "SYNC": m.setSync(Boolean.parseBoolean(value)); break;
                case "ASSIGNMENT_TOOL": m.setAssignment(AssignmentOptions.valueOf(value)); break;
                case "HOSPA_INIT": h.setInit(HOSPAConfig.InitOptions.valueOf(value)); break;
                case "HOSPA_Ka": h.setKa(Float.parseFloat(value)); break;
                case "HOSPA_Kr": h.setKr(Float.parseFloat(value)); break;
                case "HOSPA_ITERATIONS": h.setIterations(Integer.parseInt(value)); break;
                case "HOSPA_OVERITERATIONS": h.setOverIterations(Integer.parseInt(value)); break;
                case "ANALYSIS_STOP_FACTOR": m.setStopFactor(Float.parseFloat(value)); break;
                case "LC_EDF_GSD": ; m.setGsd(Boolean.parseBoolean(value));break;
                case "LC_EDF_DS_FACTOR": m.setDsFactor(Float.parseFloat(value)); break;
                case "CALCULATE_SLACK": m.setCalculateSlack(Boolean.parseBoolean(value)); break;
                case "JITTER_AVOIDANCE": m.setJitterAvoidance(Boolean.parseBoolean(value)); break;
            }
        }

        s.setPeriod(p);
        u.setCurrentU(u.getStart());
        s.setUtilization(u);
        m.setHospaConfig(h);

        // Launch Mast Series Generation
        run(s, m, dbLocation);

    }
}
