
public class EggDrop {

	public static int eggDropTrials(int f,int e,int[][] strg) {
		
		if(f==0) {
			return 0;
		}
		if(f==1) {
			return 1;
		}
		if(e==1) {
			return f;
		}
		if(strg[f][e] != 0)
			return strg[f][e];
		
		int minval = Integer.MAX_VALUE;
		for(int k=1; k<=f; k++) {
			
			int left = eggDropTrials(k-1, e-1, strg);
			int right = eggDropTrials(f-k, e, strg);
			if(left>right) {
				System.out.print(k-1+" ");
			} else {
				System.out.print(f-k+" ");
			}
			minval = Math.min(minval, Math.max(left, right));
		}
		strg[f][e] = minval+1;
		return strg[f][e];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int f=10;
		int e=2;
		int[][] strg = new int[f+1][e+1];
		System.out.println(eggDropTrials(f, e, strg));
	}

}
