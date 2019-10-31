package alg.array;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 4
//		int a[] = {5,1,2,3,4};
//		int b[] = {4,4,1,5,1};
		
		// 3
//		int a[] = {1,2,3,4,5};
//		int b[] = {3,4,5,1,2};
		
		// 0
		int a[] = {3,1,1};
		int b[] = {1,2,2};

		System.out.print(cal(a, b));
	}
	
	public static int cal(int a[], int b[]) {
		int sum = 0;
		int segSum = 0;
		int segStart = -1;
		
		for (int i = 0; i < a.length; i++) {
			int c = a[i] - b[i];
			sum += a[i] - b[i];
			
			if (segSum + c >= 0) {
				segSum += c;
			} else {
				segSum = c >= 0 ? c : 0;
				segStart = i;
			}
		}
		
		if (sum < 0) {
			return -1;
		}
		
		return segStart + 1;
	}

}
