import java.util.Scanner;

public class Pattern8{

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		int spaces=n/2;
		int init=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=spaces;j++) {
				System.out.print("  ");
			}
			for(int k=init,j=1;j<=2*init-1;j++) {
				System.out.print(k+" ");
				if(j<=(2*init-1)/2)
					k++;
				else
					k--;
			}
			if(i<=n/2) {
				spaces--;
				init++;
			}
			else {
				spaces++;
				init--;
			}
			System.out.println();
			
			
		}
	}
}
