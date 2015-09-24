package ch3;
import java.util.*;
/**
 * ch3.05 Sort Stack: receive a stack, smallest element is on the top
 * @author qxia
 *
 */
public class Solution05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> origSt = new Stack<Integer>();
		origSt.push(2);
		origSt.push(8);
		origSt.push(5);
		origSt.push(7);
		origSt.push(1);
		origSt.push(4);
		SortStack ss = new SortStack(origSt);
		System.out.println(ss.peek());
		ss.pop();
		System.out.println(ss.peek());
		ss.pop();
		System.out.println(ss.peek());
		ss.pop();
		System.out.println(ss.peek());
		ss.pop();
		System.out.println(ss.peek());
		ss.pop();
		System.out.println(ss.peek());
		ss.pop();
	}

	public static class SortStack {
		Stack<Integer> st1;
		Stack<Integer> st2;
		boolean peeked;
		
		public SortStack(Stack<Integer> origSt){
			st1 = origSt;
			st2 = new Stack<Integer>();
			peeked = false;
		}
		
		public int peek(){
			int ret;
			if(st1.isEmpty() && st2.isEmpty()){
				throw new EmptyStackException();
			}
			else if(!st1.isEmpty()){
				if(peeked){
					ret =  st1.peek();
				}
				else{
					reOrganize(st1, st2);
					ret = st2.peek();
				}
			}
			else{
				if(peeked){
					ret = st2.peek();
				}
				else{
					reOrganize(st2, st1);
					ret = st1.peek();
				}
			}
			return ret;
		}
		
		// supposing elements are in st1, and we'll pop them all out, find the min
		// after that, every element is on st2, and min is on top of st2
		private void reOrganize(Stack<Integer> st1, Stack<Integer> st2){
			int min = st1.pop();
			while(!st1.isEmpty()){
				if(st1.peek()>=min){
					st2.push(st1.pop());
				}
				else{
					st2.push(min);
					min = st1.pop();
				}
			}
			
			st2.push(min);
			peeked = true;
		}
		
		public int pop(){
			int ret;
			if(st1.isEmpty() && st2.isEmpty()){
				throw new EmptyStackException();
			}
			else if(!st1.isEmpty()){
				if(peeked){
					ret = st1.pop();
				}
				else{
					peek();
					ret = st2.pop();
				}
			}
			else{
				if(peeked) {
					ret = st2.pop();
				}
				else{
					peek();
					ret = st1.pop();
				}
			}
			
			peeked = false;
			return ret;
		}
		
		public void push(int elem){
			if(peeked){
				if(st1.isEmpty()){
					if(st2.isEmpty() || elem<st2.peek()){
						st2.push(elem);
					}
					else{
						int tmp = st2.pop();
						st2.push(elem);
						st2.push(tmp);
					}
				}
				else{
					if(st1.isEmpty() || elem<st1.peek()){
						st2.push(elem);
					}
					else{
						int tmp = st1.pop();
						st1.push(elem);
						st1.push(tmp);
					}
				}
			}
			else{
				if(st1.isEmpty()){
					st2.push(elem);
				}
				else{
					st1.push(elem);
				}
			}
		}
	}
	
}
