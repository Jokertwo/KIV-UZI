package semestralniPrace;

import java.util.HashMap;
import java.util.Map;


/**
 * Pomocna trida
 * 
 * @author Petr
 *
 */
public class Helper {

    public static final String PANEL = "panel";
    public static final String FRAME = "frame";

    public static final String HARD = "Hard";
    public static final String MEDIUM = "Medium";
    public static final String EASY = "Easy";

    public static final String PLAYER = "player";
    public static final String OPONENT = "oponent";

    public static final String NUMBER_OF_MATCH = "numberOfMatch";
    public static final String NUMBER_OF_PILE = "numberOfPile";

    public static final String REMOVE_BUTTON = "removeButton";

    public static final int maxMatch = 10;

    public static Map<String, String> gameSetting = new HashMap<>();


    /**
     * Vypne tlacitka z dane hromadky
     * 
     * @param group
     *            hromadka
     */
    public static void disableButton(int group) {
        for (Pile pile : GameDesk.piles) {
            if (pile.getGroup() != group && pile.getIsEnable()) {
                pile.setEnableMathes(false);
            }
        }
    }


    /**
     * vraci true pokud v dane hromadce je alespon jedna oznacena zapalka
     * 
     * @param group
     *            hromadka
     * @return true / false
     */
    public static boolean isSomeMatchInPileSelected(int group) {
        for (Pile pile : GameDesk.piles) {
            if (pile.getGroup() == group) {
                return pile.isSomeMatchSelect();
            }
        }
        return false;
    }


    /**
     * Uvolni zapalky z dane hromadky
     * 
     * @param group
     *            hromadka
     */
    public static void enableButton(int group) {

        for (Pile pile : GameDesk.piles) {
            if (pile.getGroup() != group) {
                pile.setEnableMathes(true);
            }
        }

    }


    /**
     * Odstrani zapalky ze stolu
     */
    public static void removeButton() {
        for (Pile pile : GameDesk.piles) {
            if (pile.getIsEnable()) {
                pile.removeMatches();
                enableButton(pile.getGroup());
                return;
            }
        }
    }

}
