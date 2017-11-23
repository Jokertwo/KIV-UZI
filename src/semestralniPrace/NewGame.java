package semestralniPrace;

import javax.swing.JPanel;

/**
 * Vytvori novou hru
 * @author Petr
 *
 */
public class NewGame {

    Gui frame;


    public NewGame() {
        this.frame = (Gui) Gui.component.get(Helper.FRAME);
        createGame();
    }


    private void createGame() {
        GameDesk game = new GameDesk();
        // odstrani pripadne starou hraci plochu z framu
        removePanel();

        // prida novou hru do framu
        frame.add(game);
        // prida hru do mapy
        addPanel(game);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.revalidate();
        frame.repaint();

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
