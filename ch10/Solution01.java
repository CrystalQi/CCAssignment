
import java.util.*;

public class Solution01 {
    public static void merge(int[] a, int[] b, int lastA, int lastB) {
    	//cannot just use a.length as lastA, otherwise ArrayOutOfIndexBounds
		int indexResult = lastB + lastA - 1; 
		int indexA = lastA - 1;
		int indexB = lastB - 1; 
	
		/* Merge a and b, in a backward manner*/
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger*/
				a[indexResult] = a[indexA]; 
				indexA--; 
			} else {
				a[indexResult] = b[indexB]; 
				indexB--;
			}
			indexResult--; // move indices			
		}
	}
	
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 0,0,0,0,0,0};
        int[] b = new int[]{1,2,3,4,6,7};
        int lastA = 3;
        int lastB = 6;
        merge(a, b, lastA, lastB);
        System.out.println(Arrays.toString(a));
      }
    }

