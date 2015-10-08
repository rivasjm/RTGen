package es.unican.istr.rtgen.system.elements.config;

import es.unican.istr.rtgen.system.elements.config.deadline.DeadlineConfig;
import es.unican.istr.rtgen.system.elements.config.load.UtilizationConfig;
import es.unican.istr.rtgen.system.elements.config.localization.LocalizationOptions;
import es.unican.istr.rtgen.system.elements.config.period.PeriodConfig;

/**
 * Created by juanm on 17/08/2015.
 */
public class SystemConfig {

    private Integer seed;
    private Integer nProcs;
    private Integer nFlows;
    private Integer nTasks;
    private Boolean randomLength;
    private Float singleFlows;
    private String schedPolicy;

    private PeriodConfig period;
    private DeadlineConfig deadline;
    private LocalizationOptions localization;
    private UtilizationConfig utilization;


    public SystemConfig(LinearSystemConfigurableMap map){
        // TODO
    }

    public SystemConfig(Integer theSeed, Integer nProcs, Integer nFlows, Integer nTasks, Boolean randomLength, Float singleFlows, String schedPolicy, PeriodConfig period, DeadlineConfig deadline, LocalizationOptions localization, UtilizationConfig utilization) {
        this.seed = theSeed;
        this.nProcs = nProcs;
        this.nFlows = nFlows;
        this.nTasks = nTasks;
        this.randomLength = randomLength;
        this.singleFlows = singleFlows;
        this.schedPolicy = schedPolicy;
        this.period = period;
        this.deadline = deadline;
        this.localization = localization;
        this.utilization = utilization;
    }

    public SystemConfig() {
        super();
    }
//
//    public LinearSystemConfigurableMap getMap(){
//        LinearSystemConfigurableMap map = new LinearSystemConfigurableMap();
//
//        map.put(LinearSystemConfigurableOptions.SEED, seed.toString());
//        map.put(LinearSystemConfigurableOptions.N_PROCESSORS, nProcs.toString());
//        map.put(LinearSystemConfigurableOptions.N_FLOWS, nFlows.toString());
//        map.put(LinearSystemConfigurableOptions.N_TASKS, nTasks.toString());
//        map.put(LinearSystemConfigurableOptions.RANDOM_LENGTH, randomLength.toString());
//
//
//        return map;
//    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public Integer getnProcs() {
        return nProcs;
    }

    public void setnProcs(Integer nProcs) {
        this.nProcs = nProcs;
    }

    public Integer getnFlows() {
        return nFlows;
    }

    public void setnFlows(Integer nFlows) {
        this.nFlows = nFlows;
    }

    public Integer getnTasks() {
        return nTasks;
    }

    public void setnTasks(Integer nTasks) {
        this.nTasks = nTasks;
    }

    public Float getSingleFlows() {
        return singleFlows;
    }

    public Boolean getRandomLength() {
        return randomLength;
    }

    public void setRandomLength(Boolean randomLength) {
        this.randomLength = randomLength;
    }

    public void setSingleFlows(Float singleFlows) {
        this.singleFlows = singleFlows;
    }

    public String getSchedPolicy() {
        return schedPolicy;
    }

    public void setSchedPolicy(String schedPolicy) {
        this.schedPolicy = schedPolicy;
    }

    public PeriodConfig getPeriod() {
        return period;
    }

    public void setPeriod(PeriodConfig period) {
        this.period = period;
    }

    public DeadlineConfig getDeadline() {
        return deadline;
    }

    public void setDeadline(DeadlineConfig deadline) {
        this.deadline = deadline;
    }

    public LocalizationOptions getLocalization() {
        return localization;
    }

    public void setLocalization(LocalizationOptions localization) {
        this.localization = localization;
    }

    public UtilizationConfig getUtilization() {
        return utilization;
    }

    public void setUtilization(UtilizationConfig utilization) {
        this.utilization = utilization;
    }

}
