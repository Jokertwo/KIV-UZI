package oponent;

import semestralniPrace.Helper;

public interface Oponent extends Runnable{
    
    
    
    public void startPlay();
    
    
    default void doClick(){
                Helper.removeButton();                     
    }

}
