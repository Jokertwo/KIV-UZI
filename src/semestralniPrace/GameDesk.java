package semestralniPrace;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


public class GameDesk extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int countOfPile = 5;
    private static List<Pile> piles;


    public GameDesk() {
        setLayout(new GridLayout(countOfPile, 0, 10, 10));
        createGameDesk(countOfPile);
        setBounds(new Rectangle(10,100));
    }
    
    public static List<Pile> getPileList(){
        return piles;
    }


    public void createGameDesk(int countOfPile) {
        piles = new ArrayList<>();
        for (int i = 0; i < countOfPile; i++) {
            Pile pile = new Pile(9, i);
            add(pile);
            piles.add(pile);
        }
    }

}
