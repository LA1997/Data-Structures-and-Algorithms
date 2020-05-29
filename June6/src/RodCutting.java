
public class RodCutting {

	public static int rodCutting1(int[] cost,int len) {
		
		int[] strg = new int[len+1];
		String[] path = new String[len+1];
		for(int i=0;i<path.length;i++) {
			path[i] = "";
		}
		strg[0] = 0;
		for(int i=1; i<strg.length; i++) {
			for(int j=0; j<cost.length; j++) {
				if(i>=j) {
					if(strg[i] <= cost[j]+strg[i-j]) {
						strg[i] = cost[j]+strg[i-j];
						path[i] = "["+j+"]"+path[i-j];
					}
				}
			}
		}
		System.out.println(path[path.length-1]);
		return strg[strg.length-1];
	}
public static int rodCutting2(int[] cost,int len) {
		
		int[] strg = new int[len+1];
		strg[0] = 0;
		for(int i=1; i<strg.length; i++) {
			strg[i] = cost[i];
			int left = 0;
			int right = i;
			while(left <= right) {
				strg[i] = Math.max(strg[i],strg[left]+strg[right]);
				left++;
				right--;
			}
		}
		return strg[strg.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = {0,3,5,6,15,10,25,12,24};
		int len = 8;
		System.out.println(rodCutting2(cost, len));
	}

}
