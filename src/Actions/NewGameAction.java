package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import semestralniPrace.GameDesk;
import semestralniPrace.Gui;
import semestralniPrace.Helper;


public class NewGameAction implements ActionListener {

    Gui frame;


    public NewGameAction(Gui frame) {
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JPanel panel = new JPanel();
        panel.add(new GameDesk());
        panel.setLayout(new MigLayout());
        removePanel();
        frame.add(panel);
        addPanel(panel);
        frame.pack();
    }


    private void removePanel() {
        if (frame.getMap().containsKey(Helper.PANEL)) {
            frame.remove(frame.getMap().get(Helper.PANEL));
        }
    }


    private void addPanel(JPanel panel) {
        frame.getMap().put(Helper.PANEL, panel);
    }

}
