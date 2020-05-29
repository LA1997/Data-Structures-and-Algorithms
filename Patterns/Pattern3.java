import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		int a1=0;
		int a2=1;
		int a3=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(a1+" ");
				a3 = a1+a2;
				a1 = a2;
				a2 = a3;
			}
			System.out.println();
		}
	}

}
