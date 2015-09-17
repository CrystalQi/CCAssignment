import java.util.*;
import java.io.*;

public class Solution02 {
    public static class ListNode {
    ListNode next;
    char val;
    public ListNode(char val) {
      this.val = val;
    }
    public String toString() {
      StringBuilder sb = new StringBuilder();
      ListNode temp = this;
      while (temp != null) {
        sb.append(temp.val + " ");
        temp = temp.next;
      }
      return sb.toString();
    }
  }
  public static ListNode returnKth(ListNode ListNode, int k) {
    k = k - 1;
    ListNode slow = ListNode;
    ListNode fast = ListNode;
    for (int i = 0; i <= k - 1; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
  public static void main(String[] args) {
    ListNode a = new ListNode('a');
    ListNode b = new ListNode('b');
    ListNode c = new ListNode('c');
    ListNode d = new ListNode('d');
    ListNode e = new ListNode('e');
    ListNode f = new ListNode('f');
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    System.out.println("The original LinkedList is: ");
    System.out.println(a);
    System.out.println(returnKth(a, 3).val); // it should be d
  }
}
