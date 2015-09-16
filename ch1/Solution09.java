import java.util.*;
import java.io.*;

public class Solution09 {
  public static boolean isRotation(String s1, String s2) {
    //append a "s1" after a "s1"
    String s3 = s1 + s1;
    boolean isRotate = s3.contains(s2);
    return isRotate;
  }
  public static void main(String[] args) {
    System.out.println("waterbottle, erbottlewat");
    System.out.println(isRotation("waterbottle", "erbottlewat") ? "True" : "False");
    System.out.println("waterbottl, erbottlewat");
    System.out.println(isRotation("waterbottl", "rbottlewate") ? "True" : "False");
  }
}
