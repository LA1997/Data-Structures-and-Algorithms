import java.util.Scanner;

public class Pattern7{

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		int stars=n/2+1;
		int spaces=1;
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=stars;j++)
				System.out.print("*");
			for(int j=1;j<=spaces;j++)
				System.out.print(" ");
			for(int j=1;j<=stars;j++)
				System.out.print("*");
			
			if(i<=n/2) {
				stars--;
				spaces+=2;
			}
			else {
				spaces-=2;
				stars++;
			}
			System.out.println();
			
			
		}
	}
}
