package oponent;

import semestralniPrace.GameDesk;
import semestralniPrace.Match;
import semestralniPrace.Pile;


public class EasyOponent implements Oponent {
      
    @Override
    public void startPlay() {
        int counter = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Pile pile = getPile();
        if (pile != null) {
            int numberOfSelection = (int) (Math.random() * pile.getLeftMatches()) + 1;
            for (Match match : pile.matches) {
                match.doClick();
                counter++;
                
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (counter == numberOfSelection) {
                    break;
                }                               
            }
        }      
        doClick();
    }
    


    private Pile getPile() {
        Pile pile = null;
        for (Pile tempPile : GameDesk.piles) {
            if (tempPile.getLeftMatches() > 0) {
                pile = tempPile;
                break;
            }
        }
        return pile;
    }




    @Override
    public void run() {
        startPlay();
        
    }




  

}
