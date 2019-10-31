package alg.stackqueue;

import java.util.Stack;

public class LongValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal("()()()()(()(()()()"));
	}
	
	public static int cal (String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxLength = 0;
		int last = -1;
		
		for (int i=0; i<s.length(); i++ ) {
			Character ch = s.charAt(i);
			
			if (ch.equals('(')) {
				stack.push(i);
			} else {
				if (stack.empty()) {
					last = i;
				}
				stack.pop();
				if (stack.empty()) {
					maxLength = Math.max(maxLength, i-last);
				} else {
					maxLength = Math.max(maxLength, i-stack.peek());
				}
			}
		}
		
		return maxLength;
	}
	
	public static int cal1 (String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxLength = 0;
		int length = 0;
		
		for (int i=0; i<s.length(); i++ ) {
			Character ch = s.charAt(i);
			
			if (ch.equals('(')) {
				stack.push(i);
			} else {
				if (!stack.empty()) {
					stack.pop();
					length += 2;
				} else {
					maxLength = Math.max(maxLength, length);
					length = 0;
				}
			}
		}
		
		int maxLastLen = 0;
		int currIndex = s.length()-1;
		int leftLength = length;
		while (!stack.empty() && leftLength > 0) {
			Integer lIndex = stack.pop();
			int range = currIndex - lIndex;
			if (range > 1 && range <= leftLength) {
				maxLastLen = Math.max(maxLastLen, range);
				leftLength = leftLength - range;
			}
			currIndex = lIndex-1;
		}
		maxLastLen = Math.max(maxLastLen, leftLength);
		
		return Math.max(maxLastLen, maxLength);
	}

}
