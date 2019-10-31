package alg.sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,4,7,6,2,9,5};
		quickSort(input, 0, input.length-1);
		for (int e : input) {
			System.out.print(e + " ");
		}
		
	}
	
	public static void quickSort (int[] input, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int i = start, j = end;
		int base = input[start];
		
		while (i<j) {
			while (input[j] >= base && i<j) {
				j--;
			}
			while (input[i] <= base && i<j) {
				i++;
			}
			
			if (i<j) {
				swap(input, i, j);
			}
		}
		
		swap(input, start, i);
		quickSort(input, start, i-1);
		quickSort(input, i+1, end);
	}
	
	public static void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
