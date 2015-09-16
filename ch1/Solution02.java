import java.util.*;
import java.io.*;

public class Solution02 {
  public static boolean isPermutation(String s1, String s2) {
    //Here we consider the difference between uppercase and lowercase, and also whitespace
    if (s1.length() != s2.length()) {
      return false;
    }
    //transform string to charArray and sort them 
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
  
  //Second method is to the number of different characters in the two strings 
  public static boolean isPermutation2(String s1, String s2) {
      if (s1.length() != s2.length()) {
      return false;
    }
    //Here we assume only ASCII characters
    int[] chars = new int[256];
    char[] s1_array = s1.toCharArray();
    for (char c: s1_array) {
      chars[(int)c] ++;
    }

    for (int i = 0; i < s2.length(); i++) {
      int c = (int) s2.charAt(i);
      if (--chars[c] < 0) {
          return false;
      }
    }
    return true;
  } 

  public static void main(String[] args) {
      System.out.println("Method 1: ");
      System.out.println("sdgh, dghs");
      System.out.println(isPermutation("sdgh", "dghs") ? "Yes, a permutation" : "Not a permutation");
      System.out.println("uber, uberer");
      System.out.println(isPermutation("uber", "uberer") ? "Yes, a permutation" : "Not a permutation");
      System.out.println("flag, fgla");
      System.out.println(isPermutation("flag", "fgla") ? "Yes, a permutation" : "Not a permutation");

      System.out.println("Method 2: ");
      System.out.println("sdgh, dghs");
      System.out.println(isPermutation2("sdgh", "dghs") ? "Yes, a permutation" : "Not a permutation");
      System.out.println("uber, uberer");
      System.out.println(isPermutation2("uber", "uberer") ? "Yes, a permutation" : "Not a permutation");
      System.out.println("flag, fgla");
      System.out.println(isPermutation2("flag", "fgla") ? "Yes, a permutation" : "Not a permutation");
  }
}