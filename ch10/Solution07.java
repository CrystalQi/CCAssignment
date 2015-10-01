import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution07{
	public static byte[] bitfield = new byte [(int) ((((long) Integer.MAX_VALUE) + 1) / 8)];
	public static void generateNewOne()  {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("./input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (in.hasNextInt()) {
			int n = in.nextInt ();
			bitfield [n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				/* Need to get the individual bits of each byte. 
				When 0 bit is found, find corresponding value. */
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println (i * 8 + j);
					return;
				}
			}
		}		
	}

	public static void main(String[] args)  throws IOException {
		generateNewOne();
	}

}
