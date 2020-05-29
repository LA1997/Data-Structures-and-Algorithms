import java.util.ArrayList;
import java.util.LinkedList;



public class IsBipartite {

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

	public static class BHelper{
		
		int vertex;
		int level;
		BHelper(int vertex,int level){
			this.vertex = vertex;
			this.level = level;
		}
	}
	
	public static boolean isBipartiteComponent(ArrayList<ArrayList<edge>> graph,int[] visited,int src) {
		
		LinkedList<BHelper> queue = new LinkedList<BHelper>();
		queue.add(new BHelper(src, 0));
		
		while(queue.size()>0) {
			
			BHelper fn = queue.getFirst();
			queue.removeFirst();
			
			int sch = fn.level % 2;
			if(visited[fn.vertex] > -1) {
				if(sch == visited[fn.vertex])
					continue;
				else
					return false;
			}
			else
				visited[fn.vertex] = sch;
			
			for(int i=0;i<graph.get(fn.vertex).size();i++) {
				edge ne = graph.get(fn.vertex).get(i);
				if(visited[ne.v] == -1) {
					queue.add(new BHelper(ne.v, fn.level+1));
				}
			}
		}
		return true;
	}
	
	public static boolean isBipartite(ArrayList<ArrayList<edge>> graph) {
		
		int[] visited = new int[graph.size()];
		for(int i=0;i<visited.length;i++) {
			visited[i] = -1;
		}
		for(int i=0;i<graph.size();i++) {
			if(visited[i] == -1) {
				boolean isB = isBipartiteComponent(graph, visited, i);
				if(!isB)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		int n = 5;
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());	
		}
//		addEdge(graph, 0, 3, 1);
//		addEdge(graph, 0, 4, 1);
//		addEdge(graph, 0, 5, 1);
//		addEdge(graph, 1, 3, 1);
//		addEdge(graph, 1, 4, 1);
//		addEdge(graph, 1, 5, 1);
//		addEdge(graph, 2, 3, 1);
//		addEdge(graph, 2, 4, 1);
//		addEdge(graph, 2, 5, 1);
	
//		addEdge(graph, 0, 1, 1);
//		addEdge(graph, 0, 3, 1);
//		addEdge(graph, 1, 2, 1);
//		addEdge(graph, 2, 3, 1);
//		addEdge(graph, 2, 5, 1);
//		addEdge(graph, 3, 4, 1);
//		addEdge(graph, 4, 5, 1);
		
		addEdge(graph, 0, 1, 1);
		addEdge(graph, 0, 3, 1);
		addEdge(graph, 1, 2, 1);
		addEdge(graph, 2, 3, 1);
		addEdge(graph, 2, 4, 1);
		addEdge(graph, 3, 4, 1);

		
		System.out.println(isBipartite(graph));
	}

}
