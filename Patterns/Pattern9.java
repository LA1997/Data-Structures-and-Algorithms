import java.util.Scanner;

public class Pattern9{

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		int arr[]= {2,7,3,4,5};
		
		int max=arr[0];
		for(int i=1;i<=4;i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		
		for(int i=1;i<=max;i++) {
			for(int j=0;j<=4;j++) {
				if(i>=max-arr[j]+1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
