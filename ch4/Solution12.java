import java.util.*;
import java.io.*;

class TreeNode {
  TreeNode left;
  TreeNode right;
  int val;
  TreeNode(int val) {
    this.val = val;
  }
  
}


public class Solution12 {
  public static void calculateSum(TreeNode node, int sum, int[] path, int level) {
    if (node == null) {
      return;
    }
    // put current node into path
    path[level] = node.val; 
    int t = 0;
    for (int i = level; i >= 0; i--){ //the path needs to start from current
      t += path[i];
      if (t == sum) {
        print(path, i, level);
      }
      //No break; need to interate till the end
    }

    calculateSum(node.left, sum, path, level + 1);
    calculateSum(node.right, sum, path, level + 1);
    //effect : remove current node
    path[level] = Integer.MIN_VALUE;
  }
  
  public static int getMaxDepth(TreeNode node) {
    if (node == null) {
            return 0;
        }
        
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(node);
        int curNum = 1, nextNum = 0; //curNum初始不是0，否则死循环
        int level = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curNum --;
            if (cur.left != null) {
                queue.offer(cur.left);
                nextNum ++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                nextNum ++;
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
  }
  
  public static void findSum(TreeNode node, int sum) {
    int depth = getMaxDepth(node);
    int[] path = new int[depth];
    calculateSum(node, sum, path, 0);
  }

  private static void print(int[] path, int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }

  public static void main(String [] args){
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(3);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(6);
    findSum(root, 7);
    /*
    the result is right:
      3 4 
      0 3 4 
      7 
      1 6 
      0 1 6
    */
  }
}
