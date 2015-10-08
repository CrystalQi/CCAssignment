/*Assume that we work on 32-bit (Integer) machines*/

public class Solution07 {
  public static int swapOddEvenBits(int x) {
    return (((x & 0xaaaaaaaa) >>> 1) | 
            ((x & 0x55555555) <<  1));
  }
  public static void main(String[] args) {
    System.out.println(swapOddEvenBits(123));
    System.out.println(swapOddEvenBits(789));
  }
}
