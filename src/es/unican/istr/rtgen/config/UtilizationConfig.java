package es.unican.istr.rtgen.config;

/**
 * Created by juanm on 17/08/2015.
 */
public class UtilizationConfig {

    private Integer start;
    private Integer step;
    private Integer top;

    private WCETGenerationOptions wcetMethod;
    private LoadBalancingOptions balancing;

    public UtilizationConfig(Integer start, Integer step, Integer top, WCETGenerationOptions wcetMethod, LoadBalancingOptions balancing) {
        this.start = start;
        this.step = step;
        this.top = top;
        this.wcetMethod = wcetMethod;
        this.balancing = balancing;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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
}
