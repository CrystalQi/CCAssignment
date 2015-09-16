import java.util.*;

public class Solution04 {
  public static boolean isPermutePalindrome(String str) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
      //ingore uppercase and lowercase differences
      Character c = Character.toLowerCase(str.charAt(i));
      //ingore characters that are not letters
      if (!Character.isLetter(c))
        continue;
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
          map.put(c, 1);
      } 
    }

    int odd = 0;
    for (Character key : map.keySet()) {
      if (map.get(key) % 2 != 0)
        odd++;
    }
      
    //we can only have at most 1 character that appears for odd times 
    if (odd > 1)
      return false;
    else
      return true;
  }
  public static void main(String[] args) {
    System.out.println("Tact Coa");
    System.out.println(isPermutePalindrome("Tact Coa") ? "True" : "False");
    System.out.println("kattyab");
    System.out.println(isPermutePalindrome("kattyab") ? "True" : "False");
  }
}
