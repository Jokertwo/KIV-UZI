package semestralniPrace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;


public class MatchAction implements ActionListener {

    Match match;


    public MatchAction(Match match) {
        this.match = match;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton absBtn = (AbstractButton) e.getSource();

        if (absBtn.getModel().isSelected()) {
            match.setForeground(Color.RED);
        } else {
            match.setForeground(null);
        }

    }

}
