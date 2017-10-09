package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import semestralniPrace.GameDesk;
import semestralniPrace.Gui;
import semestralniPrace.Helper;
import semestralniPrace.SettingGame;


public class NewGameAction implements ActionListener {

    Gui frame;


    public NewGameAction() {
        this.frame = (Gui)Gui.component.get(Helper.FRAME);;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        createGame();
    }


    private void createGame() {
        // vytvori novou hraci plochu
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SettingGame game = new SettingGame();
                // odstrani pripadne starou hraci plochu z framu
                removePanel();

                // prida novou hru do framu
                frame.add(game);
                // prida hru do mapy
                addPanel(game);

                frame.pack();
                frame.setLocationRelativeTo(null);
            }
        });
    }


    private void removePanel() {
        if (Gui.component.containsKey(Helper.PANEL)) {
            frame.remove(Gui.component.get(Helper.PANEL));
        }
    }


    private void addPanel(JPanel panel) {
        Gui.component.put(Helper.PANEL, panel);
    }

}
