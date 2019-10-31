package alg.string;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k=3;
		String res = cal("1");
		for (int i=1; i<k-1; i++){
			System.out.println(res);
			res = cal(res);
			
		}
		
	}
	
	public static String cal (String s) {
		char cs [] = s.toCharArray();
		StringBuilder res = new StringBuilder();
		
		int lastId = 0;
		int cnt = 0;
		for (int i=0; i< cs.length; i++) {
			if (cs[lastId] == cs[i]) {
				cnt ++;
			} else {
				res.append(cnt).append(cs[lastId]);
				lastId = i;
				cnt = 1;
			}
		}
		res.append(cnt).append(cs[cs.length-1]);
		
		return res.toString();
	}

}
