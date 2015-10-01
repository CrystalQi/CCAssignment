import java.util.*;

public class Solution02 {
	public static void main(String[] args) {
		class AnagramComparator implements Comparator<String> {
			// convert to char array and then sort, 
			public String sortChars(String s) {
				char[] content = s.toCharArray();
				Arrays.sort(content);
				return new String(content);
			}
			//if s1 and s2 are anagrams, the sorted result should be the same 
		    public int compare(String s1, String s2) {
		    	return sortChars(s1).compareTo(sortChars(s2));
		    }
		}
		String[] array = {"abc","acb","bca","ee","ee","fgh","ghk","hgf","xcv","xvc"};
		System.out.println("The original array is: " + Arrays.toString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println("After sorting: " + Arrays.toString(array));
	}
	
	
}

