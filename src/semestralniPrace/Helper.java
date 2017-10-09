package semestralniPrace;

import java.util.HashMap;
import java.util.Map;

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
    

    public static Map<String,String> gameSetting = new HashMap<>();

    public static long toBinary(long number) {
        String temp = Long.toBinaryString(number);
        return Long.parseLong(temp.toString());
    }


    public static long binaryXOR(long... number) {
        long result = 0;
        for (long item : number) {
            result = result ^ item;
        }
        return toBinary(result);
    }


    public static void disableButton(int group) {
        for (Pile pile : GameDesk.piles) {
            if (pile.getGroup() != group && pile.getIsEnable()) {
                pile.setEnableMathes(false);
            }
        }
    }


    public static void enableButton(int group) {
        for (Pile pile : GameDesk.piles) {
            if (pile.getGroup() != group) {
                pile.setEnableMathes(true);
            }
        }
    }


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
