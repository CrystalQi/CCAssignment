import java.util.*;
import java.io.*;

public class Solution07 {
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
        sb.append(" ");
        curr = curr.next;
      }
      return sb.toString();
    }
  }


   public static ListNode getIntersectionListNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
        	return null;
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = Math.abs(lenA - lenB);

        //let the longer LinkedList take "diff" steps ahead
        while(diff > 0) {
            if (lenA > lenB) 
            	headA = headA.next;
            else 
            	headB = headB.next;
            diff--;
        }

        //when two pointers meet, it is the intersection point
        while (headA != null && headB != null) {
            if (headA.val == headB.val) 
            	return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static int length(ListNode n) {
        if (n == null) 
        	return 0;
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }

    public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(5);
    ListNode f = new ListNode(6);
    ListNode g = new ListNode(7);
    ListNode h = new ListNode(8);
    ListNode i = new ListNode(9);
    ListNode j = new ListNode(10);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    //a b c d e f g; 1 2 3 4 5 6 7 

    h.next = i;
    i.next = j;
    j.next = e;
    //h i j e f g; 8 9 10 5 6 7

    ListNode x = getIntersectionListNode(a, h); 
    System.out.println(x); // it should be 5->6->7
  }
}
