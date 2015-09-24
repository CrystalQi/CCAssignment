
import java.util.*;
import java.io.*;

class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
		
}

/**
 * ch5.08 Find LCA in a binary tree
 * @author qxia
 *
 */
public class Solution08 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if (root == null || root == p || root == q) 
	    	return root;
	    TreeNode left = lowestCommonAncestor(root.left, p, q);
	    TreeNode right = lowestCommonAncestor(root.right, p, q);
	    if (left == null) {
	        return right;
	    } else {
	    	if (right == null) {
	    		return left;
	    	} else {
	    		return root;
	    	}
    }
   
  }
    public static void main(String[] args) {
		/**
		 * Test case: 
		 * 		0
		 * 	   / \
		 * 	  1   2
		 *   /   / \
		 *  3   4   5
		 *     /
		 *    6 	
		 */
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		
		TreeNode lca1 = lowestCommonAncestor(root, root.right.right, root.right.left.left);
		System.out.println("The LCA of p1 and q is:" + lca1.value);  // 5 and 6 's lca is 2

        TreeNode lca2 = lowestCommonAncestor(root, root.left.left, root.right.left.left);
		System.out.println("The LCA of p2 and q is:" + lca2.value);  // 3 and 6 's lca is 0
		
	}
}
