package ch3;
import java.util.*;

/**
 * ch3.02 Stack min
 * @authror qxia
 */
public class Solution02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack mst = new MinStack();
		mst.push(8);
		mst.push(6);
		mst.push(17);
		mst.push(11);
		// currently, mst looks like: 8,6,17,11, min should be 6
		System.out.println("Pushed 8,6,17,11, currently, min is:"+mst.min());
		mst.pop();
		mst.pop();
		mst.push(37);
		mst.push(2);
		mst.push(12);
		// currently, mst looks like: 8,6,37,2,12, min should be 2
		System.out.println("Poped out 11 and 17, pushed 37, 2, 12, currently, min is:"+mst.min());
	}
	
	public static class MinStack{
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> minSt = new Stack<Integer>();
		
		public void push(int elem){
			st.push(elem);
			if(minSt.empty() || elem<minSt.peek()){
				minSt.push(elem);
			}
		}
		
		public int pop(){
			int ret = st.pop();
			if(ret==minSt.peek()){
				minSt.pop();
			}
			return ret;
		}
		
		public int min(){
			return minSt.peek();
		}
		
		public int peek(){
			return st.peek();
		}
	}

}
