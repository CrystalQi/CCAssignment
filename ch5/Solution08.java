
public class Solution08 {
	public static int computeByteNum(int width, int x, int y) {
		return (width * y + x) / 8;
	}
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int startOffset = x1 % 8;
		int firstFullByte = x1 / 8;
		if (startOffset != 0) {
			firstFullByte++;
		}
		
		int endOffset = x2 % 8;
		int lastFullByte = x2 / 8;
		if (endOffset != 7) {
			lastFullByte--;
		}
		
		//  full bytes need to be set
		for (int b = firstFullByte; b <= lastFullByte; b++) {
			screen[(width / 8) * y + b] = (byte) 0xFF;
		}
		
		byte startMask = (byte) (0xFF >> startOffset);
		byte endMask = (byte) ~(0xFF >> (endOffset + 1));
		
		// start, end of line
		if ((x1 / 8) == (x2 / 8)) { // If x1 and x2 are in the same byte
			byte mask = (byte) (startMask & endMask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (startOffset != 0) {
				int byte_number = (width / 8) * y + firstFullByte - 1;
				screen[byte_number] |= startMask;
			}
			if (endOffset != 7) {
				int byte_number = (width / 8) * y + lastFullByte + 1;
				screen[byte_number] |= endMask;
			} 
		}
	}
	
	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			char c = ((b >> i) & 1) == 1 ? '1' : '_';
			System.out.print(c);
		}
	}
	
	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c+=8) {
				byte b = screen[computeByteNum(width, c, r)];
				printByte(b);
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int width = 8 * 1;
		int height = 1;
		for (int r = 0; r < height; r++) {
			for (int c1 = 0; c1 < width; c1++) {
				for (int c2 = c1; c2 < width; c2++) {
					byte[] screen = new byte[width * height / 8];

					System.out.println("row: " + r + ": " + c1 + " -> " + c2);
					drawLine(screen, width, c1, c2, r);
					printScreen(screen, width);
					System.out.println("\n\n");
				}
			}
		}

	}

}
