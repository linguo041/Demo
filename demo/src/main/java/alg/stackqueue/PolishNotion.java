package alg.stackqueue;

import java.util.Stack;

public class PolishNotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(cal(tokens));
	}
	
	public static int cal (String [] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if (isOp(s)) {
				int i1 = stack.pop();
				int res = calculate(stack.pop(), i1, s);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
	
	public static int calculate (int s1, int s2, String op) {
		switch (op) {
			case "+": return s1 + s2;
			case "-": return s1 - s2;
			case "*": return s1 * s2;
			case "/": return s1 / s2;
		}
		return 0;
	}
	
	public static boolean isOp(String s) {
		return "+-*/".contains(s);
	}

}
