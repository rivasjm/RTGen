package es.unican.istr.rtgen.tool.mast;

import es.unican.istr.rtgen.tool.mast.config.AnalysisOptions;
import es.unican.istr.rtgen.tool.mast.config.AssignmentOptions;
import es.unican.istr.rtgen.tool.mast.config.MastConfig;
import es.unican.istr.rtgen.system.elements.LinearSystem;
import es.unican.istr.rtgen.tool.elements.RTTool;
import es.unican.istr.rtgen.tool.elements.config.RTToolConfig;
import es.unican.istr.rtgen.system.mast.MastSystem;
import es.unican.istr.rtgen.system.mast.results.REALTIMESITUATION;
import es.unican.istr.rtgen.system.mast.results.TimingResult;
import es.unican.istr.rtgen.system.mast.results.TransactionResults;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by juanm on 19/08/2015.
 */
public class MastTool implements RTTool {

    @Override
    public void analyze(LinearSystem system, RTToolConfig config) {

        MastConfig c = (MastConfig) config;
        MastSystem s = (MastSystem) system;


        // Prepare input and output(results) files locations
        File baseDir = new File (c.getWorkPath());
        baseDir.mkdirs();

        String inputFilePath = FilenameUtils.concat(c.getWorkPath(), String.format("system%d.txt",new Double(system.getSystemUtilization()*100).intValue()));
        String outputFilePath = FilenameUtils.concat(c.getWorkPath(), String.format("results%d.xml", new Double(system.getSystemUtilization()*100).intValue()));

        //Write system to file
        system.writeSystem(new File(inputFilePath));

        //Prepares MAST arguments string
        ArrayList<String> args = new ArrayList<>();

        //MAST Path
        args.add(c.getMastPath());

        //Analysis Tool
        args.add(AnalysisOptions.mapArg(c.getAnalysis()));

        //Clock Synchronization
        if (!c.getSync()) args.add("-l");

        //Analysis stop factor
        if (c.getStopFactor()>0.0) args.add(String.format(Locale.US, "-f %d", c.getStopFactor().intValue()));

        //Force global scheduling deadlines (LC-EDF-GSD)
        if (c.getGsd()) args.add("-gsd");

        //LC-EDF-DS factor
        if (c.getDsFactor()>0.0) args.add(String.format(Locale.US, "-sf %f", c.getDsFactor()));

        //Slack
        if (c.getCalculateSlack()) args.add("-s");

        //Jitter Avoidance
        if (c.getJitterAvoidance()) args.add("-jitter_avoidance");

        //Scheduling Parameter assignment tool
        args.add(AssignmentOptions.mapArg(c.getAssignment()));

        //Input and output files
        args.add(inputFilePath);
        args.add(outputFilePath);

        //Create string
        String cmd = String.join(" ", args);
        //System.out.println(cmd);

        //Store tool configuration in system
        system.setToolConfig(config);

        //Execute MAST Tool
        long beforeTime = System.nanoTime();
        Runtime r = Runtime.getRuntime();
        Process p = null;

        //Check if input file is not yet created
//        while (true) {
//            System.out.println(inputFilePath);
//            System.out.println("File length: "+new File(inputFilePath).length());
//            break;
//        }

        try {
            p = r.exec(cmd);
            p.waitFor();

//            System.out.println(cmd);
//            String text = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8.name());
//            System.out.println(text);

            long afterTime = System.nanoTime();
            integrateMASTResults(new File(outputFilePath), system);
            system.setToolTimeElapsed(afterTime-beforeTime);
        } catch (IOException|InterruptedException e) {
            System.out.println("ERROR executing :"+cmd);
            e.printStackTrace();
        }
    }

    private void integrateMASTResults(File results, LinearSystem system){

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(REALTIMESITUATION.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            REALTIMESITUATION element = (REALTIMESITUATION) jaxbUnmarshaller.unmarshal(results);

            Integer flowID;
            String taskID;
            Double bcrt;
            Double wcrt;
            Double jitter;

            for (Object o: element.getSlackOrTraceOrProcessingResource()) {
                if (o instanceof TransactionResults) {
                    TransactionResults tr = (TransactionResults) o;

                    flowID = Integer.valueOf(tr.getName().replaceAll("\\D+",""));

                    for (Object to: tr.getSlackOrTimingResultOrSimulationTimingResult()) {
                        if (to instanceof TimingResult) {
                            TimingResult timing = (TimingResult) to;

                            taskID = String.format("%s", timing.getEventName().replaceAll("\\D+",""));
                            bcrt = timing.getBestGlobalResponseTimes().getGlobalResponseTime().get(0).getTimeValue();
                            wcrt = timing.getWorstGlobalResponseTimes().getGlobalResponseTime().get(0).getTimeValue();
                            jitter = timing.getJitters().getGlobalResponseTime().get(0).getTimeValue();
                            system.setTaskResults(flowID, taskID, bcrt, wcrt, jitter);

                        }
                    }
                }
            }


        } catch (JAXBException e) {
            System.out.println("Error in results file: "+results.getAbsolutePath());
            e.printStackTrace();
        }
    }
}
