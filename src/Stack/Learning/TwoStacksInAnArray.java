package Stack.Learning;

class TwoStacks {

	int cap, top1, top2;
	int arr[];

	public TwoStacks(int capacity) {

		this.cap = capacity;
		this.top1 = -1;
		this.top2 = cap;
		this.arr = new int[capacity];

	}

	void push1(int x) {

		if (top1 < top2 - 1) {

			top1++;
			arr[top1] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	void push2(int x) {

		if (top1 < top2 - 1) {

			top2--;
			arr[top2] = x;
		} else {
			System.out.println("Stack Overflow");
			System.exit(1);
		}
	}

	int pop1() {

		if (top1 >= 0) {

			int x = arr[top1];
			top1--;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}

	int pop2() {

		if (top2 < cap) {

			int x = arr[top2];
			top2++;
			return x;
		} else {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		return 0;
	}
}

public class TwoStacksInAnArray {

	public static void main(String[] args) {

		// Method 1
		// Divide the array into two halfs, 1st half = (n/2)+1 and 2nd half = n/2.
		// Insert, Pop accordingly.
		// Issue with this method is, even there is space in the array it may through
		// Stack Overflow error.

		// Method 2
		// We will not divide the array, instead we will provide space whichever stack
		// need it.
		
		TwoStacks ts=new TwoStacks(5); 
        ts.push1(5); 
        ts.push2(10); 
        ts.push2(15); 
        ts.push1(11); 
        ts.push2(7); 
        System.out.println("Popped element from stack1 is: " + ts.pop1()); 
        ts.push2(40); 
        System.out.println("Popped element from stack2 is: " + ts.pop2());
	}

}
