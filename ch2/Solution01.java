import java.util.*;
import java.io.*;

import java.util.*;

public class Solution01{
  public static class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {
      this.val = val;
    }
    public String toString() {
      StringBuilder sb = new StringBuilder();
      ListNode curr = this;
      while (curr != null) {
        sb.append(curr.val + " ");
        curr = curr.next;
      }
      return sb.toString();
    }
  }
  public static void removeDupes(ListNode ListNode) {
     Set<Integer> set = new HashSet<Integer>();
     //add the first ListNode 
     set.add(ListNode.val);

     ListNode prev = ListNode;
     ListNode curr = ListNode.next;
     while (curr != null) {
      // already exists, delete this duplicate one 
      if (set.contains(curr.val)) {
        prev.next = curr.next;
      }
      else {
        set.add(curr.val);
        prev = curr;
      }
      curr = curr.next;
    }
  }
  public static void main(String[] args) {
    ListNode a = new ListNode('1');
    ListNode b = new ListNode('2');
    ListNode c = new ListNode('3');
    ListNode d = new ListNode('1');
    ListNode e = new ListNode(' ');
    ListNode f = new ListNode('3');
    
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
  
    System.out.println(a);
    removeDupes(a);
    System.out.println("After removing duplicate ListNodes: ");
    System.out.println(a);
  }
}
