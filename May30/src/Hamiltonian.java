import java.util.ArrayList;

public class Hamiltonian {

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

	public static void hamiltonianpncHelper(ArrayList<ArrayList<edge>> graph, int src,ArrayList<Integer> psf,boolean[] visited) {
		
		if(psf.size() == graph.size()-1) {
			for(int i=0; i<psf.size(); i++) {
				System.out.print(psf.get(i)+" ");
			}
			System.out.print(src+" ");
			int first = psf.get(0);
			int last = src;
			boolean cycle = false;
			
			for(int i=0; i<graph.get(first).size(); i++) {
				edge ne = graph.get(first).get(i);
				if(ne.v == last) {
					cycle = true;
					break;
				}
			}
			if(cycle == false)
				System.out.println(".");
			else
				System.out.println("*");
			return;
		}
		
		visited[src] = true;

		for (int i = 0; i < graph.get(src).size(); i++) {
			edge ne = graph.get(src).get(i);

			if (visited[ne.v] == false) {
				psf.add(src);
				hamiltonianpncHelper(graph, ne.v, psf, visited);
				psf.remove(psf.size()-1);
			}
		}
		visited[src] = false;
	}
	
	public static void hamiltonianpnc(ArrayList<ArrayList<edge>> graph, int src) {
		
		boolean[] visited = new boolean[graph.size()];
		ArrayList<Integer> psf = new ArrayList<Integer>();
		hamiltonianpncHelper(graph,src,psf,visited);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			graph.add(new ArrayList<>());	
		}
		addEdge(graph, 0, 1, 10);
		addEdge(graph, 1, 2, 10);
		addEdge(graph, 2, 3, 10);
		addEdge(graph, 0, 3, 40);
		addEdge(graph, 3, 4, 2);
		addEdge(graph, 4, 5, 3);
		addEdge(graph, 5, 6, 3);
		addEdge(graph, 4, 6, 8);
		addEdge(graph, 2, 5, 10);
		

		hamiltonianpnc(graph, 2);
	}

}
