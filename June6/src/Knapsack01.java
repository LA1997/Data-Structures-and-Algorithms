
public class Knapsack01 {

	public static int knapsack(int[] wt,int[] val,int cap) {
		
		int[][] strg = new int[wt.length+1][cap+1];
		
		for(int i=0; i<strg.length; i++) {
			for(int j=0; j<strg[i].length; j++) {
				
				if(i==0 || j==0) {
					strg[i][j] = 0;
				}
				else if(wt[i-1] <= j) {
					strg[i][j] = Math.max(strg[i-1][j], strg[i-1][j-wt[i-1]]+val[i-1]);
				}
				else {
					strg[i][j] = strg[i-1][j];
				}
			}
		}
		return strg[strg.length-1][strg[0].length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wt = {2,5,1,3,4};
		int[] val = {15,14,10,45,30};
		int cap = 7;
		System.out.println(knapsack(wt, val, cap));	
	}

}
