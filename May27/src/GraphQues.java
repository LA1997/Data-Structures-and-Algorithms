import java.util.ArrayList;
import java.util.LinkedList;


public class GraphQues {
	private static boolean add;
	public static class edge {
		int v;
		int w;
		edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void addEdge(ArrayList<ArrayList<edge>> graph, int v1, int v2, int w) {
		graph.get(v1).add(new edge(v2, w));
		graph.get(v2).add(new edge(v1, w));
	}
	
	public static void display(ArrayList<ArrayList<edge>> graph) {
	
	for (int i = 0; i < graph.size(); i++) {
		System.out.println(i + " ->");
		for (int j = 0; j < graph.get(i).size(); j++) {
			System.out.print(" | " + graph.get(i).get(j).v + " @ " + graph.get(i).get(j).w);
		}
		System.out.println();
		}
	}
	
	public static boolean hasPath(ArrayList<ArrayList<edge>> graph, int src, int dest, boolean[] visit) {
		if (src == dest) {
			return true;
		}
		visit[src] = true;
		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				if (hasPath(graph, vsrc.get(i).v, dest, visit)) {
					return true;
				}
				// visit[vsrc.get(i).v] = false;
			}
		}
		return false;
	}
		
	//inclusive approach
	public static void printAllPath(ArrayList<ArrayList<edge>> graph, int src, int dest, String asf, boolean[] visit) {
		if (src == dest) {
			System.out.println(asf);
			return;
		}
	
		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				visit[vsrc.get(i).v] = true;
				asf += vsrc.get(i).v + " ->";
				printAllPath(graph, vsrc.get(i).v, dest, asf, visit);
				visit[vsrc.get(i).v] = false;
			}
		}
	}

	public static class THelper{
		
		int vertex;
		String psf;
		int dsf;
		THelper(int vertex,String psf,int dsf){
			this.vertex = vertex;
			this.psf = psf;
			this.dsf = dsf;
		}
	}
	
	public static boolean bfs(ArrayList<ArrayList<edge>> graph,int src,int dest) {
		
		LinkedList<THelper> queue = new LinkedList<THelper>();
		boolean visited[] = new boolean[graph.size()];
		
		queue.add(new THelper(src,""+src,0));
		while(queue.size()>0) {
			
			THelper fn = queue.getFirst();
			queue.removeFirst();
			
			System.out.println(fn.vertex+" via "+fn.psf+" @ "+fn.dsf);
			
			if(visited[fn.vertex] == true)
				continue;
			else
				visited[fn.vertex] = true;
			
			if(fn.vertex == dest) {
				return true;
			}
			
			for(int c=0;c<graph.get(fn.vertex).size();c++){
				
				edge ne = graph.get(fn.vertex).get(c);
				if(visited[ne.v] == false) {
					queue.add(new THelper(ne.v,fn.psf+""+ne.v,fn.dsf+ne.w));
				}
			}
			
		
		}
		return false;
	}
	
	public static class CHelper{
		
		int vertex;
		String ans;
		CHelper(int vertex,String ans){
			this.vertex = vertex;
			this.ans = ans;
		}
	}
	private static String getConnectedComponent(ArrayList<ArrayList<edge>> graph,boolean[] visited,int src) {
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		String comp = "";
		queue.add(src);
		
		while(queue.size()>0) {
			int fn = queue.getFirst();
			queue.removeFirst();
			
			if(visited[fn] == true)
				continue;
			else
				visited[fn] = true;
			
			comp += " "+fn;
			
			for(int c = 0; c<graph.get(fn).size();c++) {
				edge ne = graph.get(fn).get(c);
				if(visited[ne.v] == false) {
					queue.add(ne.v);
				}
			}
		}
		return comp;
	}
	public static ArrayList<String> getConnectedComponents(ArrayList<ArrayList<edge>> graph){
		
		ArrayList<String> cc = new ArrayList<String>();
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0;i<graph.size();i++)
		{
			if(visited[i] == false) {
				String comp = getConnectedComponent(graph, visited, i);
				cc.add(comp);
			}
		}
		return cc;
		
	}

	private static boolean isCycle(ArrayList<ArrayList<edge>> graph,boolean[] visited,int src) {
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		
		while(queue.size()>0) {
			int fn = queue.getFirst();
			queue.removeFirst();
			
			if(visited[fn] == true) {
				return true;
			}
			else
				visited[fn] = true;
			
			for(int c = 0; c<graph.get(fn).size();c++) {
				edge ne = graph.get(fn).get(c);
				if(visited[ne.v] == false) {
					queue.add(ne.v);
				}
			}
		}
		return false;
	}
	public static boolean isCyclic(ArrayList<ArrayList<edge>> graph){
		
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0;i<graph.size();i++)
		{
			if(visited[i] == false) {
				boolean res = isCycle(graph, visited, i);
				if(res)
					return true;
			}
		}
		return false;
		
	}

	
	
	private static class Helper{
		static int mn = Integer.MAX_VALUE;
		//	static int mx = Integer.MIN_VALUE;
		static int ceil = Integer.MAX_VALUE;
		static int floor = Integer.MIN_VALUE;
		static String masf = "";
	}
	public static void smallestPath(ArrayList<ArrayList<edge>> graph, int src, int dest,int cost,String asf, Helper H ,boolean[] visit , int cf) {
		if (src == dest) {
			if(cost <H.mn) {
				H.mn = cost;
				H.masf = asf;
			}
			H.ceil = cost < H.ceil && cost > cf ? cost : H.ceil;
			H.floor = cost > H.floor && cost < cf ? cost : H.floor;
			
			return;
		}
	
		ArrayList<edge> vsrc = graph.get(src);
		for (int i = 0; i < vsrc.size(); i++) {
			if (visit[vsrc.get(i).v] == false) {
				visit[vsrc.get(i).v] = true;
				cost = cost+vsrc.get(i).w;
				asf += vsrc.get(i).v + " ->";
				smallestPath(graph, vsrc.get(i).v, dest,cost,asf, H, visit,cf);
				visit[vsrc.get(i).v] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
//		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
//		for (int i = 0; i < 7; i++) {
//			graph.add(new ArrayList<>());	
//		}
//		addEdge(graph, 0, 1, 10);
//		addEdge(graph, 1, 2, 10);
//		addEdge(graph, 2, 3, 10);
//		addEdge(graph, 0, 3, 40);
//		addEdge(graph, 3, 4, 2);
//		addEdge(graph, 4, 5, 3);
//		addEdge(graph, 4, 6, 8);
//		addEdge(graph, 5, 6, 3);
//		//display(graph);
		//boolean[] visit = new boolean[7];
		////System.out.println(hasPath(graph, 0, 6, visit));
		//visit[0] = true;
		//String asf = "0 ->";
		////	printAllPath(graph, 0, 6, asf, visit);
		//Helper hp = new Helper();
		//smallestPath(graph, 0, 6, 0, asf,hp, visit,40);
		//System.out.println(hp.masf + " ||" + hp.mn);
		//System.out.println(hp.ceil + " " + hp.floor);
		
		//System.out.println(bfs(graph, 0, 6));
		
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<>());	
		}
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 5, 6, 3);
		
		addEdge(graph, 7, 8, 3);
//		ArrayList<String> cc = getConnectedComponents(graph);
//		System.out.println(cc);
//	
		System.out.println(isCyclic(graph));
	}
}

