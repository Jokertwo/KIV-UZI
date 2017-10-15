package oponent;

import org.apache.log4j.Logger;
import semestralniPrace.Helper;


public class Factory {

    private static final Logger LOG = Logger.getLogger(Factory.class);
    
    public Oponent getOponent() {

        String kindOfOponent = Helper.gameSetting.get(Helper.OPONENT);
        if (kindOfOponent.equals(Helper.HARD)) {
            LOG.info("Vytvarim tezkeho protivnika.");
            return new HardOponent();
        } else if (kindOfOponent.equals(Helper.MEDIUM)) {
            LOG.info("Vytvarim stredne tezkeho protivnika.");
            return null;
        } else {
            LOG.info("Vytvarim lehkeho protivnika.");
            return new EasyOponent();
            
        }
    }

}
