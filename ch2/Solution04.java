import java.util.*;
import java.io.*;

public class Solution04 {
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
        sb.append(curr.val);
        sb.append(' ');
        curr = curr.next;
      }
      return sb.toString();
    }
  }

   public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        //use one list to link nodes with value <x
        //use another list to link nodes with value >=x
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        right.next = null;
        
        left.next = rightDummy.next;
        return leftDummy.next;
    }

  public static void main(String[] args) {
    ListNode a = new ListNode(3);
    ListNode b = new ListNode(5);
    ListNode c = new ListNode(8);
    ListNode d = new ListNode(5);
    ListNode e = new ListNode(10);
    ListNode f = new ListNode(2);
    ListNode g = new ListNode(1);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    System.out.println("Original: ");
    System.out.println(a);
    ListNode x = partition(a, 5);
    System.out.println("After partition: ");
    System.out.println(x);
  }
}
