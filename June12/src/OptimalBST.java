
public class OptimalBST {

	public static int obst(int[] arr,int[] freq,int[] cf) {
		
		int[][] strg =  new int[arr.length+1][arr.length+1];
		
		for(int gap=1; gap<strg.length; gap++) {
			for(int i=0,j=i+gap; j<strg.length; i++,j++) {
				
				if(gap == 1) {
					strg[i][j] = freq[i];
				} 
				else if(gap == 2) {
					strg[i][j] = Math.min(freq[i]*2+freq[j-1],freq[i]+2*freq[j-1]);
				}
				else {
					int minval = Integer.MAX_VALUE;
					for(int k=0; k<gap; k++) {
						minval = Math.min(minval, strg[i][j-gap+k] + strg[i+k+1][j]);
					}
					strg[i][j] = minval+(cf[j]-cf[i]);
				}
			}
		}
		for(int i=0; i<strg.length; i++) {
			for(int j=1; j<strg[0].length; j++) {
				if(i>j-1) {
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
		int arr[] = {5,7,8,17,20};
		int freq[] = {4,7,5,1,2};
		int cf[] = {0,4,11,16,17,19};
		System.out.println(obst(arr,freq,cf));
	}

}
