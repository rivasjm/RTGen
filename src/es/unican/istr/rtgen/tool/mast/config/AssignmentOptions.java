package es.unican.istr.rtgen.tool.mast.config;

/**
 * Created by juanm on 19/08/2015.
 */
public enum AssignmentOptions {
    UD, ED, PD, NPD, EQS, EQF, HOSPA;

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
