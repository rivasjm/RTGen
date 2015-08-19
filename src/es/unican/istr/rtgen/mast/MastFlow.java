package es.unican.istr.rtgen.mast;

import es.unican.istr.rtgen.elements.Flow;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public class MastFlow extends Flow {

    @Override
    public void writeFlow(OutputStream o) {
        System.out.println("MAST Flow Class");
    }

    public void writeOperations(PrintWriter pw) {
        for (MastTask mt: (List<MastTask>) getTasks()) {
            mt.writeOperation(pw);
        }
    }

    public void writeSchedulingServers(PrintWriter pw) {
        for (MastTask mt: (List<MastTask>) getTasks()) {
            mt.writeSchedulingServer(pw);
        }
    }
}
