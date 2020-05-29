import java.util.Arrays;
import java.util.Stack;

public class OverlappingIntervals {

	public static class Interval implements Comparable<Interval>{
		
		public int start;
		public int end;
		public Interval(int start,int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(Interval o) {
			return (this.start - o.start);
		}
	}
	public static void overlappingIntervals(int[] start,int[] end) {
		
		Interval[] intvs = new Interval[start.length];
		for(int i=0;i<intvs.length;i++) {
			intvs[i] = new Interval(start[i],end[i]);
		}
		Arrays.sort(intvs);
		
		Stack<Interval> stck = new Stack<>();
		stck.push(intvs[0]);
		for(int i=0;i<intvs.length;i++) {
			if(intvs[i].start < stck.peek().end) {
				stck.peek().end = Math.max(stck.peek().end, intvs[i].end);
			}
			else {
				stck.push(intvs[i]);
			}
		}
		while(stck.size()>0) {
			Interval res = stck.pop();
			System.out.println("["+res.start+" - "+res.end+" ]");
		}
	}
	public static void main(String[] args) {

		int[] start = {2,6,12,3,22,17,19};
		int[] end = {4,9,15,7,26,20,23};
		overlappingIntervals(start, end);
		
	}

}
