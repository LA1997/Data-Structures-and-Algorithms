import java.util.ArrayList;
import java.util.LinkedList;


public class MinFarthest {

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
	public static class CHelper{
		
		int v;
		int dsf;
		CHelper(int v,int dsf){
			this.v = v;
			this.dsf = dsf;
		}
	}
	
	public static int Farthest(ArrayList<ArrayList<edge>> graph,int src) {
		
		LinkedList<CHelper> queue = new LinkedList<CHelper>();
		boolean[] visited = new boolean[graph.size()];
		
		queue.add(new CHelper(src,0));
		CHelper fn = new CHelper(0,0);
		while(queue.size()>0) {
			
			fn = queue.getFirst();
			queue.removeFirst();
			
			if(visited[fn.v] == true)
				continue;
			else
				visited[fn.v] = true;
			
			for(int c=0; c<graph.get(fn.v).size(); c++) {
				edge ne = graph.get(fn.v).get(c);
				if(visited[ne.v] == false) {
					queue.add(new CHelper(ne.v, fn.dsf + ne.w));	
				}
			}
		}
		return fn.dsf; 
	}
	public static ArrayList<Integer> minFarthest(ArrayList<ArrayList<edge>> graph) {
		
		int far[] = new int[graph.size()];
		for(int i=0;i<graph.size();i++) {
			far[i] = Farthest(graph,i);
		}
		ArrayList<Integer> pos = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<far.length;i++) {
			System.out.print(far[i]+" ");
			if(far[i] < min) {
				min = far[i];
				pos.add(i);
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for(int i=0; i<23; i++) {
			graph.add(new ArrayList<>());	
		}
		addEdge(graph,0,1,1);
		addEdge(graph,1,22,1);
		addEdge(graph,1,2,1);
		addEdge(graph,2,3,1);
		addEdge(graph,2,7,1);
		addEdge(graph,2,5,1);
		addEdge(graph,7,8,1);
		addEdge(graph,7,9,1);
		addEdge(graph,5,4,1);
		addEdge(graph,5,6,1);
		addEdge(graph,4,16,1);
		addEdge(graph,16,17,1);
		addEdge(graph,15,16,1);
		addEdge(graph,16,18,1);
		addEdge(graph,18,19,1);
		addEdge(graph,19,20,1);
		addEdge(graph,19,21,1);
		addEdge(graph,6,10,1);
		addEdge(graph,10,11,1);
		addEdge(graph,10,12,1);
		addEdge(graph,12,13,1);
		addEdge(graph,12,14,1);
		
		//display(graph);
			
		ArrayList<Integer> pos = minFarthest(graph);
		System.out.println(pos);
		
	}

}
