import java.util.ArrayList;

public class FloydWarshall {

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

	public static class FHelper{
		
		String path;
		int w;
		FHelper(String path,int w){
			this.path = path;
			this.w = w;
		}
	}
	public static void floydShortestPath(ArrayList<ArrayList<edge>> graph){
		
		int[][] sd = new int[graph.size()][graph.size()];
		String[][] path = new String[graph.size()][graph.size()];
		
		for(int i=0; i<sd.length; i++) {
			for(int j=0; j<sd[i].length; j++) {
				if(i == j) {
					sd[i][j] = 0;
					path[i][j] = String.valueOf(i);
				}
				else {
					sd[i][j] = Integer.MAX_VALUE;
					path[i][j] = "NA";
				}
			}
		}
		
		for(int i=0; i<graph.size(); i++) {
			for(int n=0; n<graph.get(i).size(); n++) {
				edge ne = graph.get(i).get(n);
				sd[i][ne.v] = ne.w;
				path[i][ne.v] = ""+i+"->"+ne.v;
			}
		}
		
		for(int i=0; i<graph.size(); i++) {
			for(int s=0; s<graph.size(); s++) {
				for(int d=0; d<graph.size(); d++) {
					
					if(i==s || i==d || s==d) {
						continue;
					}
					else if(sd[s][i] == Integer.MAX_VALUE || sd[i][d] == Integer.MAX_VALUE) {
						continue;
					}
					else if(sd[s][i] + sd[i][d] < sd[s][d]) {
						sd[s][d] = sd[s][i] + sd[i][d];
						String psi = path[s][i];
						String pid = path[i][d];
						path[s][d] = psi.substring(0,psi.length()-1) + psi.charAt(psi.length()-1) + pid.substring(1);
					}
				}
			}
		}
		
		for(int i=0; i<sd.length; i++) {
			for(int j=0; j<sd[i].length; j++) {
				if(sd[i][j] == Integer.MAX_VALUE)
					System.out.print("NA   ");
				else
					System.out.print(sd[i][j]+"    ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0; i<path.length; i++) {
			for(int j=0; j<path[i].length; j++) {
				System.out.print(path[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		ArrayList<ArrayList<edge>> graph = new ArrayList<ArrayList<edge>>();
		for(int i=0; i<4; i++) {
			graph.add(new ArrayList<edge>());
		}
		addEdge(graph,0,1,2);
		addEdge(graph,0,2,4);
		addEdge(graph,0,3,8);
		addEdge(graph,1,2,1);
		addEdge(graph,1,3,5);
		addEdge(graph,2,3,1);
		
		floydShortestPath(graph);
				
	}

}
