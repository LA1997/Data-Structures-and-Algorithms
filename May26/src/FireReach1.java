
public class FireReach1 {

	private static void getFireReached(int[][] city,int fr,int fc,int t){
	
		if(t == 0) {
			return;
		}
		int nr = city.length;
		int nc = city[0].length;
		
		if(fr-1 >= 0 && city[fr-1][fc] == 0) {
			city[fr-1][fc] = 2;
			getFireReached(city, fr-1,fc,t-1);
		}
		if(fc-1 >= 0 && city[fr][fc-1] == 0) {
			city[fr][fc-1] = 2;
			getFireReached(city, fr,fc-1,t-1);
		}
		if(fr+1 < nr && city[fr+1][fc] == 0) {
			city[fr+1][fc] = 2;
			getFireReached(city, fr+1,fc,t-1);
		}
		if(fc+1 < nc && city[fr][fc+1] == 0) {
			city[fr][fc+1] = 2;
			getFireReached(city, fr,fc+1,t-1);
		}
	}
	public static void getFireReached(int[][] city,int t){
		
		for(int r=0;r<city.length;r++) {
			for(int c=0;c<city[r].length;c++) {
				if(city[r][c] == 2) {
					getFireReached(city,r,c,t);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] city = {{0,1,1,1,1,0},
							{0,1,0,0,1,0},
							{0,0,0,1,0,2},
							{0,1,0,1,0,1},
							{2,0,1,1,0,0}};
		
		int t=3;
		getFireReached(city, t);
		for(int r=0;r<city.length;r++) {
			for(int c=0;c<city[r].length;c++) {
				System.out.print(city[r][c]+" ");
			}
			System.out.println();
		}
	}

}
