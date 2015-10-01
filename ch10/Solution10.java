import java.util.*;

// use a Tree Structure 
class RankNode {
    public int left_size = 0;
    public RankNode left;
    public RankNode right;
    public int val = 0;
    public RankNode(int d) {
        val = d;
    }   
    public void insertNode(int d) {
        if (d <= val) {
            if (left != null) {
                left.insertNode(d);
            } else {
                left = new RankNode(d);
            }
            left_size++;
        } else {
            if (right != null) {
                right.insertNode(d);
            } else {
                right = new RankNode(d);
            }
        }
    }
    
    public int getRank(int d) {
        if (d == val) {
            return left_size;
        } else if (d < val) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int right_rank = right == null ? -1 : right.getRank(d);
            if (right_rank == -1) {
                return -1;
            } else {
                return left_size + 1 + right_rank;
            }
        }
    }
}

public class Solution10{
    private static RankNode root = null;
    public static void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
            root.insertNode(number);
        }
    }
    
    public static int getRank(int number) {
        return root.getRank(number);
    }
    
    public static void main(String[] args) {
        int size = 20;
        int[] list = {0,12,4,7,9,11,234,55,788,90};
        for (int i = 0; i < list.length; i++) {
            track(list[i]);
        }
        
        int[] tracker = new int[size];
        for (int i = 0; i < list.length; i++) {
            int v = list[i];
            int tmp = root.getRank(list[i]);
            tracker[tmp] = v;       
        }
        
        System.out.println("Originally: " + Arrays.toString(list));
        for (int i: list) {
            System.out.println("the rank of number  " + i + "     is : " + getRank(i));
        }
    }
}
