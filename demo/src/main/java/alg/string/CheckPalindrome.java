package alg.string;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
			
		if (s.isEmpty()) {
			return true;
		}
		
		char[] cs = s.toCharArray();
		int i=0, j=cs.length-1;
		
		while (i < j) {
			if (!isAlDi(cs[i])){
				i++;
			} else if (!isAlDi(cs[j])) {
				j--;
			} else {
				if (Character.toLowerCase(cs[i]) != Character.toLowerCase(cs[j])) {
					return false;
				}
				i++;
				j--;
			}
		}
		
		return true;
	}
	
	public static boolean isAlDi(char c) {
		return Character.isAlphabetic(c) || Character.isDigit(c);
	}

}
