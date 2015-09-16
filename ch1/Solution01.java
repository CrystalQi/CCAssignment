public class Solution01 {
    //If we assume only former 128 ASCII characters; otherwise use 256 
	public static boolean isUnique(String str) {
		if (str.length() > 128) {
			return false;
		}
		//use bit manipulation to check uniqueness
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			char curr = str.charAt(i);
			int val =  curr - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"ghfdds", "xiaqi", "caoyimeng", "kiteepark", };
		for (String word : words) {
			System.out.println(word + ": " + isUnique(word));
		}
	}

}
