import java.util.Stack;

public class nge_ltr {

	public static void nge(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(0);
		for(int i=1;i<n;i++) {
			
			while(stck.size()>0 && arr[i]>arr[stck.peek()]) {
				res[stck.pop()] = arr[i];
			}
			stck.push(i);
		}
		while(stck.size()>0) {
			res[stck.pop()] = -1;
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
