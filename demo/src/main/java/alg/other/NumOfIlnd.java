package alg.other;

import java.util.HashMap;
import java.util.Map;

public class NumOfIlnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1', '1', '1', '1', '0'},
		                 {'1', '1', '0', '1', '0'},
						 {'1', '1', '0', '0', '1'},
						 {'0', '0', '1', '0', '1'}};
		
		System.out.println(calculate(grid));
	}
	
	public static int calculate(char[][] grid) {
		Map<String, Boolean> status = new HashMap();
		int cnt = 0;
		
		for (int i=0; i< grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				if (status.get(coordinate(i,j)) == null) {
					if (grid[i][j] == '1') {
						cnt ++;
					}
					markIland(grid, i, j, status);
				}
			}
		}
		
		return cnt;
	}
	
	public static void markIland(char[][] grid, int i, int j, Map<String, Boolean> status) {
		status.put(coordinate(i,j), true);
		
		if (grid[i][j] == '1') {
			if (i>0 && status.get(coordinate(i-1,j)) == null) {
				markIland(grid, i-1, j, status);
			}
			if (i<grid.length-1 && status.get(coordinate(i+1,j)) == null) {
				markIland(grid, i+1, j, status);
			}
			if (j>0 && status.get(coordinate(i,j-1)) == null) {
				markIland(grid, i, j-1, status);
			}
			if (j<grid[0].length-1 && status.get(coordinate(i,j+1)) == null) {
				markIland(grid, i, j+1, status);
			}
		}
	}
	
	public static String coordinate(int i, int j) {
		return i+","+j;
	}

}
