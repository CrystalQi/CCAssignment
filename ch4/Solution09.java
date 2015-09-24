package ch4;

import java.util.*;

import ch4.Solution06.TreeNode;

/**
 * 
 * @author qxia
 *
 */
public class Solution09 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Solution09 sol = new Solution09();
    
    /**
     * Test case 1:
     *    2
     *     / \
     *    1   3
     */
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    List<List<Integer>> res1 = sol.getSequences(root1);
    System.out.println("For tree1, possible sequences are:");
    for(List<Integer> sequence: res1){
      for(int i: sequence){
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
    
    /**
     * Test case:
     *    2
     *     / \
     *    1   5
     *   /   / \
     *  0   3   6
     *       \
     *        4   
     */
    TreeNode root2 = new TreeNode(2);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(5);
    root2.left.left = new TreeNode(0);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(6);
    root2.right.left.right = new TreeNode(4);
    List<List<Integer>> res2 = sol.getSequences(root2);
    System.out.println("For tree2, possible sequences are:");
    for(List<Integer> sequence: res2){
      for(int i: sequence){
        System.out.print(i);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
    
  }
  public static class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
      this.value = value;
    }
    
  }
  
  public List<List<Integer>> getSequences(TreeNode root){
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    List<TreeNode> candidates = new ArrayList<TreeNode>();
    candidates.add(root);
    List<Integer> sequence = new ArrayList<Integer>();
    find(res, sequence, candidates);
    
    return res;
  }
  
  public void find(List<List<Integer>> res, List<Integer> sequence, List<TreeNode> candidates){
    if(candidates.size()==0){
      res.add(new ArrayList<Integer>(sequence));
      return;
    }
    
    for(int i=0; i<candidates.size(); i++){
      TreeNode chosen = candidates.get(i);
      List<TreeNode> newCandidates = new ArrayList<TreeNode>(candidates);
      newCandidates.remove(i);
      if(chosen.left!=null){
        newCandidates.add(chosen.left);
      }
      if(chosen.right!=null){
        newCandidates.add(chosen.right);
      }
      sequence.add(chosen.value);
      find(res, sequence, newCandidates);
      sequence.remove(sequence.size()-1);
    }
    
  }
}
