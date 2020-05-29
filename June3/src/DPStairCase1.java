import java.time.*;
public class DPStairCase1 {

	public static int stairCaseWays(int n) {
		
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n<0) {
			return 0;
		}
		int fnm1 = stairCaseWays(n-1);
		int fnm2 = stairCaseWays(n-2);
		int fnm3 = stairCaseWays(n-3);
		int fn = fnm1+fnm2+fnm3;
		return fn;
		
	}
	public static int stairCaseWaysMem(int n,int qb[]) {
		
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(n<0) {
			return 0;
		}
		if(qb[n]!=0) {
			return qb[n];
		}
		int fnm1 = stairCaseWays(n-1);
		int fnm2 = stairCaseWays(n-2);
		int fnm3 = stairCaseWays(n-3);
		int fn = fnm1+fnm2+fnm3;
		qb[n] = fn;
		return fn;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		System.out.println(LocalDateTime.now());
		System.out.println(stairCaseWays(n));
		System.out.println(LocalDateTime.now());
		
		int qb[] = new int[n+1];
		System.out.println(LocalDateTime.now());
		System.out.println(stairCaseWaysMem(n, qb));
		System.out.println(LocalDateTime.now());
		
	}

}
