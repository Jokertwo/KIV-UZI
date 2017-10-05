package semestralniPrace;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Gui {

    static JFrame frame = new JFrame();
    static List<Pile> listOfPile = new ArrayList<>();
    static int countOfPile = 5;


    public static void createGame(int countOfPile) {

        for (int i = 0; i < countOfPile; i++) {
            JPanel panel = new JPanel();
            Pile pile = new Pile((int) (Math.random() * 6) + 1,i);
            panel.setLayout(new GridLayout(0, 6, 3, 0));
            List<Match> list = pile.getMatches();
            listOfPile.add(pile);
            for (Match item : list) {
                panel.add(item);
            }
            frame.add(panel);
        }
    }


    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Are you sure to close this window?", "Really Closing?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new GridLayout(countOfPile, 0, 10, 10));
        createGame(countOfPile);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}
