
public class UnboundedKnapsack {

	public static int knapsack(int[] wt,int[] val,int cap) {
		
		int[] strg = new int[cap+1];
		
		strg[0] = 0;
		for(int i=1; i<strg.length; i++) {
			strg[i] = Integer.MIN_VALUE;
			for(int j=0; j<wt.length; j++) {
				if(wt[j] <= i) {
					int k = val[j] + strg[i-wt[j]];
					strg[i] = Math.max(strg[i], k);
				}
			}
		}
		return strg[strg.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wt = {2,5,1,3,4};
		int[] val = {15,14,10,45,30};
		int cap = 7;
		System.out.println(knapsack(wt, val, cap));	
	}

}
