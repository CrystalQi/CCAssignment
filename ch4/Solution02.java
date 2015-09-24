//package ch4;

import java.io.ObjectInputStream.GetField;
import java.util.*;

/**
 * ch4.02 Give a sorted array with unique integer element, create a binary search tree with minimal height.
 * @author qxia
 *
 */
public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution02 sol = new Solution02();
		int[] arr0 = {1};
		System.out.println("Minimal height:"+sol.getDepth(sol.createBST(arr0, 0, arr0.length-1)));
		int[] arr1 = {1,2,3};
		System.out.println("Minimal height:"+sol.getDepth(sol.createBST(arr1, 0, arr1.length-1)));
		int[] arr2 = {1,2,3,4,5};
		System.out.println("Minimal height:"+sol.getDepth(sol.createBST(arr2, 0, arr2.length-1)));
		int[] arr3 = {1,2,3,4,5,6,7,8};
		System.out.println("Minimal height:"+sol.getDepth(sol.createBST(arr3, 0, arr3.length-1)));
	}

	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
		
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
	
    public int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth=0, currLen=1, nextLen=0;
        while(!queue.isEmpty()){
            TreeNode ptr = queue.poll();
            currLen--;
            if(ptr.left!=null){
                queue.add(ptr.left);
                nextLen++;
            }
            if(ptr.right!=null){
                queue.add(ptr.right);
                nextLen++;
            }
            if(currLen==0){
                currLen = nextLen;
                nextLen = 0;
                depth++;
            }
        }
        
        return depth;
    }
}
