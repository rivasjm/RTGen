package es.unican.istr.rtgen.tool.mast.config;

/**
 * Created by juanm on 19/08/2015.
 */
public enum AssignmentOptions {
    UD(0), ED(1), PD(2), NPD(3), EQS(4), EQF(5), HOSPA(6);

    private final int value;

    AssignmentOptions(int i) {
        value = i;
    }

    public int getValue() { return value; }

    public static String mapArg(AssignmentOptions a) {
        switch (a) {
            case ED: return "-p -t ed";
            case UD: return "-p -t ud";
            case PD: return "-p -t pd";
            case NPD: return "-p -t npd";
            case EQS: return "-p -t eqs";
            case EQF: return "-p -t eqf";
            case HOSPA: return "-p -t hospa";
            default: return "-p -t pd";
        }
    }
}
