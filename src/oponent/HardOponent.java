package oponent;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import org.apache.log4j.Logger;
import semestralniPrace.GameDesk;
import semestralniPrace.Match;
import semestralniPrace.Pile;

/**
 * Trida reprezentujici tezkeho protihrace
 * 
 * @author Petr
 *
 */

public class HardOponent implements Oponent {

    private static final Logger log = Logger.getLogger(HardOponent.class);

    private List<Pile> piles;
    private List<int[]> numberOfMatchesDec;
    private JButton remove;


    @Override
    public void run() {
        init();
        print();
        startPlay();
    }


    @Override
    public void startPlay() {
        remove.setEnabled(false);
        log.info("Zacinam hrat");
        int iXor = binaryXOR();
        log.info("Vysledek operace XOR je " + iXor);
        if (iXor != 0) {
            log.info("Prochazim vsechny hromadky a hledam schodne velke cislo (prvni jednicku ma stejne pozici)");
            for (int[] temp : numberOfMatchesDec) {
                if (checkNumber(iXor, temp[2])) {
                    log.info("Nasel jsem shodu. Hromadka s cislem : " + temp[0] + " a poctem sirek " + temp[1]);
                    int tempXOR = temp[2] ^ iXor;
                    log.info("Vysledek operace " + temp[2] + " XOR " + iXor + " je :" + tempXOR);
                    tempXOR = toDecimal(tempXOR);
                    log.info("Po prevodu do desitkove soustavy : " + tempXOR);
                    log.info("Musim tedy odebrat " + (temp[1] - tempXOR) + " zapalek z hromadky " + temp[0]);
                    chooseMatchesAndRemove(temp[1] - tempXOR, temp[0]);
                    if (checkWin()) {
                        informAboutWin("Hard oponent");
                        return;
                    }
                    remove.setEnabled(true);
                    return;
                }
            }
        } else {
            log.info("Pri soucasnem rozpolozeni zapalek nelze vyhrat !!!");
            removeOneMatch();
            remove.setEnabled(true);
        }
    }


    /**
     * porovna dve binarni cisla a hleda shodu na pozici kde se nachazi 1
     * 
     * @param iXor
     *            prvni cislo (vysledek operace XOR)
     * @param numberToCompare
     *            pocet zapalek v dane hromadce
     * @return vraci true nalezne-li shodu
     */
    private boolean checkNumber(int iXor, int numberToCompare) {
        String iXorRevers = ((new StringBuilder(Integer.toString(iXor)).reverse()).toString());
        log.debug("obraceny iXor : " + iXorRevers);
        String numberToCompareReverse = ((new StringBuilder(Integer.toString(numberToCompare)).reverse()).toString());
        log.debug("Obraceny numberToCompare : " + numberToCompareReverse);

        if (iXorRevers.length() > numberToCompareReverse.length()) {
            return false;
        }

        if (iXorRevers.charAt(iXorRevers.length() - 1) == numberToCompareReverse.charAt(iXorRevers.length() - 1)) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * inicialize promenych potrebnych pro vypocet
     */
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


    /**
     * Informacni vypis do logu o aktualnim stavu
     */
    private void print() {
        log.debug("Reprezentace jednotlivych hromadek");
        for (int[] item : numberOfMatchesDec) {
            log.info(
                "skupina : " + item[0] + " pocet sirek " + item[1] + " pocet sirek binar " + item[2]);
        }
        log.info("Vysledsek : " + binaryXOR());

    }


    /**
     * Prevede cislo z decimani do binarni soustavy
     * 
     * @param number
     *            decimalni cislo
     * @return binarni cislo
     */
    private int toBinary(int number) {
        int temp = -1;
        try {
            temp = Integer.parseInt(Integer.toString(number, 2));
        } catch (NumberFormatException e) {
            log.error("Chyba pri prevodu desitkoveho cisla " + number + " do binarnich cisel", e);
        }
        return temp;
    }


    /**
     * Prevede cislo z binarni do decimalni soustavy
     * 
     * @param number
     *            binarni cislo
     * @return decimalni cislo
     */
    private int toDecimal(int number) {
        int temp = -1;
        try {
            temp = Integer.parseInt(Integer.toString(number), 2);
        } catch (NumberFormatException e) {
            log.error("Chyba pri prevodu binarniho cisla " + number + " do desitkove soustavy");
        }
        return temp;
    }


    /**
     * Provede operaci XOR nad vsemi hromadkami na stole
     * 
     * @return
     */
    private int binaryXOR() {
        int result = 0;
        for (int[] item : numberOfMatchesDec) {
            result = result ^ item[2];
        }
        return result;
    }


    /**
     * Odebere jednu zapalku z prvni hromadky ktera obsahuje alespon jednu zalapku
     * 
     */
    private void removeOneMatch() {
        for (Pile pile : piles) {
            if (pile.getLeftMatches() > 0) {
                // clic on the match
                pile.matches.get(0).doClick();
                // click on the button remove
                doClick();
                return;
            }
        }
    }


    /**
     * Oznaci a odebere zapalky
     * 
     * @param matches
     *            pocet zapalek ktere maji byt oznaceny a odebrany
     * @param pileGroup
     *            ze ktere hromadky se bude odebirat
     */
    private void chooseMatchesAndRemove(int matches, int pileGroup) {
        log.debug("Prochazim vsechny hromadky a spravnou skupinu ( skupina " + pileGroup + ")");
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


    @Override
    public void setRemove(JButton remove) {
        this.remove = remove;

    }

}
