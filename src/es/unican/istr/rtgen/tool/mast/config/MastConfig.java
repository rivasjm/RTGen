package es.unican.istr.rtgen.tool.mast.config;

import es.unican.istr.rtgen.tool.elements.config.RTToolConfig;

/**
 * Created by juanm on 19/08/2015.
 */
public class MastConfig implements RTToolConfig {

    private String name;
    private String workPath;
    private String mastPath;
    private AnalysisOptions analysis;
    private Boolean sync;
    private AssignmentOptions assignment;
    private HOSPAConfig hospaConfig;
    private Float stopFactor;
    private Boolean gsd;        //Forces Global Scheduling Deadlines in local clock EDF
    private Float dsFactor;     //Scaling factor for LC-EDF-DS
    private Boolean calculateSlack;
    private Boolean jitterAvoidance;

    public MastConfig(MastToolConfigurableMap map) {
        // TODO
    }

    public MastConfig(String name, String workPath, String mastPath, AnalysisOptions analysis, Boolean sync, AssignmentOptions assignment, HOSPAConfig hospaConfig, Float stopFactor, Boolean gsd, Float dsFactor, Boolean calculateSlack, Boolean jitterAvoidance) {
        this.name = name;
        this.workPath = workPath;
        this.mastPath = mastPath;
        this.analysis = analysis;
        this.sync = sync;
        this.assignment = assignment;
        this.hospaConfig = hospaConfig;
        this.stopFactor = stopFactor;
        this.gsd = gsd;
        this.dsFactor = dsFactor;
        this.calculateSlack = calculateSlack;
        this.jitterAvoidance = jitterAvoidance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }

    public String getMastPath() {
        return mastPath;
    }

    public void setMastPath(String mastPath) {
        this.mastPath = mastPath;
    }

    public AnalysisOptions getAnalysis() {
        return analysis;
    }

    public void setAnalysis(AnalysisOptions analysis) {
        this.analysis = analysis;
    }

    public Boolean getSync() {
        return sync;
    }

    public void setSync(Boolean sync) {
        this.sync = sync;
    }

    public AssignmentOptions getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentOptions assignment) {
        this.assignment = assignment;
    }

    public HOSPAConfig getHospaConfig() {
        return hospaConfig;
    }

    public void setHospaConfig(HOSPAConfig hospaConfig) {
        this.hospaConfig = hospaConfig;
    }

    public Float getStopFactor() {
        return stopFactor;
    }

    public void setStopFactor(Float stopFactor) {
        this.stopFactor = stopFactor;
    }

    public Boolean getGsd() {
        return gsd;
    }

    public void setGsd(Boolean gsd) {
        this.gsd = gsd;
    }

    public Float getDsFactor() {
        return dsFactor;
    }

    public void setDsFactor(Float dsFactor) {
        this.dsFactor = dsFactor;
    }

    public Boolean getCalculateSlack() {
        return calculateSlack;
    }

    public void setCalculateSlack(Boolean calculateSlack) {
        this.calculateSlack = calculateSlack;
    }

    public Boolean getJitterAvoidance() {
        return jitterAvoidance;
    }

    public void setJitterAvoidance(Boolean jitterAvoidance) {
        this.jitterAvoidance = jitterAvoidance;
    }
}
