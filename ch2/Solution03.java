import java.util.*;
import java.io.*;

public class Solution03 {
  //Definition for class ListNode
  public static class ListNode {
    ListNode next;
    char val;
    public ListNode(char val) {
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
  //to assign the val of ListNode.next, then delete ListNode.next
  public static void deleteMiddle(ListNode ListNode) {
        if (ListNode.next != null) {
            ListNode.val = ListNode.next.val;
            ListNode.next = ListNode.next.next;
        } else {
            ListNode = null;
        }
    }

  public static void main(String[] args) {
    ListNode a = new ListNode('a');
    ListNode b = new ListNode('b');
    ListNode c = new ListNode('c');
    ListNode d = new ListNode('d');
    ListNode e = new ListNode('e');
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    System.out.println(a);
    deleteMiddle(d);
    System.out.println(a);
  }
}
