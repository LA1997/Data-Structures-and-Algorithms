import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSeq {

	public static void longestConsecutiveSeq(int[] arr) {
		
		HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>();
		for(int val: arr) {
			hmap.put(val, true);
		}
		for(int val: arr) {
			if(hmap.containsKey(val-1)) {
				hmap.put(val, false);
			}
		}
		int ol = 0;
		int os = 0;
		for(int val: arr) {
			if(hmap.get(val) == true) {
				int tl = 1;
				int ts = val;
				
				while(hmap.containsKey(ts+tl))
					tl++;
				
				if(tl>ol) {
					ol = tl;
					os = ts;
				}
			}
		}
		
		for(int i=os; i< ol+os; i++)
			System.out.print(i+" ");
		System.out.println("\nwith length: "+ol);
		
	}
	public static void main(String[] args) {

		int[] arr = {11,3,5,9,12,2,6,8,1,10,15,25,20,16};
		longestConsecutiveSeq(arr);
	}

}
