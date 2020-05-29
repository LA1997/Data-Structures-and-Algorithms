public class DPStairCase2 {

	public static int stairCaseWays(int[] step,int n) {
		
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;			
		}
		int fn = 0;
		for(int i=1; i<=step[n];i++) {
			if(n-i>=0) {
				int fni = stairCaseWays(step,n-i);
				fn += fni;
			}
		}
		return fn;
		
	}
	public static int stairCaseWaysMem(int[] step,int n,int qb[]) {
		
		if(n==0) {
			return 1;
		}
		if(n<0) {
			return 0;
		}
		if(qb[n]!=0) {
			return qb[n];
		}
		int fn = 0;
		for(int i=1; i<=step[n];i++) {
			if(n-i>=0) {
				int fni = stairCaseWaysMem(step,n-i,qb);
				fn += fni;
			}
		}
		qb[n] = fn;
		return fn;
		
	}
	
	public static int stairCaseWaysTab(int[] step) {
		
		int[] strg = new int[step.length];
		strg[0] = 1;
		for(int s=0; s<strg.length; s++) {
			for(int js=1; js<=step[s]; js++) {
				int i=s-js;
				if(i>=0) {
					strg[s] += strg[i]; 
				}
				else
					break;
			}
		}
		
		return strg[strg.length-1];
	}
	
	public static int[] minSteps(int[] step) {
		
		int[] strg = new int[step.length];
		strg[0] = 0;
		
		for(int s=1; s<strg.length; s++) {
			if(step[s] == 0) {
				strg[s] = Integer.MAX_VALUE;
			}
			else {
				strg[s] = Integer.MAX_VALUE;
				for(int js=1; js<=step[s]; js++) {
					int i=s-js;
					if(i>=0) {
						if(strg[i] != Integer.MAX_VALUE) {
							strg[s] = Math.min(strg[s], strg[i]);
						}
					}
				}
				if(strg[s] != Integer.MAX_VALUE)
					strg[s] += 1;
			}
		}
		return strg;
	}
	
	public static void printMinPath(int[] step,int[] strg,int n,String asf) {

		if(n<=0) {
			System.out.println(asf);
			return;
		}
		int minp = strg[n]-1;
		for(int i=1; i<=step[n]; i++) {
			int jp=n-i;
			if(jp>=0) {
				if(strg[jp] == minp) {
					printMinPath(step, strg, jp,asf+n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		int step[] = {0,2,3,1,0,2,0,2,4};
		System.out.println(stairCaseWays(step,n));
		
		int qb[] = new int[n+1];
		System.out.println(stairCaseWaysMem(step,n,qb));
		
		System.out.println(stairCaseWaysTab(step));
		
		int strg[] = new int[step.length];
		strg = minSteps(step);
		System.out.println(strg[strg.length-1]);
		
		String asf = "";
		printMinPath(step, strg, 8, asf);
	}

}
