import java.util.HashMap;

public class PrintCommonElement {

	public static void printCommonElement1(int[] one,int[] two) {
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i=0; i<one.length; i++) {
			hmap.put(one[i], 1);
		}
		for(int j=0; j<two.length; j++) {
			if(hmap.containsKey(two[j])) {
				System.out.print(two[j]+" ");
				hmap.remove(two[j]);
			}
		}
		System.out.println();
	}
	public static void printCommonElement2(int[] one, int[] two) {
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i=0; i<one.length; i++) {
			if(hmap.containsKey(one[i]))
				hmap.put(one[i], hmap.get(one[i])+1);
			else
				hmap.put(one[i], 1);
		}
		
		for(int j=0; j<two.length; j++) {
			if(hmap.containsKey(two[j]) && hmap.get(two[j])>0) {
				System.out.print(two[j]+" ");
				hmap.put(two[j], hmap.get(two[j])-1);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] one = {2,1,5,1,3,2,1};
		int[] two = {4,5,2,1,2,1,2};
		printCommonElement1(one, two);
		printCommonElement2(one, two);
		
	}

}
