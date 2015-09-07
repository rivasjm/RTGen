package es.unican.istr.gen4mast.config;


import es.unican.istr.rtgen.system.elements.config.LinearSystemConfigurableOptions;
import es.unican.istr.rtgen.tool.mast.config.MastToolConfigurableOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Properties;

/**
 * Created by JuanCTR on 07/09/2015.
 */
public class ConfigHandler {

    public static void getConfig() {

        // Set of enums, ordered as in the enum definition
        EnumSet<LinearSystemConfigurableOptions> systemOptionsSet = EnumSet.allOf(LinearSystemConfigurableOptions.class);
        EnumSet<MastToolConfigurableOptions> mastOptionsSet = EnumSet.allOf(MastToolConfigurableOptions.class);

        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("gen4mast.properties");
            prop.load(input);
            input.close();

            for (Object o: prop.keySet()){
                System.out.println(o);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        getConfig();
    }


}
