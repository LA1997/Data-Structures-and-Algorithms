import java.util.ArrayList;



public class BridgeAndAP {

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

	static int timer = 0;
	private static void bridgesAndAPs(ArrayList<ArrayList<edge>> graph,boolean[] visited,boolean[] aps,int[] disc,int[] low,int parent,int src) {
		
		visited[src] = true;
		disc[src] = low[src] = ++timer;
		int counter = 0;
		for(int i=0;i<graph.get(src).size();i++) {
			edge ne = graph.get(src).get(i);
			int nbr = ne.v;
			if(!visited[nbr]) {
				
				counter++;
				bridgesAndAPs(graph, visited, aps, disc, low, src, nbr);
				
				low[src] = Math.min(low[src], low[nbr]);
				
				if(disc[src] == 1) {	//root special case
					if(counter>=2) {
						aps[src] = true;
					}
				}
				else {
					if(low[nbr] >= disc[src]) {
						aps[src] = true;
					}
				}
				if(low[nbr] > disc[src]) {
					System.out.println("Bridge edge from "+src+" to "+nbr);
				}
			}
			else if(visited[nbr] && nbr!=parent) {
				low[src] = Math.min(low[src], disc[nbr]);
			}
		}
	}
	public static void bridgesAndAPs(ArrayList<ArrayList<edge>> graph) {
		boolean[] visited = new boolean[graph.size()];
		boolean[] aps = new boolean[graph.size()];
		int[] disc = new int[graph.size()];
		int[] low = new int[graph.size()];
		
		bridgesAndAPs(graph, visited, aps, disc, low, -1, 2);
		System.out.print("Articulation points: ");
		for(int i=0;i<aps.length;i++) {
			if(aps[i]) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<>());	
		}
		addEdge(graph, 0, 1, 1);
		addEdge(graph, 1, 2, 1);
		addEdge(graph, 2, 3, 1);
		addEdge(graph, 0, 3, 1);
		addEdge(graph, 3, 4, 1);
		addEdge(graph, 4, 5, 1);
		addEdge(graph, 5, 6, 1);
		addEdge(graph, 4, 6, 1);
		addEdge(graph, 0, 7, 1);
		addEdge(graph, 0, 8, 1);
		addEdge(graph, 7, 8, 1);
		
		bridgesAndAPs(graph);
		
	}

}
