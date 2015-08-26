package es.unican.istr.rtgen.tool.mast.config;

import es.unican.istr.rtgen.tool.elements.config.RTToolConfig;

/**
 * Created by juanm on 19/08/2015.
 */
public class MastConfig implements RTToolConfig {

    private String workPath;
    private String mastPath;
    private AnalysisOptions analysis;
    private Boolean sync;
    private AssignmentOptions assignment;
    private HOSPAConfig hospaConfig;
    private Double stopFactor;
    private Boolean gsd;        //Forces Global Scheduling Deadlines in local clock EDF
    private Double dsFactor;     //Scaling factor for LC-EDF-DS
    private Boolean calculateSlack;
    private Boolean jitterAvoidance;


    public MastConfig(String workPath, String mastPath, AnalysisOptions analysis, Boolean sync, AssignmentOptions assignment, HOSPAConfig hospaConfig, Double stopFactor, Boolean gsd, Double dsFactor, Boolean calculateSlack, Boolean jitterAvoidance) {
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

    public Double getStopFactor() {
        return stopFactor;
    }

    public void setStopFactor(Double stopFactor) {
        this.stopFactor = stopFactor;
    }

    public Boolean getGsd() {
        return gsd;
    }

    public void setGsd(Boolean gsd) {
        this.gsd = gsd;
    }

    public Double getDsFactor() {
        return dsFactor;
    }

    public void setDsFactor(Double dsFactor) {
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