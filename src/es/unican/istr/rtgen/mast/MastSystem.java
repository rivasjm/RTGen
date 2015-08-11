package es.unican.istr.rtgen.mast;

import es.unican.istr.rtgen.elements.LinearSystem;

import java.io.File;

/**
 * Created by juanm on 11/08/2015.
 */
public class MastSystem extends LinearSystem {

    @Override
    public void writeSystem(File f) {
        System.out.println("MAST System Class");
    }
}
