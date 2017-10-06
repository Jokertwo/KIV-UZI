package semestralniPrace;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import actions.ExitGameAction;
import net.miginfocom.swing.MigLayout;


public class Gui extends JFrame {

    private static Map<String, JPanel> map = new HashMap<>();

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public Gui() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new MigLayout("w 300,h 300"));
        setJMenuBar(new MenuBar(this));

        pack();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener();

    }


    public static Map<String, JPanel> getMap() {
        return Gui.map;
    }


    public void addWindowListener() {
        addWindowListener(new ExitGameAction());
    }

}
