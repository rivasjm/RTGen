package es.unican.istr.rtgen.utils;

import java.io.*;

/**
 * Created by JuanCTR on 03/09/2015.
 */
public class Utils {

    public static byte[] doublesToBytes(double[] values) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        for(int i=0; i < values.length; ++i)
        {
            try {
                dos.writeDouble(values[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }

    public static double[] bytesToDoubles(byte[] values) {
        ByteArrayInputStream bais = new ByteArrayInputStream(values);
        DataInputStream dis = new DataInputStream(bais);

        double[] d = new double[values.length/8]; // 1 double = 8 bytes
        for (int i=0; i<d.length;i++) {
            try {
                d[i] = dis.readDouble();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return d;
    }
}
