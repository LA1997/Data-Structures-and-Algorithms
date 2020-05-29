
public class countabc {

	public static int countabc(String s) {
		
		int counta = 0;
		int countb = 0;
		int countc = 0;
		for(int i=0; i<s.length(); i++) {
			
			if(s.charAt(i) == 'a') {
				counta = 2*counta + 1;
			}
			else if(s.charAt(i) == 'b') {
				countb = 2*countb + counta;
			}
			else if(s.charAt(i) == 'c') {
				countc = 2*countc + countb;
			}
		}
		return countc;
	}
	public static void main(String[] args) {
		
		System.out.println(countabc("abcabc"));
	}

}
