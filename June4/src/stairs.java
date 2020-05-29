public class stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mem = new int[9];
		mem[0] = 0;
//		mem[2] = 2;
//		System.out.println(stair(7,mem));
		int[] arr = { 0, 2, 3, 1, 0, 2, 0, 2, 4 };
//		System.out.println(minSteps(arr));
		int[][] cost = { { 2, 6, 5, 1, 3, 4 }, { 0, 4, 9, 2, 9, 0 }, { 4, 8, 1, 0, 6, 5 }, { 0, 3, 3, 1, 5, 4 },
				{ 1, 2, 7, 0, 6, 9 }, { 5, 7, 1, 3, 8, 2 }

		};
		System.out.println(mazeCost(cost));
	}
//	static String[] memAs = new String[9];

	public static int stair(int n, int[] mem) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (mem[n] != 0) {
			return mem[n];
		}
		int ctr = 0;
		ctr += stair(n - 1, mem);
		ctr += stair(n - 2, mem);
		ctr += stair(n - 3, mem);
		mem[n] = ctr;
		return ctr;
	}

	public static int trickyStairs(int n, int[] arr, int[] mem) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (mem[n] != 0) {
			return mem[n];
		}
		int ctr = 0;
		for (int i = 1; i <= arr[n]; i++) {
			ctr += trickyStairs(n - i, arr, mem);
		}
		mem[n] = ctr;
		return ctr;
	}

	// with tabulation
	public static int trickyStairsTab(int[] jump) {

		int[] tab = new int[jump.length];
		tab[0] = 1;
		for (int s = 1; s < jump.length; s++) {
			for (int js = 1; js <= jump[s]; js++) {
				int i = s - js;
				if (i >= 0) {
					tab[s] += tab[i];
				}
			}
		}
		return tab[tab.length - 1];
	}

	// min steps
	public static int minSteps(int[] jump) {
		int[] tab = new int[jump.length];
		tab[0] = 0;
		for (int s = 1; s < jump.length; s++) {
			tab[s] = Integer.MAX_VALUE;
			for (int js = 1; js <= jump[s]; js++) {
				int i = s - js;
				if (i >= 0) {
					if (tab[i] != Integer.MAX_VALUE) {
						tab[s] = Math.min(tab[i], tab[s]);
					}
				}
			}
			if (jump[s] != 0)
				tab[s]++;
		}
		return tab[tab.length - 1];
	}

	public static int mazeCost(int[][] arr) {
		int[][] tab = new int[arr.length][arr.length];
//		tab[arr.length - 1][arr.length - 1] = arr[arr.length - 1][arr.length - 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if(i == arr.length - 1 && j == arr[0].length - 1) {
					tab[i][j] = arr[i][j];
				}
				else if (i == arr.length - 1) {
//					System.out.println(i + "," + j);
					tab[i][j] = tab[i][j + 1] + arr[i][j];

				} else if (j == arr.length - 1) {
					tab[i][j] = tab[i + 1][j] + arr[i][j];

				} else {
					tab[i][j] = Math.min(tab[i + 1][j], tab[i][j + 1]) + arr[i][j];
				}
			}
		}
		return tab[0][0];
	}
}