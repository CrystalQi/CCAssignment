package ch3;
import java.util.*;

/**
 * ch3.04 Implement a queue with two stacks
 * @author qxia
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue mq = new MyQueue();
		mq.enQueue(1);
		mq.enQueue(2);
		mq.enQueue(3);
		mq.enQueue(4);
		System.out.println(mq.peek()); // {1,2,3,4}
		mq.deQueue();
		mq.deQueue();
		System.out.println(mq.peek()); // {3,4}
	}

	/**
	 * Every time enqueue pushes the new element to stack1
	 * Every time dequeue get elemeng from top of stack2, 
	 * if stack2 is empty, dump all the element of stack1 to stack2 then do the pop.
	 * 
	 * @author qxia
	 */
	public static class MyQueue {
		Stack<Integer> st1;
		Stack<Integer> st2;
		
		public MyQueue(){
			st1 = new Stack<Integer>();
			st2 = new Stack<Integer>();
			
		}
		
		public void enQueue(int elem){
			st1.push(elem);
		}
		
		public int deQueue(){
			peek();
			if(st2.isEmpty()){
				throw new EmptyStackException();
			}
			else{
				return st2.pop();
			}
		}
		
		public int peek(){
			if(st2.isEmpty()){
				while(!st1.isEmpty()){
					st2.push(st1.pop());
				}
			}
			return st2.peek();
		}
		
		public int size(){
			return st1.size() + st2.size();
		}
		
		public boolean isEmpty(){
			return this.size()==0;
		}
	}
}
