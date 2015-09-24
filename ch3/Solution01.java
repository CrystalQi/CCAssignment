import java.util.*;
import java.io.*;

class FullStackException extends Exception {
	private static final long serialVersionUID = 1L;
	public FullStackException(){
        super();
    }
}



public class Solution01 {
    private static int numberOfStacks = 3;
	private static int stackCapacity;
	private static int[] values;
	private static int[] sizes;
	
	public Solution01(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		//size[i]: record the number of elements in each stack#i
		sizes = new int[numberOfStacks];
	}

	/* Push value onto stack  */
	public void push(int stackNum, int value) throws FullStackException {
		if (isFull(stackNum)) { 
			throw new FullStackException();
		}
		/* Increment stack pointer and then update top value. */		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;	
	}

	/* Pop item from top stack. */
	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
            return -1;
            //-1 denotes the EmptyStackException
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
        //assume valid element are positive numbers, 0 denotes empty space
        values[topIndex] = 0;  
		sizes[stackNum]--; 
		return value;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
            return -1;
		}		
		return values[indexOfTop(stackNum)];
	}

	
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	/* Get the index of the top element of the stack #stackNum. */
	private int indexOfTop(int stackNum) {
		int size = sizes[stackNum];
		return stackNum * stackCapacity + size - 1;
	}	
	
	public int[] getValues() {
		return values;
	}
	
	//Get values in stack #stackNum
	public static int[] getStackValues(int stackNum) {
		int[] items = new int[sizes[stackNum]];
		for (int i = 0; i < items.length; i++) {
			items[i] = values[stackNum * stackCapacity + i];
		}
		return items;
	}
	
	//print values in stack#0, stack#1, stack#2 
	public static void printStacks(Solution01 stacks) {

		for (int item : getStackValues(0))
		    System.out.println("stack0:"+item + " ");
	    System.out.println();
        for (int item : getStackValues(1))
		    System.out.println("stack1:"+item + " ");
	    System.out.println();
	    for (int item : getStackValues(2))
		    System.out.println("stack2:"+item + " ");
	    System.out.println();
	}

	public static void main(String [] args) throws Exception  {
		Solution01 stacks = new Solution01(5);
		printStacks(stacks);
		stacks.push(0, 1);
		printStacks(stacks);
		stacks.push(1, 2);
		printStacks(stacks);
		stacks.push(2, 3);
		printStacks(stacks);
		
		stacks.push(1, 21);
		printStacks(stacks);
        stacks.push(0, 12);
		printStacks(stacks);
		
		stacks.pop(0);
		printStacks(stacks);
		
		stacks.push(2, 71);
		printStacks(stacks);
		
		stacks.push(0, 15);
		printStacks(stacks);
		stacks.push(1, 4);
		printStacks(stacks);
		
		stacks.push(2, 71);
		printStacks(stacks);
		stacks.push(2, 32);
		printStacks(stacks);
        stacks.push(2, 100);
        printStacks(stacks);

	}	
}
