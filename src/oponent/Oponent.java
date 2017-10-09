package oponent;

import javax.swing.SwingUtilities;
import semestralniPrace.Helper;

public interface Oponent extends Runnable{
    
    
    
    public void startPlay();
    
    
    default void doClick(){
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                Helper.removeButton();
                
            }
        });
       
    }

}
