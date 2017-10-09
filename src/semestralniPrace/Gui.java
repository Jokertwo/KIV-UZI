package semestralniPrace;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import actions.ExitGameAction;
import net.miginfocom.swing.MigLayout;


public class Gui extends JFrame {

    public static Map<String, Component> component = new HashMap<>();
    public static Map<String, Integer> setting = new HashMap<>();

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("w 300,h 300"));
        component.put(Helper.FRAME, this);
        setJMenuBar(new MenuBar());
        setTitle("NIM - easy");
        pack();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener();

        
    }



    public void addWindowListener() {
//        addWindowListener(new ExitGameAction());
    }

}
