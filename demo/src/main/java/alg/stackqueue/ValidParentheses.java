package alg.stackqueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal("()[]"));
	}
	
	public static boolean cal (String s) {
		String left = "([{";
		String right = ")]}";
		
		Stack<Character> stack = new Stack<Character>();
		
		try{
			for (char ch : s.toCharArray()) {
				int rIndex = -1;
				if (left.indexOf(ch) > -1) {
					stack.push(ch);
				} else if ((rIndex = right.indexOf(ch)) > -1) {
					Character lc = stack.pop();
					if (!lc.equals(left.charAt(rIndex))) {
						return false;
					}
				}
			}
		} catch (EmptyStackException e) {
			return false;
		}
		
		if (stack.empty()) {
			return true;
		}
		return false;
	}

}
