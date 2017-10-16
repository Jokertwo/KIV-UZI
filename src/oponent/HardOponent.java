package oponent;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import semestralniPrace.GameDesk;
import semestralniPrace.Match;
import semestralniPrace.Pile;


public class HardOponent implements Oponent {

    private static final Logger log = Logger.getLogger(HardOponent.class);

    private List<Pile> piles;
    private List<int[]> numberOfMatchesDec;


    @Override
    public void run() {
        init();
        print();
        startPlay();
    }


    @Override
    public void startPlay() {
        log.info("Zacinam hrat");
        int iXor = binaryXOR();
        log.info("Vysledek operace XOR je " + iXor);
        if (iXor != 0) {
            log.info("Prochazim vsechny hromadky a hledam schodne velke cislo (prvni jednicku ma stejnem miste)");
            for (int[] temp : numberOfMatchesDec) {
                if (checkNumber(iXor, temp[2])) {
                    log.info("Nasel jsem shodu. Hromadka s cislem : " + temp[0] + " a poctem sirek " + temp[1]);
                    int tempXOR = temp[2] ^ iXor;
                    log.info("Vysledek operace " + temp[2] + " XOR " + iXor + " je :" + tempXOR);
                    tempXOR = toDecimal(tempXOR);
                    log.info("Po prevodu do desitkove soustavy : " + tempXOR);
                    log.info("Musim tedy odebrat " + (temp[1] - tempXOR) + " zapalek z hromadky " + temp[0]);
                    chooseMatchesAndRemove(temp[1] - tempXOR, temp[0]);
                    return;
                }
            }
        } else {

            System.out.println("prd");
        }
    }


    private boolean checkNumber(int iXor, int numberToCompare) {


        String iXorRevers = ((new StringBuilder(Integer.toString(iXor)).reverse()).toString());
        log.debug("obraceny iXor : " + iXorRevers);
        String numberToCompareReverse = ((new StringBuilder(Integer.toString(numberToCompare)).reverse()).toString());
        log.debug("Obraceny numberToCompare : " + numberToCompareReverse);
        
        if(iXorRevers.length() > numberToCompareReverse.length()){
            return false;
        }
        
        if (iXorRevers.charAt(iXorRevers.length() - 1) == numberToCompareReverse.charAt(iXorRevers.length() - 1)) {
            return true;
        } else {
            return false;
        }

    }


    private void init() {
        numberOfMatchesDec = new ArrayList<int[]>();
        piles = GameDesk.piles;
        for (Pile item : piles) {
            int[] temp = new int[3];
            temp[0] = item.getGroup();
            temp[1] = item.getLeftMatches();
            temp[2] = toBinary(item.getLeftMatches());
            numberOfMatchesDec.add(temp);
        }
    }


    private void print() {
        log.debug("Reprezentace jednotlivych hromadek");
        for (int[] item : numberOfMatchesDec) {
            log.info(
                "skupina : " + item[0] + " pocet sirek " + item[1] + " pocet sirek binar " + item[2]);
        }
        log.info("Vysledsek : " + binaryXOR());

    }


    private int toBinary(int number) {
        int temp = -1;
        try{
        temp = Integer.parseInt(Integer.toString(number, 2));
        }catch(NumberFormatException e){
            log.error("Chyba pri prevodu desitkoveho cisla " +number+ " do binarnich cisel" ,e);
        }
        return temp;
    }


    private int toDecimal(int number) {
        int temp = -1;
        try{
            temp = Integer.parseInt(Integer.toString(number), 2);
        }catch(NumberFormatException e){
            log.error("Chyba pri prevodu binarniho cisla " + number+ " do desitkove soustavy");
        }
        return temp;
    }


    private int binaryXOR() {
        int result = 0;
        for (int[] item : numberOfMatchesDec) {
            result = result ^ item[2];
        }
        return result;
    }


    private void chooseMatchesAndRemove(int matches, int pileGroup) {
        log.debug("Prochazim vsechny hromadky a spravnou skupinu ( skupina + " + pileGroup + ")");
        for (Pile item : piles) {
            if (item.getGroup() == pileGroup) {
                log.info("Nasel jsem spravnou hromadku a zacim odebirat " + matches + " zapalek/ku.");
                int counter = 0;
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                for (Match match : item.matches) {

                    match.doClick();
                    counter++;

                    try {
                        log.debug("Docasne uspani vlakna");
                        Thread.sleep(900);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (counter >= matches) {
                        log.debug("Odebiram");
                        doClick();
                        init();
                        print();
                        return;
                    }
                }
            }
        }

        log.error("Chyba nenasel jsem spravnou hromadku!!");
    }

}
