package alg.link;

import java.util.ArrayList;
import java.util.Queue;

import alg.AbstractLisitService;
import alg.ListNode;

public class Test extends AbstractLisitService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = {1,2,3,4,5,6,7};
//		ListNode head = build(a);
//		
//		ListNode m = reverse(head);
//		print(m);
		calculate(3);
		System.out.println(res);
		
	}
	
	private static int res = 0;
	
	public static boolean calculate(int n) {
		boolean stop = n < 1;
		res += n;
		
		return stop || calculate(n-1);
	}
	
	

}
