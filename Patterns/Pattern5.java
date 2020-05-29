import java.util.Scanner;
public class Pattern5 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n;j++) {
				if(i==j || i+j==n+1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			
			
		}
	}
}
