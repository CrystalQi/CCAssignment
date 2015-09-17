import java.util.*;
import java.io.*;


/*
Keep track of the carry using a variable and simulate digits-by-digits sum from the head of list, 
which contains the least-significant digit.
Take extra caution:
- When one list is longer than the other.
- The sum could have an extra carry of one at the end. (e.g., (9->9) + (1) = (0->0->1))
*/

public class Solution05 {
	public static class ListNode {
	    ListNode next;
	    int val;
	    public ListNode(int val) {
	      this.val = val;
	    }
	    public String toString() {
	      StringBuilder sb = new StringBuilder();
	      ListNode temp = this;
	      while (temp != null) {
	        sb.append(temp.val);
	        sb.append(' ');
	        temp = temp.next;
	      }
	      return sb.toString();
	    }
	  }

    public static ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        int digit = 0;
        ListNode head = null;
        ListNode pre = null;
        /*
		digit = (l1.val+l2.val+carry)%10; 		
		carry = (l1.val+l2.val+carry)/10;
		*/
        while(l1!=null && l2!=null) {		
            digit = (l1.val+l2.val+carry)%10; 			// get the digit
            carry = (l1.val+l2.val+carry)/10;			// get the carry
            ListNode newListNode = new ListNode(digit);
            if(head==null)
                head = newListNode;
            else
                pre.next = newListNode;
            pre = newListNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {					// l1 is longer than l2
            digit = (l1.val+carry)%10;
            carry = (l1.val+carry)/10;
            ListNode newListNode = new ListNode(digit);
            if(head==null)
                head = newListNode;
            else
                pre.next = newListNode;
            pre = newListNode;
            l1 = l1.next;            
        }

        while(l2!=null)	{					// l2 is longer than l1
            digit = (l2.val+carry)%10;
            carry = (l2.val+carry)/10;
            ListNode newListNode = new ListNode(digit);
            if(head==null)
                head = newListNode;
            else
                pre.next = newListNode;
            pre = newListNode;
            l2 = l2.next;            
        } 
               
        if(carry>0) {		// additional carry at the end, (9->9)+(1)=(0->0->1)
            ListNode newListNode = new ListNode(carry);
            pre.next = newListNode;
        }
        return head;
    }

    public static void main(String[] args) {
	    ListNode a = new ListNode(7);
	    ListNode b = new ListNode(1);
	    ListNode c = new ListNode(6);
	    a.next = b;
	    b.next = c;
	    
	    ListNode d = new ListNode(5);
	    ListNode e = new ListNode(9);
	    ListNode f = new ListNode(2);
	    d.next = e;
	    e.next = f;

	    ListNode x = addLists(a, d);  // Output 2->1->9, That is 912.
	    System.out.println(x);
  }
}
