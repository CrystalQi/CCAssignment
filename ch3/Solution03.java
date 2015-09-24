package ch3;
import java.util.*;

/**
 * ch3.03 Stack of plates: implement a setOfStacks
 * @author qxia
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks sos = new SetOfStacks(2);
		
		// basic function: push, pop and 
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		System.out.println(sos.peek()); // {{1,2},{3,4}}
		sos.push(5);
		sos.push(6);
		System.out.println(sos.peek()); // {{1,2},{3,4},{5,6})
		sos.push(7);
		System.out.println(sos.peek()); // {{1,2},{3,4},{5,6},{7})
		sos.pop();
		sos.pop();
		System.out.println(sos.peek()); // {{1,2},{3,4},{5})
		sos.pop();
		sos.pop();
		sos.pop();
		System.out.println(sos.peek()); // {{1,2})
		
		// FollowUp: popAt(index)
		sos.push(11);
		sos.push(12);
		sos.push(13);
		System.out.println(sos.peek()); // {{1,2},{11,12},{13})
		sos.popAt(1);                   // {{1,2},{11,4},{13})
		sos.pop();
		System.out.println(sos.peek()); // {{1,2},{11})
	}
	
	public static class SetOfStacks{
		List<Stack<Integer>> stacks;
		Stack<Integer> currSt;
		int capacity;
		
		public SetOfStacks(int capacity){
			this.capacity = capacity;
			stacks = new ArrayList<Stack<Integer>>();
			currSt = new Stack<Integer>();
			stacks.add(currSt);
		}
		
		public void push(int elem){
			currSt.push(elem);
			if(currSt.size()==capacity){
				Stack<Integer> newSt = new Stack<Integer>();
				stacks.add(newSt);
				currSt = newSt;
			}
		}
		
		public int pop(){
			while(currSt.isEmpty()){
				if(stacks.size()==1){
					throw new EmptyStackException();
				}
				else{
					currSt = stacks.get(stacks.size()-2);				
					stacks.remove(stacks.size()-1);
				}
			}
			
			int ret = currSt.pop();
			return ret;
		}
		
		public int peek(){
			if(currSt.isEmpty()){
				if(stacks.size()==1){
					throw new EmptyStackException();
				}
				else{
					return stacks.get(stacks.size()-2).peek();				
				}
			}
			else{
				return currSt.peek();
			}
			
		}
		
		/**
		 * My Strategy:
		 * - if that idx is beyond the number of stacks we have, throw exception
		 * - if the stack at that index is empty, throw exception. I won't pop out the element from its previous stack
		 * @param idx
		 * @return the element that is popped out
		 */
		public int popAt(int idx){
			if(idx>=stacks.size()-1){
				throw new EmptyStackException();
			}
			if(stacks.get(idx).isEmpty()){
				throw new EmptyStackException();
			}
			
			return stacks.get(idx).pop();
		}
	}

}
