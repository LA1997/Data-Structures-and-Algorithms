import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static class Helper implements Comparable<Helper>{
		public int val;
		public int di;
		public int li;
		public Helper(int val,int di,int li) {
			this.val = val;
			this.di = di;
			this.li = li;
		}
		public int compareTo(Helper o) {
			return this.val-o.val;
		}
		public String toString() {
			return "lists["+this.li+"]["+this.di+"]="+val;
		}
	}
	public static void mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		
		PriorityQueue<Helper> pq = new PriorityQueue<Helper>();
		for(int i=0;i<lists.size();i++) {
			pq.add(new Helper(lists.get(i).get(0),0,i));
		}
		
		
		while(pq.size()>0) {
			Helper h = pq.remove();
			System.out.println(h.val);
			h.di++;
			if(h.di < lists.get(h.li).size()) {
				h.val = lists.get(h.li).get(h.di);
				pq.add(new Helper(h.val,h.di,h.li));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		lists.add(new ArrayList<>(Arrays.asList(2,5,9,18,20,25)));
		lists.add(new ArrayList<>(Arrays.asList(3,7,8,15,22)));
		lists.add(new ArrayList<>(Arrays.asList(0,4,6,12)));
		lists.add(new ArrayList<>(Arrays.asList(1,10,16,21,28)));
		mergeKSortedLists(lists);
	}

}
