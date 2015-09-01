package es.unican.istr.rtgen.tool.mast.config;


import es.unican.istr.rtgen.exceptions.ConfigurableOptionNotSet;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by JuanCTR on 01/09/2015.
 */
public class MastToolConfigurableMap extends EnumMap<MastToolConfigurableOptions, String> {

    public MastToolConfigurableMap (Map<MastToolConfigurableOptions, String> map) throws ConfigurableOptionNotSet{
        super(MastToolConfigurableOptions.class);
        for (MastToolConfigurableOptions key: MastToolConfigurableOptions.values()){
            if (!map.containsKey(key)){
                throw new ConfigurableOptionNotSet();
            } else this.put(key, map.get(key));
        }
    }
}
