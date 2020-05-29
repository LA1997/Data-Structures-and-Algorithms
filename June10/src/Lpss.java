
public class Lpss {

	
	public static void lacpss(String s) {
		
		boolean[][] strg = new boolean[s.length()][s.length()];
		int count = 0;
		int length = 0;
		for(int gap=0; gap<strg.length; gap++){
			for(int i=0,j = gap; j<strg.length; i++,j++) {
				if(gap == 0) {
					strg[i][j] = true;
					count++;
					if(gap+1>length)
						length = gap+1;
				}
				else if(gap == 1) {
					if(s.charAt(i) == s.charAt(j)) {
						strg[i][j] = true;
						count++;
						length = gap+1;
					}
				}
				else {
					if(s.charAt(i) == s.charAt(j)) {
						if(strg[i+1][j-1] == true) {
							strg[i][j] = true;
							count++;
							length = gap+1;
						}
					}
				}
			}
		}
		System.out.println(count+" "+length);
	}
	public static void main(String[] args) {
		lacpss("abccbc");
	}

}
