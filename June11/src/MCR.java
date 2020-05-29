
public class MCR {

	public static int minimumCutRectangle(int l,int b,int[][] strg) {
		
		if(l==0 || b==0) {
			strg[l][b] = 0;
			return 0;
		}
		else if(l == b) {
			strg[l][b] = 1;
			return 1;
		}
		else if(strg[l][b] != 0) {
			return strg[l][b];
		}
		int minval = Integer.MAX_VALUE;
		for(int x=1; x<=Math.min(l, b); x++) {
			int p1v = minimumCutRectangle(x, b-x, strg);
			int p2v = minimumCutRectangle(l-x, b, strg);
			int p1h = minimumCutRectangle(l-x, x, strg);
			int p2h = minimumCutRectangle(l, b-x, strg);
			minval = Math.min(Math.min(p1v+p2v+1, p1h+p2h+1),minval);
				
		}
		strg[l][b] = minval;
		return strg[l][b];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l = 36;
		int b = 30;
		int[][] strg = new int[l+1][b+1];
		System.out.println(minimumCutRectangle(l, b, strg));
	}

}