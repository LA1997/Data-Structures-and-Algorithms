public class targetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 3, 1, 6 };
		int tar = 9;
		System.out.println(tarSum(arr, tar));
	}

	public static boolean tarSum(int[] arr, int tar) {
		boolean[][] tab = new boolean[arr.length + 1][tar + 1];
		for (int x = 0; x < tab.length; x++) {
			tab[x][0] = true;
		}
		for (int i = 1; i < tab.length; i++) {
			for (int j = 1; j < tab[0].length; j++) {
				if (tab[i - 1][j]) {
					tab[i][j] = true;
				} else if (j - arr[i - 1] >= 0) {
					if (tab[i - 1][j - arr[i - 1]]) {
						tab[i][j] = true;
					}
				}
			}
		}
//		display(tab);
		printPath(tab, tab.length - 1, tab[0].length - 1, arr, "");
		return tab[tab.length - 1][tab[0].length - 1];
	}

	public static void printPath(boolean[][] tab, int i, int j, int[] arr, String psf) {
		if (j == 0) {
			System.out.println(psf);
			return;
		} else if (i == 0) {
			return;
		} else {
			if (tab[i - 1][j]) {
				printPath(tab, i - 1, j, arr, psf);
			}
			if (j - arr[i - 1] >= 0 && tab[i - 1][j - arr[i - 1]] == true) {
				printPath(tab, i - 1, j - arr[i - 1], arr, psf + "" + arr[i - 1]);
			}

		}

	}

	public static void display(boolean[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				System.out.print(tab[i][j] + "	");
			}
			System.out.println();
		}
	}
}
