package semestralniPrace;

public class BinaryHelper {

	public static long toBinary(long number) {
		String temp = Long.toBinaryString(number);
		return Long.parseLong(temp.toString());
	}

	public static long binaryXOR(long... number) {
		long result = 0;
		for (long item : number) {			
			result ^= toBinary(item);
		}
		return result;

	}

	public static void main(String[] args) {
	
		System.out.println(binaryXOR(3,4,5));
	}

}
