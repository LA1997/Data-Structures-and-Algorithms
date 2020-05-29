public class maze {

	public static int mazeCost(int[][] arr) {
		int[][] tab = new int[arr.length][arr.length];
//		tab[arr.length - 1][arr.length - 1] = arr[arr.length - 1][arr.length - 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					tab[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
//					System.out.println(i + "," + j);
					tab[i][j] = tab[i][j + 1] + arr[i][j];

				} else if (j == arr.length - 1) {
					tab[i][j] = tab[i + 1][j] + arr[i][j];

				} else {
					tab[i][j] = Math.min(tab[i + 1][j], tab[i][j + 1]) + arr[i][j];
				}
			}
		}
		printMinCostPath(tab, 0, 0, "");
		return tab[0][0];
	}

	public static void printMinCostPath(int[][] arr, int r, int c, String psf) {
//		if(tab)
		if (r == arr.length - 1 && c == arr[0].length - 1) {
			System.out.println(psf);
			return;
		} else if (r == arr.length - 1) {
			printMinCostPath(arr, r, c + 1, psf + "h");

		} else if (c == arr[0].length - 1) {
			printMinCostPath(arr, r + 1, c, psf + "v");

		} else {
			int m = Math.min(arr[r + 1][c], arr[r][c + 1]);
//				
			if (m == arr[r + 1][c]) {
				printMinCostPath(arr, r + 1, c, psf + "v");
			}
			if (m == arr[r][c + 1]) {
				printMinCostPath(arr, r, c + 1, psf + "h");
			}
		}
	}

	public static int goldMine(int[][] gold) {
		int[][] tab = new int[gold.length][gold[0].length];
		for (int x = 0; x < gold.length; x++) {
			tab[x][gold[0].length-1] = gold[x][gold[0].length-1];
		}
		for (int i = 0;i<gold.length;i++) {
			for (int j = gold[0].length - 2; j >= 0; j--) {
//				if(j==gold[0].length-1) {
//					tab[i][j] = gold[i][j];
//				}
				if(i==0){
					tab[i][j] = Math.max(gold[i][j+1], gold[i+1][j+1])+ gold[i][j];
				}
				else if(i== gold.length-1) {
					tab[i][j] = Math.max(gold[i][j+1], gold[i-1][j+1]) + gold[i][j];
				}
				else {
					int max = Math.max(gold[i][j+1], gold[i-1][j+1]);
					tab[i][j] = Math.max(max, gold[i+1][j+1]) + gold[i][j];
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int x = 0; x < gold[0].length; x++) {
			ans = Math.max(ans, tab[0][x]);
		}
		return ans;
//		return gold[i][gold.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = { { 2, 6, 5, 1, 3, 4 }, { 0, 4, 9, 2, 9, 0 }, { 4, 8, 1, 0, 6, 5 }, { 3, 3, 3, 1, 5, 4 },
				{ 1, 2, 7, 0, 6, 9 }, { 5, 7, 1, 3, 8, 2 } };
		int[][] gold = { { 2, 5, 0, 1, 3 }, { 3, 5, 4, 2, 9 }, { 4, 2, 0, 1, 7 }, { 0, 1, 3, 5, 4 }, { 3, 4, 8, 2, 4 },
				{ 2, 0, 6, 3, 7 } };
//		System.out.println(mazeCost(cost));
		System.out.println(goldMine(gold));

	}

}