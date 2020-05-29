
public class MaxSumNonAdjacent {

	public static int findMaxSumNonAdjacent(int[] arr) {
		
		int inc = 0;
		int exc = 0;
		
		for(int i=0; i<arr.length; i++) {
			int newexc = Math.max(inc, exc);
			int newinc = exc+arr[i];
			inc = newinc;
			exc = newexc;
		}
		return Math.max(inc, exc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,10,100,10};
		System.out.println(findMaxSumNonAdjacent(arr));
	}

}
