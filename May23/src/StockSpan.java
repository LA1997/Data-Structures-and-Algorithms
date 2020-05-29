import java.util.Stack;

public class StockSpan {

	public static int[] stockSpan(int[] arr) {
		
		int[] nge = new int[arr.length];
		int[] res = new int[arr.length];
		
		nge[0] = -1;
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(0);
		for(int i=1; i<arr.length; i++) {
			
			while(stck.size()>0 && arr[stck.peek()] < arr[i]) {
				stck.pop();
			}
			nge[i] = stck.size()>0 ? stck.peek() : -1;
			stck.push(i);
		}
		for(int i=0;i<nge.length;i++) {
			System.out.print(nge[i]+" ");
		}
		System.out.println();
		for(int i=0;i<res.length;i++) {
			res[i] = i - nge[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {5,18,13,9,14,20,10,8,6,15,12};
		int[] res = stockSpan(arr);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
	}

}
