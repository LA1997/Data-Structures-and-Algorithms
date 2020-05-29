import java.util.ArrayList;
import java.util.LinkedList;


public class Islands {

	public static class Pos{
		int i,j;
		Pos(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	private static boolean isValid(int[][] map,int i,int j) {
		if(i<0 || i>=map.length || j<0 || j>=map[0].length || map[i][j] == 0) {
			return false;
		}
		return true;
		
	}
	private static String getIsland(int[][] map,boolean[][] visited,int i,int j) {
		
		LinkedList<Pos> queue = new LinkedList<Pos>();
		String island = "";
		queue.add(new Pos(i,j));
		
		while(queue.size()>0) {
			
			Pos fn = queue.getFirst();
			queue.removeFirst();
			
			if(visited[fn.i][fn.j] == true)
				continue;
			else
				visited[fn.i][fn.j] = true;
			
			island += " ["+fn.i+"]["+fn.j+"]";
					
			if(isValid(map,fn.i-1,fn.j)) {
				queue.add(new Pos(fn.i-1,fn.j));
			}
			if(isValid(map,fn.i+1,fn.j)) {
				queue.add(new Pos(fn.i+1,fn.j));
			}
			if(isValid(map,fn.i,fn.j-1)) {
				queue.add(new Pos(fn.i,fn.j-1));
			}
			if(isValid(map,fn.i,fn.j+1)) {
				queue.add(new Pos(fn.i,fn.j+1));
			}
		}
		return island;
	}
		
	public static ArrayList<String> getIslands(int[][] map){
		
		ArrayList<String> islands = new ArrayList<String>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++) {
				
				if(visited[i][j] == false && map[i][j] != 0) {
					String island = getIsland(map, visited, i, j);
					islands.add(island);
				}
			}
		}
		return islands;
		
	}

	public static void main(String[] args) {

		int[][] map = {
						{1,1,0,1,1},
						{1,0,0,0,0},
						{0,1,1,1,1},
						{1,0,1,0,1},
						{1,0,0,0,1}
					};
		ArrayList<String> islands = getIslands(map);
		System.out.println(islands);
		System.out.println(islands.size());
	}
}


