package actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import semestralniPrace.Helper;
import semestralniPrace.Match;


public class MatchAction extends AbstractAction {

    private static final Logger LOG = Logger.getLogger(MatchAction.class);
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
            LOG.info("Byla OZNACENA zapalka " + absBtn.getID() + " z hromadky " + group);
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    if (!Helper.isSomeMatchInPileSelected(group)) {
                        Helper.enableButton(group);
                    }
                }
            });
            LOG.info("Byla ODZNACENA zapalka " + absBtn.getID() + " z hromadky " + group);

        }

    }

}
