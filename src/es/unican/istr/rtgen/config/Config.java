package es.unican.istr.rtgen.config;

/**
 * Created by juanm on 17/08/2015.
 */
public class Config {

    private Integer nProcs;
    private Integer nFlows;
    private Integer nTasks;
    private Boolean randomLength;
    private Double monoFlows;
    private String schedPolicy;

    private PeriodConfig period;
    private DeadlineConfig deadline;
    private LocalizationOptions localization;
    private UtilizationConfig utilization;

    public Config(Integer nProcs, Integer nFlows, Integer nTasks, Boolean randomLength, Double monoFlows, String schedPolicy, PeriodConfig period, DeadlineConfig deadline, LocalizationOptions localization, UtilizationConfig utilization) {
        this.nProcs = nProcs;
        this.nFlows = nFlows;
        this.nTasks = nTasks;
        this.randomLength = randomLength;
        this.monoFlows = monoFlows;
        this.schedPolicy = schedPolicy;
        this.period = period;
        this.deadline = deadline;
        this.localization = localization;
        this.utilization = utilization;
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

    public Double getMonoFlows() {
        return monoFlows;
    }

    public Boolean getRandomLength() {
        return randomLength;
    }

    public void setRandomLength(Boolean randomLength) {
        this.randomLength = randomLength;
    }

    public void setMonoFlows(Double monoFlows) {
        this.monoFlows = monoFlows;
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
