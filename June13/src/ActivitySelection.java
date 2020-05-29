import java.util.Arrays;

public class ActivitySelection {

	public static class Activity implements Comparable<Activity>{
		String name;
		int start;
		int end;
		public Activity(String name,int start,int end) {
			this.name = name;
			this.start = start;
			this.end = end;
		}
		public int compareTo(Activity a) {
			return this.end-a.end;
		}
	}
	public static int activitySelection(String[] names,int[] starts,int[] ends) {
		
		Activity[] acts = new Activity[starts.length];
		for(int i=0; i<starts.length; i++) {
			acts[i] = new Activity(names[i],starts[i],ends[i]);
		}
		Arrays.sort(acts);
		int maxact = 1;
		int curend = acts[0].end;
		String ca = acts[0].name;				//chosen activities
		for(int i=1; i<acts.length; i++) {
			if(acts[i].start >= curend) {
				maxact++;
				curend = acts[i].end;
				ca = ca+" "+acts[i].name;
			}
		}
		System.out.println(ca);
		return maxact;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"a","b","c","d","e","f"};
		int[] starts = {3,0,1,8,5,5};
		int[] ends =   {4,6,2,9,9,7};
		System.out.println(activitySelection(names,starts, ends));
	}

}
