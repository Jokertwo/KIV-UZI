package semestralniPrace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import net.miginfocom.swing.MigLayout;
import oponent.Factory;
import oponent.Oponent;


/**
 * Trida reprezentujici hraci plochu
 * 
 * @author Petr
 *
 */
public class GameDesk extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static List<Pile> piles;
    private Oponent oponent;
    private final static Logger LOGGER = Logger.getLogger(GameDesk.class);
    private JButton remove;


    public GameDesk() {
        LOGGER.debug("Inicializace tridy GameDesk.java");
        setLayout(new MigLayout());
        createGameDesk();
        add(addRemoveButton());
        oponent = new Factory().getOponent();
    }


    /**
     * Vytvoreni hraci plochy
     */
    private void createGameDesk() {

        int countOfPile = Integer.parseInt(Helper.gameSetting.get(Helper.NUMBER_OF_PILE));
        LOGGER.debug("Vytvarim hraci plochu s " + countOfPile + " hromadkami.");
        piles = new ArrayList<>();
        for (int group = 0; group < countOfPile; group++) {
            Pile pile = new Pile(group);
            add(pile, "wrap");
            piles.add(pile);

        }

    }


    /**
     * pridani tlacika pro odebrani zapalek
     * 
     * @return
     */
    private JButton addRemoveButton() {
        remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Helper.removeButton();
                // check if player wins
                if (!checkWin()) {
                    oponent.setRemove(remove);
                    Thread thread = new Thread((Runnable) oponent);
                    thread.start();

                } else {
                    informAboutWin("Player");
                    remove.setEnabled(false);
                }
            }
        });
        return remove;
    }


    /**
     * informace o vitezstvi
     * @param name
     */
    private void informAboutWin(String name) {
        JOptionPane.showMessageDialog(null, name + " win's!!!!!");
    }


    /**
     * kontrola jestli zbyvaji jeste nejake zapalky
     * @return
     */
    private boolean checkWin() {
        int sum = 0;
        for (Pile pile : piles) {
            sum += pile.getLeftMatches();
        }
        if (sum > 0) {
            return false;
        }
        return true;
    }

}
