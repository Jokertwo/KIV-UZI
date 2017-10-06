package semestralniPrace;

public class Helper {

    public static final String PANEL = "panel";


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
        for (Pile pile : GameDesk.getPileList()) {
            if (pile.getGroup() != group && pile.getIsEnable()) {
                pile.setEnableMathes(false);
            }
        }
    }


    public static void enableButton(int group) {
        for (Pile pile : GameDesk.getPileList()) {
            if (pile.getGroup() != group) {
                pile.setEnableMathes(true);
            }
        }
    }


    public static void removeButton() {
        for (Pile pile : GameDesk.getPileList()) {
            if (pile.getIsEnable()) {
                pile.removeMatches();
                enableButton(pile.getGroup());
                return;
            }
        }
    }

}
