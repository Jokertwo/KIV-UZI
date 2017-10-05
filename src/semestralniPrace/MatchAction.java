package semestralniPrace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;


public class MatchAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int group;

    public MatchAction(String title,int group) {
        super(title);
        this.group = group;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Match absBtn = (Match) e.getSource();

        if (absBtn.getModel().isSelected()) {
            absBtn.setForeground(Color.RED);
            Helper.disableButton(this.group);
            
        } else {
            absBtn.setForeground(null);
            Helper.enableButton(this.group);
        }

    }

}
