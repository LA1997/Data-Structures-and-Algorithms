
public class MinPallCut {

	public static int minPallCut(String s) {
		
		int[][] strg = new int[s.length()][s.length()];
		for(int gap=0; gap<strg.length; gap++){
			for(int i=0,j = gap; j<strg.length; i++,j++) {
				if(gap == 0) {
					strg[i][j] = 0;
				}
				else if(gap == 1) {
					strg[i][j] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
				}
				else {
					if((s.charAt(i) == s.charAt(j)) && (strg[i+1][j-1] == 0)) {
							strg[i][j] = 0;
					}
					else {
						int minval = Integer.MAX_VALUE;
						for(int k=0; k<gap; k++) {
							minval = Math.min(minval, strg[i][j-gap+k] + strg[i+k+1][j]);
						}
						strg[i][j] = minval+1;
					}
				}
			}
			
		}
		for(int i=0; i<strg.length; i++) {
			for(int j=0; j<strg[0].length; j++) {
				if(i>j) {
					System.out.print("  ");
				}
				else {
					System.out.print(strg[i][j]+" ");
				}
			}
			System.out.println();
		}
		return strg[0][strg.length-1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minPallCut("abccbc"));
	}

}
