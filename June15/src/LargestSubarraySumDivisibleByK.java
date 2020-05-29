import java.util.ArrayList;
import java.util.HashMap;

public class LargestSubarraySumDivisibleByK {

	public static void largestSubarraySumDivisibleByK(int[] arr,int k) {
		
		int[] arrCummSum = new int[arr.length];		//Cummulative sum
		int[] arrmod4 = new int[arr.length]; 		//arr % 4
		
		arrCummSum[0] = arr[0];
		arrmod4[0] %= k;
		for(int i=1;i<arr.length;i++) {
			arrCummSum[i] = arrCummSum[i-1] + arr[i];
			arrmod4[i] = arrCummSum[i] % k; 
		}
		
		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
		int maxval = Integer.MIN_VALUE;
		int maxi = 0;
		for(int i=0;i<arrmod4.length;i++) {
			if(hmap.containsKey(arrmod4[i]) == false) {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				al.add(i);
				al.add(al.get(1) - al.get(0));
				hmap.put(arrmod4[i], al);
			}
			else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(hmap.get(arrmod4[i]).get(0));
				al.add(i);
				al.add(al.get(1) - al.get(0));
				hmap.put(arrmod4[i], al);
			}
			if(hmap.get(arrmod4[i]).get(2) > maxval) {
				maxval = hmap.get(arrmod4[i]).get(2);
				maxi = i;
			}
		}
		int start = hmap.get(arrmod4[maxi]).get(0);
		int end = hmap.get(arrmod4[maxi]).get(1);
		int sum=0;
		for(int i=start+1; i<=end; i++) {
			System.out.print(arr[i]+" ");
			sum += arr[i];
		}
		System.out.println("\nSum = "+sum);
 	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,1,7,3,2,8,9,4,2,6};
		int k=4;
		largestSubarraySumDivisibleByK(arr,k);
	}

}
