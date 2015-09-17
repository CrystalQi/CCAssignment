import java.util.*;
import java.io.*;

public class Solution06 {
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
	        sb.append(curr.val);
	        curr = curr.next;
	      }
	      return sb.toString();
	    }
    }

    

    public static boolean isPalindrome(ListNode head) {
	    if(head == null) {
	    	return true;
	    }
	       
	    ListNode p = head;
	    ListNode prev = new ListNode(head.val);
	    //  get a reversed LinkedList of the original one
	    while(p.next != null){
	        ListNode temp = new ListNode(p.next.val);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	 
	    ListNode p1 = head;
	    ListNode p2 = prev;
	    //  if it is a palindrome, the reversed one should have the same content with the original one 
	    while(p1!=null){
	        if(p1.val != p2.val)
	            return false;
	        p1 = p1.next;
	        p2 = p2.next;
	    }
	 
	    return true;
    }

    public static void main(String[] args) {
	    ListNode a = new ListNode('s');
	    ListNode b = new ListNode('o');
	    ListNode c = new ListNode('s');
	    a.next = b;
	    b.next = c;
	    System.out.println(isPalindrome(a) ? "is palindrome" : "not a palindrome");
	    System.out.println(isPalindrome(b) ? "is palindrome" : "not a palindrome");    
  }

}
