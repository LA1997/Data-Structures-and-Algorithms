
public class Lcs {

	public static void path(String s1,String s2,int[][] strg, int i, int j,String psf) {
		
		if(i == s1.length() || j == s2.length()) {
			System.out.println(psf);
			return;
		}
		if(s1.charAt(i) == s2.charAt(j)) {
			path(s1,s2,strg,i+1,j+1,psf+s1.charAt(i));
		}
		else {
			if(strg[i][j] == strg[i+1][j])
				path(s1,s2,strg,i+1,j,psf);
			if(strg[i][j] == strg[i][j+1])
				path(s1,s2,strg,i,j+1,psf);
		}
	}
	public static int lcs(String s1,String s2) {
		
		int[][] strg = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<=s1.length(); i++) {
			for(int j=0; j<=s2.length(); j++) {
				if(i == 0 || j == 0) {
					strg[i][j] = 0;
				}
				else {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						strg[i][j] = strg[i-1][j-1] + 1;
					}
					else {
						strg[i][j] = Math.max(strg[i-1][j], strg[i][j-1]);
					}
				}
			}
		}
		
		path(s1,s2,strg,0,0,"");
		System.out.println();
		return strg[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		
		String s1 = "abcd";
		String s2 = "acbd";
		System.out.println(lcs(s1, s2));
	}

}
