package algoritmusNim;

import java.util.List;
import semestralniPrace.Pile;


public interface Algoritmus {

    int[] getMove(List<Pile> piles);
    
    void init();
    
    void print();

}
