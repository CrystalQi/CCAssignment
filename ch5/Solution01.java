/*Insertion*/
import java.util.*;
public class Solution01 {

	public static int insertion(int n, int m, int i, int j) {
		// Check inputs, if not valis for insertion 
		if (i >= 32 || j < i) {
			return 0;
		}
		
		/* Create a mask to clear bits i through j in n*/
		int allOnes = ~0; 
		int mask = (allOnes << (j + 1))| ((1 << i) - 1); 

		/* Clear the ith through jth bit of n, then put m in there */
		return (n & mask) | (m << i); 
	}
	
	public static void main(String[] args) {
    	System.out.println(insertion(1024, 14, 2, 6)); 
    	System.out.println(insertion(1024, 5, 2, 4)); 
    }
}
