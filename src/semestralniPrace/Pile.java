package semestralniPrace;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import net.miginfocom.swing.MigLayout;


/**
 * Trida reprezentujici jednu hromadku obsahujici sirky
 * 
 * @author Petr
 *
 */

public class Pile extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int group;
    private int countOfMatches;
    private boolean isEnable = true;
    private JLabel label;
    public List<Match> matches;
    private static final Logger LOGGER = Logger.getLogger(Pile.class);


    public Pile(int group) {
        this.group = group;
        matches = new ArrayList<>();

        setLayout(new MigLayout());

        countOfMatches = (int) (Math.random() * Integer.parseInt(Helper.gameSetting.get(Helper.NUMBER_OF_MATCH))) + 1;
        init(group);
        LOGGER.debug("Hromadka " + group + " vytvorena.");
    }


    private void init(int group) {
        label = new JLabel(Integer.toString(countOfMatches));
        add(label);
        for (int i = 0; i < countOfMatches; i++) {
            Match match = new Match(group, i);

            add(match);
            matches.add(match);
            LOGGER.debug("Zapalka " + i + " z hromadky " + this.group + " vytvorena.");
        }
    }


    /**
     * Zdimne/uvolni vsechny zapalky v hromadce
     * 
     * @param value
     */
    public void setEnableMathes(boolean value) {
        for (Match item : matches) {
            item.setEnabled(value);
        }
        this.isEnable = value;
    }


    /**
     * Zjisti jestli je nejaka zapalka z hromadky oznacena
     * 
     * @return
     */
    public boolean isSomeMatchSelect() {
        for (Component item : getComponents()) {
            if (item instanceof Match) {
                if (((Match) item).isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Odstrani oznacene zapalky z hromadky
     */
    public void removeMatches() {
        for (Component item : getComponents()) {
            if (item instanceof Match) {
                if (((Match) item).isSelected()) {
                    remove(item);
                    label.setText(countDownMatches());
                    matches.remove(item);
                }
            }
        }
        revalidate();
        repaint();

    }


    /**
     * prida praydne tlacitku pro zachovani Layoutu ----- neni ro prilis stastne reseni------
     */
    public void addEmptyButton() {
        Match match = new Match(group, -1);
        match.setVisible(false);
        add(match);
    }


    /**
     * Pocet zbyvajicich zapalek v hromadce
     * 
     * @return
     */
    public int getLeftMatches() {
        return countOfMatches;
    }


    public String countDownMatches() {
        countOfMatches--;
        if (countOfMatches == 0) {
            addEmptyButton();
        }
        return Integer.toString(countOfMatches);
    }


    public boolean getIsEnable() {
        return this.isEnable;
    }


    public int getGroup() {
        return this.group;
    }

}
