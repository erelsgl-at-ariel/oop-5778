package lesson9.stacks;

import lesson9.stacks.Stack0;
import lesson9.stacks.Stack1;

public class StackTest {
	public static void main(String[] args) {
		
		// Bad example:
		System.out.println("Stack0: ");
		Stack0<Integer> stack0 = new Stack0<>();
		stack0.push(111);
		stack0.push(222);
		stack0.push(333);
		stack0.add(1, 444);
		System.out.println(stack0.pop());
		System.out.println(stack0.pop());
		System.out.println(stack0.pop());
		System.out.println(stack0.pop());

		// Better example:
		System.out.println("Stack1: ");
		Stack1<Integer> stack1 = new Stack1<>();
		stack1.push(111);
		stack1.push(222);
		stack1.push(333);
//		stack1.add(1, 444);  // compilation error
//		stack1.list.add(1, 444);  // compilation error
		//System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
	}

}
