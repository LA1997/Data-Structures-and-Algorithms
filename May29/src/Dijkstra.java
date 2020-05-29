import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {

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

	public static class DHelper implements Comparable<DHelper>{
		
		int v;
		String psf;
		int dsf;
		
		DHelper(int v,String psf,int dsf){
			this.v = v;
			this.psf = psf;
			this.dsf = dsf;
		}
		public int compareTo(DHelper other) {
			return this.dsf-other.dsf;
		}
	}
	
	public static void Dijkstra(ArrayList<ArrayList<edge>> graph,int src) {
		
		PriorityQueue<DHelper> pq = new PriorityQueue<>();
		pq.add(new DHelper(src,""+src,0));
		boolean visited[] = new boolean[graph.size()];
		
		while(pq.size()>0) {
			
			DHelper fn = pq.remove();
			
			if(visited[fn.v] == true)
				continue;
			else
				visited[fn.v] = true;
			
			System.out.println(src+" -> "+fn.v+" via "+fn.psf+" @ "+fn.dsf);
			
			for(int c=0; c<graph.get(fn.v).size(); c++) {
				
				edge ne = graph.get(fn.v).get(c);
				if(visited[ne.v] == false) {
					pq.add(new DHelper(ne.v, fn.psf+""+ne.v, fn.dsf+ne.w));
					
				}
			}
		}
		
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
		
		Dijkstra(graph, 0);
		
	}

}
