package es.unican.istr.rtgen.system.elements.config;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by juanm on 18/08/2015.
 */
public class DeadlineConfig {

    private DeadlineOptions value;
    private Float valueK;

    public DeadlineConfig(String s) {
        try {
            value = DeadlineOptions.valueOf(s);
            if (value == DeadlineOptions.K) {
                throw new IllegalArgumentException("Value K is not a valid Deadline (Hint: replace K with a number");
            }
        } catch (IllegalArgumentException e){
            if (NumberUtils.isNumber(s)) {
                valueK = Float.valueOf(s);
                value = DeadlineOptions.K;
            } else {
                throw new IllegalArgumentException("Value "+s+" not a valid Deadline");
            }
        }
    }

    public DeadlineOptions getValue() {
        return value;
    }

    public void setValue(DeadlineOptions value) {
        this.value = value;
    }

    public Float getValueK() {
        return valueK;
    }

    public void setValueK(Float valueK) {
        this.valueK = valueK;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
