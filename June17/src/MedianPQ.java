import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ{
		
		PriorityQueue<Integer> spq = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> lpq = new PriorityQueue<Integer>();
		
		void rebalance() {
			if(Math.abs(spq.size()-lpq.size()) == 2) {
				if(spq.size()>lpq.size()) {
					lpq.add(spq.remove());
				}
				else {
					spq.add(lpq.remove());
				}
			}
		}
		public void add(int val) {
			
			if(spq.size()>0 && val<=spq.peek()) {
				spq.add(val);
			}
			else {
				lpq.add(val);
			}
			rebalance();
		}
		public int peek() {
			
			if(lpq.size()>=spq.size()) {
				return lpq.peek();
			}
			else {
				return spq.peek();
			}
		}
		public int remove() {
			if(lpq.size()>=spq.size()) {
				return lpq.remove();
			}
			else {
				return spq.remove();
			}
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MedianPQ pq = new MedianPQ();
			int[] arr = {50,10,80,0,20,90,100,5,70,40};
			for(int i:arr) {
				pq.add(i);
			}
			for(int i=0;i<arr.length;i++) {
				System.out.println(pq.remove());
				
			}
		}
}
	


