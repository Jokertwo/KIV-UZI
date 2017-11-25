package algoritmusNim;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import semestralniPrace.Pile;


public class AlgoritmusHardOponent implements Algoritmus {
    private static final Logger log = Logger.getLogger(AlgoritmusHardOponent.class);
    private List<int[]> numberOfMatchesDec;
    private List<Pile> piles;
    private int[] move = new int[3];


    public AlgoritmusHardOponent() {
        numberOfMatchesDec = new ArrayList<int[]>();
    }


    @Override
    public int[] getMove(List<Pile> piles) {
        setPiles(piles);
        log.info("Zacinam hrat");
        init();
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
                    move[0] = temp[1] - tempXOR;
                    move[1] = temp[0];
                    move[2] = 1;
                    return move;
                }
            }
        }
        log.info("Pri soucasnem rozpolozeni zapalek nelze vyhrat !!!");
        return removeOneMatch();

    }


    public void setPiles(List<Pile> piles) {
        this.piles = piles;
    }


    /**
     * inicialize promenych potrebnych pro vypocet
     */
    @Override
    public void init() {
        numberOfMatchesDec.clear();
        for (Pile item : piles) {
            int[] temp = new int[3];
            temp[0] = item.getGroup();
            temp[1] = item.getLeftMatches();
            temp[2] = toBinary(item.getLeftMatches());
            numberOfMatchesDec.add(temp);
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
     * Pokud nelze vyhrat odebere pouze jednu zapalku prvni na kterou dorazi
     * 
     */
    private int[] removeOneMatch() {
        int[] data = new int[3];
        for (Pile pile : piles) {
            if (pile.getLeftMatches() > 0) {
                data[0] = pile.getGroup();
                data[1] = 1;
                data[2] = -1;
            }
        }
        return data;
    }


    /**
     * Informacni vypis do logu o aktualnim stavu
     */
    public void print() {
        log.debug("Reprezentace jednotlivych hromadek");
        for (int[] item : numberOfMatchesDec) {
            log.info(
                "skupina : " + item[0] + " pocet sirek " + item[1] + " pocet sirek binar " + item[2]);
        }
        log.info("Vysledsek : " + binaryXOR());

    }

}
