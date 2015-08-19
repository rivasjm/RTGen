package es.unican.istr.rtgen.config;

/**
 * Created by juanm on 17/08/2015.
 */
public class UtilizationConfig {

    private Double start;
    private Double step;
    private Double top;

    private Double currentU; //Current utilization in the series

    private Double bcetFactor; //bcet = wcet*bcetFactor

    private WCETGenerationOptions wcetMethod;
    private LoadBalancingOptions balancing;

    public UtilizationConfig(Double start, Double step, Double top, Double bcetFactor, WCETGenerationOptions wcetMethod, LoadBalancingOptions balancing) {
        this.start = start;
        this.step = step;
        this.top = top;
        if ((bcetFactor <= 1.0) && (bcetFactor >= 0.0)) {
            this.bcetFactor = bcetFactor;
        } else {
            throw new IllegalArgumentException("BCET factor "+bcetFactor.toString()+ " not valid");
        }
        this.wcetMethod = wcetMethod;
        this.balancing = balancing;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getStep() {
        return step;
    }

    public void setStep(Double step) {
        this.step = step;
    }

    public Double getTop() {
        return top;
    }

    public void setTop(Double top) {
        this.top = top;
    }

    public Double getBcetFactor() {
        return bcetFactor;
    }

    public void setBcetFactor(Double bcetFactor) {
        this.bcetFactor = bcetFactor;
    }

    public WCETGenerationOptions getWcetMethod() {
        return wcetMethod;
    }

    public void setWcetMethod(WCETGenerationOptions wcetMethod) {
        this.wcetMethod = wcetMethod;
    }

    public LoadBalancingOptions getBalancing() {
        return balancing;
    }

    public void setBalancing(LoadBalancingOptions balancing) {
        this.balancing = balancing;
    }

    public Double getCurrentU() {
        return currentU;
    }

    public void setCurrentU(Double currentU) {
        this.currentU = currentU;
    }
}
