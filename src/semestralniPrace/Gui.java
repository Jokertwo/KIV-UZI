package semestralniPrace;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.BasicConfigurator;
import net.miginfocom.swing.MigLayout;


/**
 * Trida reprezentujici frame ve kterem se stridaji jednotlive panely
 * 
 * @author Petr
 *
 */
public class Gui extends JFrame {

    public static Map<String, Component> component = new HashMap<>();
    public static Map<String, Integer> setting = new HashMap<>();

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    public Gui() {
        BasicConfigurator.configure();
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("w 300,h 300"));
        component.put(Helper.FRAME, this);
        setJMenuBar(new MenuBar());
        setTitle("NIM");
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
