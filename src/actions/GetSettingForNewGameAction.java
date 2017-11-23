package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import semestralniPrace.Gui;
import semestralniPrace.Helper;
import semestralniPrace.SettingGame;

/**
 * Vztvori panel s nastavenim hry a nasledne vytvori nou hru
 *  ---- > kdyz se na to ted koukam zaslozilo bz to predelat protoze takovzto mechanizmus by v akci asi nemel byt
 * @author Petr
 *
 */

public class GetSettingForNewGameAction implements ActionListener {

    Gui frame;


    public GetSettingForNewGameAction() {
        this.frame = (Gui) Gui.component.get(Helper.FRAME);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        createGame();
    }


    private void createGame() {

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


    private void removePanel() {
        if (Gui.component.containsKey(Helper.PANEL)) {
            frame.remove(Gui.component.get(Helper.PANEL));
        }
    }


    private void addPanel(JPanel panel) {
        Gui.component.put(Helper.PANEL, panel);
    }

}
