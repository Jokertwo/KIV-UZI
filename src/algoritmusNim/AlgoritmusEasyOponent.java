package algoritmusNim;

import java.util.List;
import semestralniPrace.GameDesk;
import semestralniPrace.Pile;


public class AlgoritmusEasyOponent implements Algoritmus {

    /**
     * Nahodne vybere hromadku a pocet zapalek kolik se zni odebrat
     */
    @Override
    public int[] getMove(List<Pile> piles) {
        Pile pile = getPile();
        int numberOfSelection = (int) (Math.random() * pile.getLeftMatches()) + 1;
        int[] move = { numberOfSelection, pile.getGroup(), -1 };
        return move;
    }


    @Override
    public void init() {
        // TODO Auto-generated method stub

    }


    @Override
    public void print() {
        // TODO Auto-generated method stub

    }


    /**
     * Vyber pseudonahodne hromadky
     * 
     * @return
     */
    private Pile getPile() {
        while (true) {
            int number = (int) (Math.random() * (GameDesk.piles.size() - 1)) + 1;
            if (GameDesk.piles.get(number).getLeftMatches() > 0) {
                return GameDesk.piles.get(number);
            }
        }
    }

}
