import java.util.*;
import java.io.*;

public class Solution03 {
  public static char[] URLify(char[] chars, int len) {

    //First count thr number of spaces
    int countSpaces = 0;
    for (int i = 0; i < len; i++) {
        if (chars[i] == ' ')
            countSpaces++;
    }
      
    int end = len - 1 + countSpaces * 2;
    // To achieve in-place, move from the end to start
    for (int i = len - 1; i >= 0; i--) {
      if (chars[i] == ' ') {
        chars[end - 2] = '%';
        chars[end - 1] = '2';
        chars[end]     = '0';
        end -= 3;
      } else {
        chars[end] = chars[i];
        end--;
      }
    }
    return chars;
  }

  public static void main(String[] args) {
    char[] chars1 = "Mr John Smith    ".toCharArray();
    System.out.println("Mr John Smith    ");
    System.out.println(URLify(chars1, 13));

    char[] chars2 = "Qi Qi  ".toCharArray();
    System.out.println("Qi Qi  ");
    System.out.println(URLify(chars2, 5));

  } 
}
