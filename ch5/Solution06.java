/* Conversion */

public class Solution06 {
  

  public static int conversion(int a, int b) {
    int count = 0;
    // c & (c-1) can clear the least significant bit in c.
    for (int c = a ^ b; c != 0; c = c & (c-1)) {
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(conversion(1112, 901));
    System.out.println(conversion(4784, 223));
  }
}
