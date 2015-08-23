package es.unican.istr.rtgen.tool.mast.config;

/**
 * Created by juanm on 19/08/2015.
 */
public class HOSPAConfig {

    public enum InitOptions{PD, NPD};

    private InitOptions init;
    private Double ka;
    private Double kr;
    private Integer iterations;
    private Integer overIterations;

    public HOSPAConfig() {
    }

    public HOSPAConfig(InitOptions init, Double ka, Double kr, Integer iterations, Integer overIterations) {
        this.init = init;
        this.ka = ka;
        this.kr = kr;
        this.iterations = iterations;
        this.overIterations = overIterations;
    }

    public InitOptions getInit() {
        return init;
    }

    public void setInit(InitOptions init) {
        this.init = init;
    }

    public Double getKa() {
        return ka;
    }

    public void setKa(Double ka) {
        this.ka = ka;
    }

    public Double getKr() {
        return kr;
    }

    public void setKr(Double kr) {
        this.kr = kr;
    }

    public Integer getIterations() {
        return iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public Integer getOverIterations() {
        return overIterations;
    }

    public void setOverIterations(Integer overIterations) {
        this.overIterations = overIterations;
    }
}
