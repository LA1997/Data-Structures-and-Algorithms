import java.util.Stack;

public class slidingWindow {

	public static int[] slidingWindowMax(int arr[],int k) {
		
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> stck = new Stack<>();
		
		nge[n-1] = n;
		stck.push(n-1);
		for(int i=n-2;i>=0;i--) {
			
			while(stck.size()>0 && arr[stck.peek()]<arr[i]) {
				stck.pop();
			}
			nge[i] = (stck.size()>0) ? stck.peek() : arr.length;
			stck.push(i);
		}
		
		int[] res = new int[arr.length-k+1];
		int j=0;
		for(int i=0;i<n-k+1;i++) {
			
			if(j<i) {
				j=i;
			}
			while(nge[j] < i+k) {
				j = nge[j];
			}
			res[i] = j;
		}
		return res;
	}
	public static void main(String[] args) {
		
		int arr[] = {4,9,5,2,7,10,6,12,8,15};
		//int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int k=5;
		int res[] = new int[arr.length-k+1];
		res = slidingWindowMax(arr, k);
		System.out.println();
		for(int i=0;i<res.length;i++) {
			System.out.print(arr[res[i]]+" ");
		}
		
	}

}
