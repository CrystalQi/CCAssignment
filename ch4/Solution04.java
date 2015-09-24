package ch4;

import java.util.*;

import ch4.Solution03.TreeNode;

/**
 * ch4.04 Check balanced
 * @author qxia
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution04 sol = new Solution04();
		
		/**
		 * Test case 1: balanced
		 * 		0
		 * 	   / \
		 * 	  1   2
		 *   /   / \
		 *  3   4   5
		 *     /
		 *    6 	
		 */
		TreeNode root1 = new TreeNode(0);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(5);
		root1.right.left.left = new TreeNode(6);
		System.out.println("Is tree1 balanced? "+sol.isBalanced(root1));
		
		/**
		 * Test case2: not balanced
		 * 		0
		 * 	   / \
		 * 	  1   2
		 *       / \
		 *      4   5
		 *     /
		 *    6 	
		 */
		TreeNode root2 = new TreeNode(0);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(2);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(5);
		root2.right.left.left = new TreeNode(6);
		System.out.println("Is tree2 balanced? "+sol.isBalanced(root2));
	}
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
		
	}
	
    public boolean isBalanced(TreeNode root) {
        if(getHeight(root)==-1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        if(leftHeight==-1 || rightHeight == -1){
            return -1;
        }
        
        return Math.abs(leftHeight-rightHeight)<=1? Math.max(leftHeight, rightHeight)+1 : -1;
        
    }
}
