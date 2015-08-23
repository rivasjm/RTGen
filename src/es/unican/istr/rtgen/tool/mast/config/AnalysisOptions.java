package es.unican.istr.rtgen.tool.mast.config;

/**
 * Created by juanm on 19/08/2015.
 */
public enum AnalysisOptions {
    HOLISTIC, OFFSET, OFFSET_OPT, OFFSET_SLANTED, BRUTE_FORCE;

    public static String mapArg(AnalysisOptions a) {
        switch (a) {
            case BRUTE_FORCE:
                return "offset_based_brute_force";
            case HOLISTIC:
                return "holistic";
            case OFFSET:
                return "offset_based_approx";
            case OFFSET_OPT:
                return "offset_based_approx_w_pr";
            case OFFSET_SLANTED:
                return "offset_based_slanted";
            default:
                return "default";
        }
    }
}
