package es.unican.istr.rtgen.system.elements.config;

/**
 * Created by juanm on 17/08/2015.
 */
public enum LoadBalancingOptions {
    BALANCED(0), NON_BALANCED(1);

    private final int value;

    LoadBalancingOptions(int i) {
        value = i;
    }

    public int getValue(){ return value; }
}
