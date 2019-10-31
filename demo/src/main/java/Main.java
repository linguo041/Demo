import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        } 
        System.out.println(ans);
    }
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int depth = 0;
	        List<Integer> res = new ArrayList<>();
	        while (in.hasNextInt()) {
	            int a = in.nextInt();
	            int b = in.nextInt();
	            System.out.println(a + b);
	        }
	    }

}
