import java.util.*;

public class Solution05 {
   public static boolean oneInsert(String a, String b) {
    // a.length() is 1 smaller than b.length()
    int i, j = 0;
    int differences = 0;
    int len_a = a.length();
    for (i = 0; i < len_a; i++) {
      if (!(a.charAt(i) == b.charAt(j))) {
        j++;
        differences++;
      }
      if (differences > 1) {
      	return false;
      }
      j++;
    }
    return true;
  }


  public static boolean oneReplace(String a, String b) {
    int differences = 0;
    int len_a = a.length();
    //a and b are of the same length
    for (int i = 0; i < len_a; i++) {
      if (a.charAt(i) != b.charAt(i))
        differences++;
      if (differences > 1) {
      	return false;
      }   
    }
    return true;
  }

 
  public static boolean oneAway(String a, String b) {
  	if ( Math.abs(a.length() - b.length()) >= 2) {
  		return false;
  	}
  	//Math.abs(a.length() - b.length()) <= 1
    if (a.length() < b.length())
      return oneInsert(a, b);
    else if (a.length() > b.length())
      return oneInsert(b, a);
    else
      return oneReplace(a, b);
  }

  public static void main(String[] args) {
    System.out.println(oneAway("pale",  "ple") ? "true" : "false"); 
    System.out.println(oneAway("pales", "pale") ? "true" : "false"); 
    System.out.println(oneAway("pale",  "bale") ? "true" : "false");  
    System.out.println(oneAway("pale",  "bake") ? "true" : "false"); 
  }
}
