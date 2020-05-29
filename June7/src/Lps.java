
public class Lps {

	public static int lps(String s) {
		
		int[][] strg = new int[s.length()][s.length()];
		
		for(int gap=0; gap<strg.length; gap++){
			for(int i=0,j = gap; j<strg.length; i++,j++) {
				
				if(gap == 0) {
					strg[i][j] = 1;
				}
				else {
					if(s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 2+strg[i+1][j-1];
					}
					else {
						strg[i][j] = Math.max(strg[i+1][j], strg[i][j-1]);
					}
				}
			}
		}
		
		return strg[0][strg.length-1];
	}
	public static int cps(String s) {
		
		int[][] strg = new int[s.length()][s.length()];
		
		for(int gap=0; gap<strg.length; gap++){
			for(int i=0,j = gap; j<strg.length; i++,j++) {
				
				if(gap == 0) {
					strg[i][j] = 1;
				}
				else {
					if(s.charAt(i) == s.charAt(j)) {
						strg[i][j] = strg[i][j-1] + strg[i+1][j] + 1;
					}
					else {
						strg[i][j] = strg[i][j-1] + strg[i+1][j] - strg[i+1][j-1];
					}
				}
			}
		}
		
		return strg[0][strg.length-1];
	}
	
	public static void main(String[] args) {
		System.out.println(lps("abkccgbc"));
		System.out.println(cps("abgcckyb"));
	}

}
