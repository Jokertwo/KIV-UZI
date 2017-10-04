package semestralniPrace;

public class Helper {
    
    public static final int TRUE = 1;
    public static final int FALSE = 0;
    public static final String DISABLE = "disable";

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

}
