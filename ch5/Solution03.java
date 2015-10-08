public class Solution03 {

	public static int SEQUENCE_LENGTH = 32;
	
	
	public static int getMaxSequence(int[] sequences) { 
		if (sequences[1] == 1) { 
			return sequences[0] + sequences[2] + 1; 
		} else if (sequences[1] == 0) { 
			return Math.max(sequences[0], sequences[2]); 
		} else { 
			return Math.max(sequences[0], sequences[2]) + 1;
		}
	}
	
	public static void shift(int[] sequences) {
		sequences[2] = sequences[1];
		sequences[1] = sequences[0];
		sequences[0] = 0;
	}
	
	public static int longestSequence(int n) {
		int searchingFor = 0;
		int[] sequences = {0, 0, 0}; 
		int maxSequence = 1;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if ((n & 1) != searchingFor) {
				if (searchingFor == 1) { 
					maxSequence = Math.max(maxSequence, getMaxSequence(sequences));
				}
				
				searchingFor = n & 1; 
				shift(sequences);
			}
			sequences[0]++;
			n >>>= 1;
		}
		
		/* Check final set of the sequences */
		if (searchingFor == 0) {
			shift(sequences);		
		}
		int finalSequence = getMaxSequence(sequences);
		maxSequence = Math.max(finalSequence, maxSequence);		
		
		return maxSequence;
	}		
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);		
	}

}
