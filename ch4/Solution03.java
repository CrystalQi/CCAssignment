package ch4;

import java.util.*;

/**
 * ch4.03 List of depth
 * @author qxia
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		Solution03 sol = new Solution03();
		List<List<TreeNode>> res = sol.getListOfDepth(root);
		System.out.println("There are "+res.size()+" levels in this tree, its list of depth is:");
		for(List<TreeNode> depth:res){
			for(TreeNode node: depth){
				System.out.print(node.value);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
		
	}
	
	public List<List<TreeNode>> getListOfDepth(TreeNode root){
		List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
        if(root==null){
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<TreeNode> level = new LinkedList<TreeNode>();
        int currLen = 1, nextLen = 0;
        while(!queue.isEmpty()){
            TreeNode ptr = queue.poll();
            currLen--;
            level.add(ptr);
            if(ptr.left!=null){
                queue.add(ptr.left);
                nextLen++;
            }
            if(ptr.right!=null){
                queue.add(ptr.right);
                nextLen++;
            }
            
            if(currLen==0){
                res.add(level);
                level = new LinkedList<TreeNode>();
                currLen = nextLen;
                nextLen = 0;
            }
        }
        
        return res;
	}
}
