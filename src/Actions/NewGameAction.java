package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
        
        panel.setLayout(new MigLayout());
        panel.add(new GameDesk());


        

        JButton remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        Helper.removeButton();
                    }
                });

            }
        });

        
        frame.add(panel,"wrap");
        frame.add(remove);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }


    private void removePanel() {
        if (Gui.getMap().containsKey(Helper.PANEL)) {
            frame.remove(Gui.getMap().get(Helper.PANEL));
        }
    }


    private void addPanel(JPanel panel) {
        Gui.getMap().put(Helper.PANEL, panel);
    }

}
