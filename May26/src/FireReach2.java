import java.util.LinkedList;

public class FireReach2 {
	
	public static class FHelper{
		
		int i;
		int j;
		int t;
		FHelper(int i, int j, int t){
			this.i = i;
			this.j = j;
			this.t = t;
		}
	}
	private static boolean isvalid(int[][] city,int i,int j){
	
		int nr = city.length;
		int nc = city[0].length;
		
		if(i < 0 || i >= nr || j < 0 || j >= nc) 
			return false;
		else if(city[i][j] >= -1) {
			return false;
		}
		return true;
	}
	public static void getFireReached(int[][] city){
		
		LinkedList<FHelper> queue = new LinkedList<FHelper>();
		for(int i=0;i<city.length;i++) {
			for(int j=0;j<city[i].length;j++) {
				
				if(city[i][j] == 0) {
					queue.add(new FHelper(i, j, 0));
				}
			}
		}
		while(queue.size()>0) {
			
			FHelper fn = queue.getFirst();
			queue.removeFirst();
			
			if(city[fn.i][fn.j] > 0)
				continue;
			else
				city[fn.i][fn.j] = fn.t;
			
			System.out.println("Cell ["+fn.i+"]["+fn.j+"] burnt at t="+fn.t);
			
			if(isvalid(city, fn.i-1, fn.j)) {
				queue.add(new FHelper(fn.i-1,fn.j,fn.t+1));
			}
			if(isvalid(city, fn.i+1, fn.j)) {
				queue.add(new FHelper(fn.i+1,fn.j,fn.t+1));
			}
			if(isvalid(city, fn.i, fn.j-1)) {
				queue.add(new FHelper(fn.i,fn.j-1,fn.t+1));
			}
			if(isvalid(city, fn.i, fn.j+1)) {
				queue.add(new FHelper(fn.i,fn.j+1,fn.t+1));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] city = {{-2,-2,0,-2,-2,-2},
						{-2,-1,-1,-2,-1,-1},
						{-2,-2,-1,-2,-2,-2},
						{-2,-2,-2,-2,-1,-1},
						{-2,-1,-1,0,-2,-2}};
		
		getFireReached(city);
	}

}
