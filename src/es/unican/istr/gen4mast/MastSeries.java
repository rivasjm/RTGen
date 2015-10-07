package es.unican.istr.gen4mast;

import es.unican.istr.gen4mast.db.DBHandler;
import es.unican.istr.rtgen.system.elements.Flow;
import es.unican.istr.rtgen.system.elements.config.*;
import es.unican.istr.rtgen.system.mast.MastFlow;
import es.unican.istr.rtgen.system.mast.MastProcessor;
import es.unican.istr.rtgen.system.mast.MastSystem;
import es.unican.istr.rtgen.system.mast.MastTask;
import es.unican.istr.rtgen.tool.mast.MastTool;
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

        PeriodConfig p = new PeriodConfig();
        UtilizationConfig u = new UtilizationConfig();
        SystemConfig s = new SystemConfig();
        DeadlineConfig deadline;

        String key;
        String value;
        for (int i=0; i<args.length; i++) {
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
                case "NAME: columns.put(o.name(), "VARCHAR(22)"); break;
                case "WORK_PATH: columns.put(o.name(), "VARCHAR(1)"); break; // for now not used
                case "MAST_PATH: columns.put(o.name(), "VARCHAR(1)"); break; // for now not used
                case "ANALYSIS_TOOL: columns.put(o.name(), "INTEGER"); break;
                case SYNC: columns.put(o.name(), "BIT"); break;
                case ASSIGNMENT_TOOL: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_INIT: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_Ka: columns.put(o.name(), "REAL"); break;
                case HOSPA_Kr: columns.put(o.name(), "REAL"); break;
                case HOSPA_ITERATIONS: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_OVERITERATIONS: columns.put(o.name(), "INTEGER"); break;
                case ANALYSIS_STOP_FACTOR: columns.put(o.name(), "REAL"); break;
                case LC_EDF_GSD: columns.put(o.name(), "BIT"); break;
                case LC_EDF_DS_FACTOR: columns.put(o.name(), "REAL"); break;
                case CALCULATE_SLACK: columns.put(o.name(), "BIT"); break;
                case JITTER_AVOIDANCE: columns.put(o.name(), "BIT"); break;
            }
        }

    }
}
