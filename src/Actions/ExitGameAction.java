package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class ExitGameAction extends WindowAdapter implements ActionListener {

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if (exitDialog()) {
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (exitDialog()) {
            System.exit(0);
        }

    }


    public boolean exitDialog() {
        if (JOptionPane.showConfirmDialog(null,
            "Are you sure to close this window?", "Really Closing?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

}
