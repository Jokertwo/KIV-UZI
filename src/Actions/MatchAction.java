package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import semestralniPrace.Helper;
import semestralniPrace.Match;


public class MatchAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int group;


    public MatchAction(int group) {
        this.group = group;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Match absBtn = (Match) e.getSource();

        if (absBtn.getModel().isSelected()) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    Helper.disableButton(group);

                }
            });

        } else {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    Helper.enableButton(group);
                }
            });

        }

    }

}
