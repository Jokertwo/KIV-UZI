package oponent;

import javax.swing.JButton;


/**
 * Rozhrani protihrace
 * 
 * @author Petr
 *
 */

public interface Oponent {

    /**
     * spusteni hry protivnika
     */
    public void startPlay();


    /**
     * nastavemi tlacitka pro odebrani sirek
     * 
     * @param remove JButton
     */
    public void setRemove(JButton remove);

}
