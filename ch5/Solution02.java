/* Binary to String*/


public class Solution02 {
	public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR INPUT";
        }
        
        StringBuilder result  = new StringBuilder();
        result .append(".");
        while (num > 0) {
            
            if (result .length() > 32) {
                return "ERROR INPUT, EXCEEDING LENGTH LIMIT";
            }
            double r = num * 2;
            if (r >= 1) {
                result .append(1);
                num = r - 1;
            } else {
                result .append(0);
                num = r;
            }
        }
        return result.toString();
	}
	
	
	
	public static void main(String[] args) {
		String bs = printBinary(.125);
		System.out.println(bs);
		
		for (int i = 0; i < 100; i++) {
			double num = i / 100.0;
			String binary = printBinary(num);
			if (!binary.equals("ERROR")) {
				System.out.println(num + " the binary representation is: " + binary);
			}
		}
	}
}
