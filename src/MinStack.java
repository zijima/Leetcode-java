import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	    Stack<Integer> stack = new Stack<Integer>();
	    Stack<Integer> min = new Stack<Integer>();
	    public void push(int x) {
	        stack.push(x);
	        if(min.isEmpty() || x <= min.peek()){
	            min.push(x);
	        }
	    }

	    public void pop() {
	        int top = stack.peek();
	        if (top == min.peek()){
	            min.pop();
	        }
	        stack.pop();
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min.peek();
	    }
}
