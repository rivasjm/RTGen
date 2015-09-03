package es.unican.istr.gen4mast;

import es.unican.istr.rtgen.system.elements.config.SystemConfig;
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

    public static void generate(SystemConfig s, MastConfig m, String dbLocation) {

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

    }
}
