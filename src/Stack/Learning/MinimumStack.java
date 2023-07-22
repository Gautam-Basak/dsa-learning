package Stack.Learning;

import java.util.Stack;

class Pair {

	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class MinStack {

	Stack<Pair> st;

	public MinStack() {
		st = new Stack<>();
	}

	void push(int x) {

		int min;
		if (st.isEmpty()) {
			min = x;
		} else {
			min = Math.min(x, st.peek().y);
		}
		st.push(new Pair(x, min));
	}

	public void pop() {
		st.pop();
	}

	public int top() {
		return st.peek().x;
	}

	public int getMin() {
		return st.peek().y;
	}
}

class MiniStack {

	Stack<Long> s = new Stack<>();

	Long mini;

	public MiniStack() {
		mini = Long.MAX_VALUE;
	}

	void push(int x) {

		Long val = Long.valueOf(x);
		if (s.isEmpty()) {
			mini = val;
			s.push(mini);
		} else {
			if (val < mini) {
				s.push(2 * val - mini);
				mini = val;
			} else
				s.push(val);
		}
	}

	void pop() {

		if (s.isEmpty())
			return;

		Long val = s.pop();
		if (val < mini)
			mini = 2 * mini - val;
	}

	int top() {

		Long val = s.peek();

		if (val < mini)
			return mini.intValue();

		return val.intValue();
	}

	int getMin() {
		return mini.intValue();
	}
}

public class MinimumStack {

	public static void main(String[] args) {

		// Implement Min Stack in O(2N) and O(N) Space Complexity. Design a stack that
		// supports push, pop, top, and retrieving the minimum element in constant time.
		
		// T.C = O(1)
		// S.C = O(2n) -> Stack is of type Pair where we enter two values.
		MinStack ms = new MinStack();

		ms.push(-2);
		ms.push(0);
		ms.push(-3);

		System.out.println("Peek element : " + ms.top());
		System.out.println("Minimum stack element : " + ms.getMin());
		ms.pop();
		System.out.println("Peek element : " + ms.top());
		System.out.println("Minimum stack element : " + ms.getMin());

		// T.C = O(1)
		// S.C = O(n) - As there is no pair used instead Mini value is being manipulated
		MiniStack minStc = new MiniStack();

		minStc.push(-2);
		minStc.push(0);
		minStc.push(-3);

		System.out.println("\nnnPeek element : " + minStc.top());
		System.out.println("Minimum stack element : " + minStc.getMin());
		minStc.pop();
		System.out.println("Peek element : " + minStc.top());
		System.out.println("Minimum stack element : " + minStc.getMin());
	}

}
