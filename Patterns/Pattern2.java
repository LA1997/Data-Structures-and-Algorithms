import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		
		for(int i=1,k=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(k+" ");
				k++;
			}
			System.out.println();
		}
	}

}
