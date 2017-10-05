package semestralniPrace;

public class Helper {

    public static long toBinary(long number) {
        String temp = Long.toBinaryString(number);
        return Long.parseLong(temp.toString());
    }


    public static long binaryXOR(long... number) {
        long result = 0;
        for (long item : number) {
            System.out.println(Long.toBinaryString(item));
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


    public static Pile getPile(int group) {
        Pile pile = null;
        for (Pile tempPile :GameDesk.getPileList()) {
            if (tempPile.getGroup() == group) {
                pile = tempPile;
            }
        }
        return pile;
    }


    public static void enableButton(int group) {
        if (!getPile(group).isSomeMatchSelect()) {
            for (Pile pile : GameDesk.getPileList()) {
                pile.setEnableMathes(true);
            }
        }
    }

}
