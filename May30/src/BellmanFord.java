import java.util.ArrayList;

public class BellmanFord {

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

	public static class Kedge{
		
		int v1,v2,w;
		
		Kedge(int v1,int v2,int w){
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
	
	
	public static void bellmanford(ArrayList<ArrayList<edge>> graph, int src) {
		
		int[] res = new int[graph.size()];
		for(int i=0;i<graph.size();i++) {
				res[i] = Integer.MAX_VALUE;
		}
		res[src] = 0;
		ArrayList<Kedge> alledges = new ArrayList<Kedge>();
		
		for(int i=0;i<graph.size();i++) {
			for(int n=0;n<graph.get(i).size();n++) {
				edge ne = graph.get(i).get(n);
				Kedge ke = new Kedge(i,ne.v,ne.w);
				alledges.add(ke);
			}
		}
		
		for(int i=0;i<graph.size()-1;i++) {
			for(int j=0;j<alledges.size();j++) {
				Kedge ke = alledges.get(j);
				if(ke.v1 != Integer.MAX_VALUE) {
					if(res[ke.v1] + ke.w < res[ke.v2]) {
						res[ke.v2] = res[ke.v1] + ke.w;
					}
				}
			}
		}
		
		for(int j=0;j<alledges.size();j++) {
			Kedge ke = alledges.get(j);
			if(ke.v1 != Integer.MAX_VALUE) {
				if(res[ke.v1] + ke.w < res[ke.v2]) {
					System.out.println("Negative Cycle");
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			graph.add(new ArrayList<>());	
		}
		addEdge(graph,0,1,2);
		addEdge(graph,1,2,4);
		addEdge(graph,2,3,1);
		addEdge(graph,0,3,9);
		addEdge(graph,2,0,-5);
		bellmanford(graph, 0);
		
	}

}
