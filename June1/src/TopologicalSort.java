import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

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

	public static void topologicalHelper(ArrayList<ArrayList<edge>> graph, int src, boolean[] visited, Stack<Integer> stck){
	
		visited[src] = true;
		for (int i = 0; i < graph.get(src).size(); i++) {
			edge ne = graph.get(src).get(i);

			if (visited[ne.v] == false) {
				topologicalHelper(graph, ne.v, visited, stck);
			}
		}
		stck.add(src);
		
	}
	public static void topological(ArrayList<ArrayList<edge>> graph) {
		
		boolean[] visited = new boolean[graph.size()];
		Stack<Integer> stck = new Stack<Integer>();
		for(int i=0;i<graph.size();i++) {
			if(visited[i] == false) {
				topologicalHelper(graph,i,visited,stck);
			}
		}
		while(stck.size()>0) {
			System.out.print(stck.pop()+" ");
		}
	}
	
	public static void main(String[] args) {

		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			graph.add(new ArrayList<>());	
		}
//		addEdge(graph,0,4,1);
//		addEdge(graph,0,1,1);
//		addEdge(graph,1,2,1);
//		addEdge(graph,2,3,1);
//		addEdge(graph,5,4,1);
//		addEdge(graph,5,6,1);
//		addEdge(graph,6,3,1);
		addEdge(graph, 0, 1, 1);
		addEdge(graph, 1, 2, 1);
		addEdge(graph, 2, 0, 1);
		
		display(graph);
		topological(graph);
		
		
	}

}
