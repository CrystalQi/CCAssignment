import java.util.*;

public class Solution08{
  public static List<Integer> findDuplicates(int[] arr) {
      List<Integer> duplicates = new ArrayList<Integer>();
      //n is at most 32000, and 8* 4* 2*10 is larger than 32000
      BitSet bs = new BitSet(32000);
    for (int num : arr) {
       //haven't appeared yet
        if (bs.get(num-1) == false)
          bs.set(num-1);
        //has already appeared before
        else
          duplicates.add(num);
    }
    return duplicates;
  }
  
  public static void main(String[] args) {
      int[] array = new int[]{1, 2,2, 3, 4, 5, 5, 6, 7, 8, 8, 101, 101, 107};
      List<Integer> duplicates = findDuplicates(array);
      for (int num : duplicates)
        System.out.println(num);
  }
}
