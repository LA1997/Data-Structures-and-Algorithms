import java.util.Stack;

public class nge_rtl {

	public static void nge(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stck = new Stack<Integer>();
		res[n-1] = -1;
		stck.push(arr[n-1]);
		for(int i=arr.length-2;i>=0;i--) {
			while(stck.size()>0 && arr[i]>stck.peek()) {
				stck.pop();
			}
			
			res[i] = (stck.size()>0) ? stck.peek(): -1;
			stck.push(arr[i]);
		}
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {

		int arr1[] = {3,1,2,4,5,3,2,1,4};
		nge(arr1);
	
		int arr2[] = {6,2,4,8,5,3,2,4,6,7};
		nge(arr2);
	}
}
