package ch4;

import java.util.*;

import ch4.Solution03.TreeNode;

/**
 * ch5.05 Valid BST
 * @author qxia
 *
 */
public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution05 sol = new Solution05();
		
		/**
		 * Test case1: not a bst
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
		System.out.println("Is tree1 valid bst? "+sol.isValidBST(root));
		
		
		// testcase2, borrow the bst I created in solution02
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println("Is the tree I created valid bst? "+sol.isValidBST(sol.createBST(arr, 0, arr.length-1)));
	}

	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
		
	}
	
    /**
     * Iterative way: Inorder traversal of the tree
     */ 
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        int expected = Integer.MIN_VALUE;
        boolean hitCeiling = false;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                curr = st.pop();
                if(curr.value<expected || hitCeiling){
                    return false;
                }
                if(curr.value==Integer.MAX_VALUE){
                    hitCeiling = true;
                }
                expected = curr.value+1;
                curr = curr.right;
            }
        }
        return true;
    }
    
    public TreeNode createBST(int[] nums, int start, int end) {
        if(end<start){
            return null;
        }
        else if(end==start){
            return new TreeNode(nums[start]);
        }
        
        int mid = start + (end-start)/2;
        TreeNode root  = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid-1);
        root.right = createBST(nums, mid+1, end);
        return root;
    }
}
