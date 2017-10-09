package semestralniPrace;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
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
    private JLabel label;
    public List<Match> matches;


    public Pile(int group) {
        this.group = group;
        matches = new ArrayList<>();

        setLayout(new MigLayout());

        countOfMatches = (int) (Math.random() * Integer.parseInt(Helper.gameSetting.get(Helper.NUMBER_OF_MATCH))) + 1;
        init(group);
    }


    private void init(int group) {
        label = new JLabel(Integer.toString(countOfMatches));
        add(label);
        for (int i = 0; i < countOfMatches; i++) {
            Match match = new Match(group);
            add(match);
            matches.add(match);
        }
    }


    public void setEnableMathes(boolean value) {
        for (Match item : matches) {
            item.setEnabled(value);
        }
        this.isEnable = value;
    }


    public void removeMatches() {
        for (Component item : getComponents()) {
            if (item instanceof Match) {
                Match match = (Match) item;
                if (match.isSelected()) {
                    remove(match);
                    label.setText(countDownMatches());
                    revalidate();
                    repaint();
                    matches.remove(match);
                }
            }
        }

    }


    public void addEmptyButton() {
        Match match = new Match(group);
        match.setVisible(false);
        add(match);
    }


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


    public int getCountOfMatches() {
        return this.countOfMatches;
    }

}
