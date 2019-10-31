package alg.array;

import java.util.HashMap;
import java.util.Map;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,3,1,1,2,3,1};
		
	}
	
	public static int cal (int ratings[]) {
		int total = 0;
		int minId = 0;
		Map<Integer, Integer> borders = new HashMap<>();
		
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] < ratings[minId]) {
				minId = i;
			}
		}
		
//		while () {
//			
//		}
		
		return total;
	}
	
	public static int minRate (int ratings[], int start, int end, int base) {
		int minId = start; 
		for (int i = start; i <= end; i++) {
			if (ratings[i] < ratings[minId]) {
				minId = i;
			}
		}
		
		int sum = 1; // minId
		for (int j = minId-1, k = base; j >= start; j--) {
			if (ratings[j] <= ratings[j+1]) {
				sum += minRate(ratings, start, j, k);
			}
			k++;
			sum += k;
		}
		
		for (int m = minId+1, k = base; m <= end; m++) {
			if (ratings[m] >= ratings[m-1]) {
				break; 
			}
			k++;
			sum += k;
		}
		
		return sum;
	}

}
