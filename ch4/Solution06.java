package ch4;

public class Solution06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Test case:
		 * 		2
		 * 	   / \
		 * 	  1   5
		 *   /   / \
		 *  0   3   6
		 *       \
		 *        4 	
		 */
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.parent = root;
		root.right = new TreeNode(5);
		root.right.parent = root;
		root.left.left = new TreeNode(0);
		root.left.left.parent = root.left;
		root.right.left = new TreeNode(4);
		root.right.left.parent = root.right;
		root.right.right = new TreeNode(6);
		root.right.right.parent = root.right;
		root.right.left.left = new TreeNode(3);
		root.right.left.left.parent =root.right.left;
		
		Solution06 sol = new Solution06();
		System.out.println("Successor of "+root.value+" is: "+sol.findSuccessor(root).value);
		System.out.println("Successor of "+root.left.value+" is: "+sol.findSuccessor(root.left).value);
		System.out.println("Successor of "+root.right.value+" is: "+sol.findSuccessor(root.right).value);
	}
	public static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		public TreeNode(int value) {
			this.value = value;
		}
		
	}
	
	public TreeNode findSuccessor(TreeNode node){
		if(node.right!=null){
            TreeNode successor = node.right;
            while(successor.left!=null){
                successor = successor.left;
            }
            return successor;  
		}
		else{
			TreeNode ptr = node;
			while(ptr.parent!=null && ptr == ptr.parent.right){
				ptr = ptr.parent;
			}
			return ptr.parent;
		}		
	}
}
