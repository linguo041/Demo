package alg.array;

public class WalterCellCalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={0,1,0,2,1,0,1,3,2,1,2,1};
		int left = 0;
		int right = 11;
		int sum = 0;
		
		int maxId = maxAndCalculate(arr, left, right);
		int cTotal = Math.min(left, maxId) * (maxId - left - 1);
		sum += cTotal - calculate(arr, left, right);
		
//		while (maxId > left && left < right) {
//			if () {
//				
//			}
//		}
		int res = trap(arr, 11);
		System.out.println(res);
	}
	
	public static int trap(int A[], int n) {
		int max = 0; //最高的柱子，将数组分为两半
		for (int i = 0; i < n; i++)
			if (A[i] > A[max])
				max = i;
		
		int water = 0;
		for (int i = 0, peak = 0; i < max; i++)
			if (A[i] > peak)
				peak = A[i];
			else
				water += peak - A[i];
		for (int i = n - 1, top = 0; i > max; i--)
			if (A[i] > top)
				top = A[i];
			else
				water += top - A[i];
		return water;
	}
	
	public static int maxAndCalculate(int arr[], int left, int right) {
		int max = arr[left];
		int maxId = left;
		for (int i = left + 1; i <= right; i++) {
			if (arr[i] >= max) {
				max = arr[i];
				maxId = i;
			}
		}
		
		return maxId;
	}
	
	public static int calculate (int arr[], int left, int right) {
		int sum = 0;
		for (int i = left + 1; i < right; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
