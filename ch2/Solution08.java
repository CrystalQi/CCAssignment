import java.util.*;
import java.io.*;

public class Solution08 {
    public static class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {
      this.val = val;
    }
    public String toString() {
      return this.val + "";
    }
  }

  public static ListNode findLoopStart(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (true) {
        if (fast == null || fast.next == null) {
            return null;    //encountering "null", so no cycle
        }
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) {
            break;    //first meet
        }
    }

    slow = head;    //slow starts from the beginning head，
    while (slow != fast) {    //meet again
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    ListNode e = new ListNode(5);
    ListNode f = new ListNode(6);
   
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = c;

    System.out.println(findLoopStart(a));
  }
}
