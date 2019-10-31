package alg.array;

public class MinGasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startF = 10, target = 100;
		int a[][] = {{10,20},{20,30},{30,30},{60,40}};
		
		System.out.print(cal(startF, target, a));
	}
	
	public static int cal(int startF, int target, int stations[][]) {
		int maxReach = startF;
		int count = 0;
		
		while (maxReach < target) {
			int maxFuel = 0;
			int maxId = 0;
			for (int i = 0; i < stations.length && stations[i][0] <= maxReach; i++) {
				if (stations[i][1] > maxFuel) {
					maxFuel = stations[i][1];
					maxId = i;
				}
			}
			
			if (maxFuel > 0) {
				maxReach += maxFuel;
				stations[maxId][1] = 0;
				count ++;
			} else {
				return -1;
			}
		}
		
		return count;
	}

}
