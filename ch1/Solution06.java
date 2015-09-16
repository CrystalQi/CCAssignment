import java.util.*;
import java.io.*;

public class Solution06 {
  public static String compressString(String str) {
  	//Need to do frequent appends , so use StringBuilder
    StringBuilder sb = new StringBuilder();
    int count = 1;
    char last = str.charAt(0);
    for (int i = 1; i <= str.length() - 1; i++) {
      if (str.charAt(i) == last) {
         count++;
      } else {
      	sb.append(last);
        sb.append(count);
        last = str.charAt(i);
        count = 1;
      }   
    }
    //the above for loop does not append the last "last"
    sb.append(last);
    sb.append(count);

    String x = sb.toString();
    if (x.length() > str.length())
      return str;
    else
      return x;
  }

  public static void main(String[] args) {
    System.out.println("aabccccaaa");
    System.out.println(compressString("aabccccaaa"));
    System.out.println("xiaqi");
    System.out.println(compressString("xiaqi"));
    System.out.println("xiaqqqqiii");
    System.out.println(compressString("xiaqqqqiii"));
  }
}
