package oponent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import algoritmusNim.Algoritmus;
import semestralniPrace.GameDesk;
import semestralniPrace.Helper;
import semestralniPrace.Match;
import semestralniPrace.Pile;


/**
 * Trida reprezentujici tezkeho protihrace
 * 
 * @author Petr
 *
 */

public class OponentImpl implements Oponent {

    private static final Logger log = Logger.getLogger(OponentImpl.class);
    private JButton remove;

    private Algoritmus algoritmus;


    public OponentImpl(Algoritmus algoritmus) {
        this.algoritmus = algoritmus;
    }


    @Override
    public void startPlay() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                remove.setEnabled(false);
                chooseMatchesAndRemove(algoritmus.getMove(GameDesk.piles));
                if (checkWin()) {
                    informAboutWin();
                    return;
                }
                remove.setEnabled(true);
            }
        });
        thread.start();

    }


    /**
     * Oznaci a odebere zapalky
     * 
     * @param matches
     *            pocet zapalek ktere maji byt oznaceny a odebrany
     * @param pileGroup
     *            ze ktere hromadky se bude odebirat
     */
    private void chooseMatchesAndRemove(int[] move) {
        int matches = move[0];
        int pileGroup = move[1];
        log.debug("Prochazim vsechny hromadky a spravnou skupinu ( skupina " + pileGroup + ")");
        for (Pile item : GameDesk.piles) {
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
                        algoritmus.init();
                        algoritmus.print();
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


    private void doClick() {
        Helper.removeButton();
    }


    private boolean checkWin() {
        int sum = 0;
        for (Pile pile : GameDesk.piles) {
            sum += pile.getLeftMatches();
        }
        if (sum > 0) {
            return false;
        }
        return true;
    }


    private void informAboutWin() {
        JOptionPane.showMessageDialog(null, Helper.gameSetting.get(Helper.OPONENT) + " win's!!!!!");
    }

}
