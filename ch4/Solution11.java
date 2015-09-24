import java.util.Random;

class Tree {
  TreeNode root = null;
  
  public void insertInOrder(int value) {
    if (root == null) {
      root = new TreeNode(value);
    } else {
      root.insertInOrder(value);
    }
  }

  //the size of the subtree that is rooted at node "root"
  public int size() {  
    return root == null ? 0 : root.size();
  }
  
  public TreeNode getRandomNode() {
    if (root == null) return null;
    
    Random random = new Random();
    int i = random.nextInt(size());
    return root.getIthNode(i);
  }
}

class TreeNode {
  private int size = 0;
  public int data;      
  public TreeNode left;    
  public TreeNode right; 
 
  public TreeNode(int d) {
    data = d;
    size = 1;
  }
  
  public void insertInOrder(int d) {
    if (d <= data) {
      if (left == null) {
        left = new TreeNode(d);
      } else {
        left.insertInOrder(d);
      }
    } else {
      if (right == null) {
        right = new TreeNode(d);
      } else {
        right.insertInOrder(d);
      }
    }
    size++;
  }
  
  public int size() {
    return size;
  }
  
  public TreeNode find(int d) {
    if (d == data) {
      return this;
    } else if (d > data) {
      return right != null ? right.find(d) : null;
    } else if (d <= data) {
      return left != null ? left.find(d) : null;
    }
    return null;
  }


  public TreeNode getRandomNode() {
    int leftSize = left == null ? 0 : left.size();
    Random random = new Random();
    int index = random.nextInt(size);
    if (index < leftSize) {
      return left.getRandomNode();
    } else if (index == leftSize) {
      return this;
    } else {
      return right.getRandomNode();
    }
  }
  
  public TreeNode getIthNode(int i) {
    int leftSize = left == null ? 0 : left.size();
    if (i < leftSize) {
      return left.getIthNode(i);
    } else if (i == leftSize) {
      return this;
    } else {
      return right.getIthNode(i - (leftSize + 1));
    }
  }
} 


public class Solution11 {


   //assume it is a BST (otherwise can just scan level-by-level, O(n))
   private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    //Insert: as follows : first you should find a leaf node, then link to it
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return root;
        }
        TreeNode tmp = root;
        TreeNode last = null;
        while (tmp != null) {
            last = tmp;
            if (tmp.val > node.val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (last != null) {
            if (last.val > node.val) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }

   /**
     * first find the node "curr":
     * if it is a leaf node, delete it right away
     * if it has only one child, replace "curr" with its child 
     * if it has two children: to find the leftmost child of "curr"'s right child
     * (1)if "curr" is curr's right child, 
     *     set target's left child to be left child of the to-be-deleted node      
     * (2)otherwise, set target's parent's left child to be target's right child, 
     *     and link target to children of to-be-deleted node
  */
  public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
  

  public static void main(String[] args) {

    //using large number of experiment simulations
    int[] counts = new int[10];
    for (int i = 0; i < 1000000; i++) {
      Tree tree = new Tree();
      int[] array = {1, 0, 6, 2, 3, 9, 8,4,7, 5};
      for (int x : array) {
        tree.insertInOrder(x);
      }
      int d = tree.getRandomNode().data;
      counts[d]++;
    }
    
    for (int i = 0; i < counts.length; i++) {
      System.out.println(i + ": " + counts[i]);
    }
    /*
      0: 99518
      1: 100400
      2: 99635
      3: 100017
      4: 100704
      5: 99593
      6: 100247
      7: 100168
      8: 99655
      9: 100063

    */

  }

}
