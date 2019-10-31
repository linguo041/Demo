package alg.array;

public class FibCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cal2(4));
	}
	
	public static int cal1(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else if (n == 2) return 2;
		else return cal1(n-1) + cal1(n-2);
	}
	
	public static int cal2(int n) {
		int cur = 1;
		int pre = 0;
		for (int i = 1; i <= n; i++) {
			// cur = cur + pre
			int tmp = cur;
			cur = cur + pre;
			pre = tmp;
		}
		return cur;
	}

}
