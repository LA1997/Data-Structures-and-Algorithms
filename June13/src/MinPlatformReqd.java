import java.util.Arrays;

public class MinPlatformReqd {

	public static void displayArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public static int minPlatformReqd(int[] arvls,int[] depts){
		
		Arrays.sort(arvls);
		Arrays.sort(depts);
		int minpt = 0;
		int railCount = 0;
		int i=0,j=0;
		//displayArray(arvls);
		//displayArray(depts);
		while(i<arvls.length && j<depts.length) {
			if(arvls[i] <= depts[j]) {
				i++;
				railCount++;
			}
			else {
				j++;
				railCount--;
			}
			if(railCount > minpt) {
				minpt = railCount;
			}
		}
		return minpt;
	}
	public static void main(String[] args) {
		
		int[] arvls = {900,940,950,1100,1500,1800};
		int[] depts = {910,1200,1120,1130,1900,2000};
		System.out.println(minPlatformReqd(arvls, depts));
	}

}
