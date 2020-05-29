import java.util.ArrayList;
import java.util.LinkedList;



public class Astronauts {

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
	
	private static ArrayList<Integer> getConnectedComponent(ArrayList<ArrayList<edge>> graph,boolean[] visited,int src) {
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> comp = new ArrayList<Integer>();
		queue.add(src);
		
		while(queue.size()>0) {
			int fn = queue.getFirst();
			queue.removeFirst();
			
			if(visited[fn] == true)
				continue;
			else
				visited[fn] = true;
			
			comp.add(fn);
			
			for(int c = 0; c<graph.get(fn).size();c++) {
				edge ne = graph.get(fn).get(c);
				if(visited[ne.v] == false) {
					queue.add(ne.v);
				}
			}
		}
		return comp;
	}
	public static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<ArrayList<edge>> graph){
		
		ArrayList<ArrayList<Integer>> cc = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0;i<graph.size();i++)
		{
			if(visited[i] == false) {
				ArrayList<Integer> comp = getConnectedComponent(graph, visited, i);
				cc.add(comp);
			}
		}
		return cc;
		
	}

	public static int astro(int n,int[] a1,int[] a2) {
		
		int num = 0;
		ArrayList<ArrayList<edge>> agraph = new ArrayList<>();
		for(int i=0; i<n; i++) {
			agraph.add(new ArrayList<>());	
		}
		for(int i=0; i<a1.length; i++) {
			addEdge(agraph, a1[i], a2[i], 0);
		}
		
		ArrayList<ArrayList<Integer>> cc = getConnectedComponents(agraph);
		System.out.println(cc);
		
		ArrayList<Integer> astSame = new ArrayList<Integer>();
		for(int i=0;i<cc.size();i++) {
			astSame.add(cc.get(i).size());
		}
		System.out.println(astSame);
		for(int i=0;i<astSame.size();i++) {
			for(int j=i+1;j<astSame.size();j++)
				num += astSame.get(i) * astSame.get(j);
		}
		
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 12;
		int[] a1 = {1,6,8,2,9,10,0};
		int[] a2 = {2,9,3,5,5,3,11};
		System.out.println(astro(n, a1, a2));
		
	}

}
