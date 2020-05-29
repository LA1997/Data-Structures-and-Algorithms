import java.util.Arrays;

public class FractionalKnapsack {

	public static class Item implements Comparable<Item>{
		int wt;
		int val;
		float ratio;
		public Item(int wt,int val) {
			this.wt = wt;
			this.val = val;
			this.ratio = (float)val/(float)wt;
		}
		public int compareTo(Item i) {
			if(this.ratio > i.ratio) {
				return 1;
			}
			else if(this.ratio < i.ratio) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	public static int fractionalKnapsack(int[] wts,int[] vals,int cap) {
		
		Item[] items = new Item[wts.length];
		for(int i=0; i<items.length; i++) {
			items[i] = new Item(wts[i],vals[i]);
		}
		Arrays.sort(items);
		int vib = 0;
		int rc = cap;
		for(int i=items.length-1; i>=0; i--) {
			if(rc >= items[i].wt) {
				rc -= items[i].wt;
				vib += items[i].val;
			}
			else {
				vib += items[i].ratio * rc;
				rc = 0;
				break;
			}
		}
		return vib;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = {10,40,20,30};
		int[] vals = {60,40,100,120};
		int cap = 50;
		System.out.println(fractionalKnapsack(wts, vals, cap));
	}

}
