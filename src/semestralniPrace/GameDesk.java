package semestralniPrace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;


public class GameDesk extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int countOfPile = 9;
    private static List<Pile> piles;


    public GameDesk() {
        setLayout(new MigLayout());
        createGameDesk(countOfPile);
        add(addRemoveButton());
    }
    
    public static List<Pile> getPileList(){
        return piles;
    }


    public void createGameDesk(int countOfPile) {
        piles = new ArrayList<>();
        for (int i = 0; i < countOfPile; i++) {
            Pile pile = new Pile(countOfPile, i);
            add(pile,"wrap");
            piles.add(pile);
        }
        
    }
    
    public JButton addRemoveButton(){
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
        return remove;
    }

}
