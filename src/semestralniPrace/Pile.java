package semestralniPrace;

import java.awt.Component;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class Pile extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int group;
    private int countOfMatches;
    private boolean isEnable = true;


    public Pile(int maxMatches, int group) {
        this.group = group;

        setLayout(new MigLayout());

        countOfMatches = (int) (Math.random() * maxMatches) + 1;
        init(group);
    }


    private void init(int group) {
        for (int i = 0; i < countOfMatches; i++) {
            add(new Match(group));
        }
    }


    private void dispose() {
        getParent().remove(this);
    }


    public void setEnableMathes(boolean value) {
        for (Component item : getComponents()) {
            if (item instanceof Match) {
                item.setEnabled(value);
            }

        }
        this.isEnable = value;
    }


    public void removeMatches() {
        for (Component item : getComponents()) {
            if (item instanceof Match) {
                Match match = (Match) item;
                if (match.isSelected()) {
                    remove(match);
                    countDownMatches();
                    revalidate();
                }
            }
        }

    }


    public void countDownMatches() {
        if (countOfMatches-- < 0) {
            System.err.println("Chyba pocet zapalek nemuze byt mensi nez nula");
        }
        if (countOfMatches == 0) {
            dispose();
        }
    }


    public boolean getIsEnable() {
        return this.isEnable;
    }


    public int getGroup() {
        return this.group;
    }


    public int getCountOfMatches() {
        return this.countOfMatches;
    }

}
