import java.util.Stack;

public class MaxArea {

	public static int getmaxarea(int[] arr) {
	
		// Find nse_right
		int n = arr.length;
		int[] resr = new int[n];
		Stack<Integer> stck = new Stack<Integer>();
		resr[n-1] = n;
		stck.push(n-1);
		
		for(int i=n-2;i>=0;i--) {
			
			while(stck.size()>0 && arr[i]<=arr[stck.peek()]) {
				stck.pop();
			}
			resr[i] = (stck.size()>0) ? stck.peek() : arr.length;
			stck.push(i);
		}
		for(int i=0;i<resr.length;i++) {
			System.out.print(resr[i]+" ");
		}
		System.out.println();
	
	// Find nse_left
		int[] resl = new int[n];
		stck = new Stack<Integer>();
		resl[0] = -1;
		stck.push(0);
		
		for(int i=0;i<n;i++) {
			
			while(stck.size()>0 && arr[i]<=arr[stck.peek()]) {
				stck.pop();
			}
			resl[i] = (stck.size()>0) ? stck.peek() : -1;
			stck.push(i);
		}
		for(int i=0;i<resl.length;i++) {
			System.out.print(resl[i]+" ");
		}
		System.out.println();
	
		int areamax = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int area = arr[i]*(resr[i]-resl[i]-1);
			if(area>areamax) {
				areamax=area;
			}
		}
		return areamax;
	}
	public static void main(String[] args) {
		int arr[] = {6,2,5,4,5,1,6};
		int areamax = getmaxarea(arr);
		System.out.println(areamax+"");
	}
}
		
	

