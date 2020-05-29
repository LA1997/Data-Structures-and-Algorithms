import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		int nck=1;
		for(int i=0;i<n;i++) {
			nck=1;
//			for(int j=n-i;j>=1;j--)
//				System.out.print("   ");
			for(int j=0;j<=i;j++) {
				System.out.print(nck+"      ");	
				nck = nck*(i-j)/(j+1);
			}
			System.out.println();
		}
	}

}
