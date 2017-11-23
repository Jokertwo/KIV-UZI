package oponent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import semestralniPrace.GameDesk;
import semestralniPrace.Helper;
import semestralniPrace.Pile;

/**
 * Rozhrani protihrace
 * 
 * @author Petr
 *
 */

public interface Oponent extends Runnable{
    
    
    
    public void startPlay();
    
    
    default void doClick(){
                Helper.removeButton();                     
    }
    
    default boolean checkWin() {
        int sum = 0;
        for (Pile pile : GameDesk.piles) {
            sum += pile.getLeftMatches();
        }
        if (sum > 0) {
            return false;
        }
        return true;
    }
    
    default void  informAboutWin(String name){
        JOptionPane.showMessageDialog(null, name + " win's!!!!!");
    }
    
    public void setRemove(JButton remove);

}
