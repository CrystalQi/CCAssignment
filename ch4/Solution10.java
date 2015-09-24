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

public class Solution10 {
  
  /* Whether a tree rooted at r1 contains a binary tree 
   * rooted at r2 as a subtree (not necessarily starting from r1)
   can be somewhere within it.
   */
  
  /* Whether a tree rooted at r1 (r1 as the very starting node)
     matches a binary tree rooted at r2 as a subtree 
   */
  public static boolean matchTree(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      return true; 
    } else if (r1 == null || r2 == null) { 
      return false;
    } else if (r1.val != r2.val) {  
      return false;  
    } else {
      return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }
  }
  

  public static boolean subTree(TreeNode r1, TreeNode r2) {
    if (r1 == null) {
      return false; 
    } else if (r1.val == r2.val && matchTree(r1,r2)) {
      return true;
    }
    return subTree(r1.left, r2) || subTree(r1.right, r2); 
  }


  public static boolean containsTree(TreeNode t1, TreeNode t2) {
    if (t2 == null) {
      return true; // The empty tree is a subtree of every tree.
    }
    return subTree(t1, t2);
  }
  

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(0);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(1);
    root1.left.left = new TreeNode(4);
    root1.left.right = new TreeNode(7);
    root1.right.left = new TreeNode(2);
    root1.right.right = new TreeNode(6);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(6);

      
    TreeNode root3 = new TreeNode(7);
    root3.left = new TreeNode(2);
    root3.right = new TreeNode(6);

    if (containsTree(root1, root2)) {
      System.out.println("t2: a subtree of t1");
    } else {
      System.out.println("t2: not a subtree of t1");
    }

    if (containsTree(root1, root3)) {
      System.out.println("t3: a subtree of t1");
    } else {
      System.out.println("t3: not a subtree of t1");
    }
    /*
    result as expected:
    t2: a subtree of t1
    t3: not a subtree of t1
    */
  }
}
