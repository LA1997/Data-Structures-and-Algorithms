
public class CountStringNotConsecutiveZeros {

	public static int countStringNotConsecutiveZeros(int n) {
		int count0 = 1;
		int count1 = 1;
		for(int i=2; i<=n; i++) {
			int newcount0 = count1;
			int newcount1 = count0 + count1;
			count0 = newcount0;
			count1 = newcount1;
		}
		return count0 + count1;
	}
	public static void main(String[] args) {
		
		System.out.println(countStringNotConsecutiveZeros(5));
	}

}
