import java.util.PriorityQueue;

public class KSortedArray {

	public static void KSortedArray(int[] ksorted,int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<=k;i++) {
			pq.add(ksorted[i]);
		}
		for(int i=k+1;i<ksorted.length;i++) {
			System.out.println(pq.remove());
			pq.add(ksorted[i]);
		}
		while(pq.size()>0) {
			System.out.println(pq.remove());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ksorted = {20,40,10,30,50,80,60,90,70,120,110,100};
		int k=2;
		KSortedArray(ksorted, k);
	}

}
