import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {

	public static void kLargestElements1(int[] arr,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		for(int i=0;i<k;i++) {
			System.out.println(pq.remove());
		}
	}
	public static void kLargestElements2(int[] arr,int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0;i<k;i++) {
			pq.add(arr[i]);
		}
		for(int i=k;i<arr.length;i++) {
			if(arr[i]>pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}
		System.out.println(pq);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,8,14,5,6,1,9,4,20,3,11};
		kLargestElements2(arr, 4);
	}

}
