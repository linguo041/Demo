package alg.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MinPositiveNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input = {1,2,0};
//		int[] input = {4,1,2,3};
//		int[] input = {3,4,-1,1};
//		int[] input = {0,2,2,4,0,1,0,1,3};
		int[] input = {2,1,32,28,2,3};
		System.out.println(calculate(input));
	}
	
	public static int calculate (int[] input) {
		List<Integer[]> ranges = new ArrayList(); 
		
		for (int num : input) {
			if (num > 0) {
				Integer[] range = {num-1, num+1};
				mergeRange(ranges, range);
			}
		}
		
		int min = 1;
		for (Integer[] r : ranges) {
			if (r[0] < 1) {
				return r[1];
			} else {
				min = Math.min(min, r[0]);	
			}
		}
		return min;
	}
	
	public static void mergeRange (List<Integer[]> ranges, Integer[] range) {
		Integer[] merged = range;
		Iterator<Integer[]> it = ranges.iterator();
		
		while (it.hasNext()) {
			Integer[] r = it.next();
			if (r[0] <= merged[0] && r[1] >= merged[1]) {
				return;
			}
			
			boolean changed = false;
			if (r[1] > merged[0] && r[1] < merged[1]) {
				r[1] = merged[1];
				changed = true;
			} else if (r[0] < merged[1] && r[0] > merged[0]) {
				r[0] = merged[0];
				changed = true;
			}
			
			if (changed) {
				merged = r;
				it.remove();
			}
		}
		
		ranges.add(merged);
	}

}
