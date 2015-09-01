package es.unican.istr.rtgen.tool.mast.config;

/**
 * Created by juanm on 19/08/2015.
 */
public class HOSPAConfig {

    public enum InitOptions{PD(0), NPD(1);
        private final int value;
        InitOptions(int i) {
            value = i;
        }
        public int getValue() { return value; }
    };

    private InitOptions init;
    private Float ka;
    private Float kr;
    private Integer iterations;
    private Integer overIterations;

    public HOSPAConfig() {
    }

    public HOSPAConfig(InitOptions init, Float ka, Float kr, Integer iterations, Integer overIterations) {
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

    public Float getKa() {
        return ka;
    }

    public void setKa(Float ka) {
        this.ka = ka;
    }

    public Float getKr() {
        return kr;
    }

    public void setKr(Float kr) {
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
