package es.unican.istr.rtgen.config;

/**
 * Created by juanm on 17/08/2015.
 */
public class PeriodConfig {

    private PeriodDistributionOptions distribution;
    private Double base;
    private Double ratio;

    public PeriodConfig(PeriodDistributionOptions distribution, Double base, Double ratio) {
        this.distribution = distribution;
        this.base = base;
        this.ratio = ratio;
    }

    public PeriodDistributionOptions getDistribution() {
        return distribution;
    }

    public void setDistribution(PeriodDistributionOptions distribution) {
        this.distribution = distribution;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
