package semestralniPrace;

import java.awt.GridLayout;
import javax.swing.JPanel;


public class Pile extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int group;
    private boolean isEnable = true;


    public Pile(int maxMatches, int group) {
        this.group = group;

        setLayout(new GridLayout(0, maxMatches, 3, 0));
        init((int) (Math.random() * maxMatches) + 1, group);
    }


    private void init(int countOfMatches, int group) {
        for (int i = 0; i < countOfMatches; i++) {
            add(new Match(Integer.toString(i), group, this));
        }
    }


    public void setEnableMathes(boolean value) {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponent(i).setEnabled(value);
        }
        this.isEnable = value;
    }


    public boolean isSomeMatchSelect() {
        for (int i = 0; i < getComponentCount(); i++) {
            Match match = (Match) getComponent(i);
            if (match.isSelected()) {
                return true;
            }
        }
        return false;
    }


    public boolean getIsEnable() {
        return this.isEnable;
    }


    public int getGroup() {
        return this.group;
    }

}
