
public class MCM {
	public static int matrixChainMulti(int[] dim) {
		
		int[][] strg = new int[dim.length-1][dim.length-1];
		for(int gap=0; gap<strg.length; gap++) {
			for(int i=0,j=i+gap; j<strg.length; i++,j++) {
				if(gap == 0) {
					strg[i][j] = 0;
				}
				else if(gap == 1) {
					strg[i][j] = dim[i] * dim[j] * dim[j+1];
				}
				else {
					int minval = Integer.MAX_VALUE;
					for(int k=0; k<gap; k++) {
						int lhs = strg[i][j-gap+k];
						int rhs = strg[i+k+1][j];
						int mc = dim[i] * dim[i+k+1] * dim[j+1];
						minval = Math.min(minval, lhs+rhs+mc);
					}
					strg[i][j] = minval;
				}
			}
		}
		for(int i=0; i<strg.length; i++) {
			for(int j=0; j<strg[0].length; j++) {
				if(i>j) {
					System.out.print("\t");
				}
				else {
					System.out.print(strg[i][j]+"\t");
				}
			}
			System.out.println();
		}
		return strg[0][strg.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dim[] = {10,20,30,40,50,60};
		System.out.println(matrixChainMulti(dim));
	}

}