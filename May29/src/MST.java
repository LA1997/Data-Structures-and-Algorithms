import java.util.ArrayList;
import java.util.PriorityQueue;



public class MST {

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

	public static class PHelper implements Comparable<PHelper>{
		
		int v;
		int pv;
		int c;
		
		PHelper(int v,int pv,int c){
			this.v = v;
			this.pv = pv;
			this.c = c;
		}
		public int compareTo(PHelper other) {
			return this.c-other.c;
		}
	}
	
	public static ArrayList<ArrayList<edge>> getMstPrim(ArrayList<ArrayList<edge>> graph){
		
		PriorityQueue<PHelper> pq = new PriorityQueue<PHelper>();
		pq.add(new PHelper(0,-1,0));
		ArrayList<ArrayList<edge>> mst = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			mst.add(new ArrayList<>());	
		}
		boolean visited[] = new boolean[graph.size()];
		
		while(pq.size()>0) {
			PHelper fn = pq.remove();
			
			if(visited[fn.v] == true)
				continue;
			else
				visited[fn.v] = true;
			
			if(fn.pv != -1)
				addEdge(mst, fn.v, fn.pv, fn.c);
			
			for(int c=0; c<graph.get(fn.v).size(); c++) {
				
				edge ne = graph.get(fn.v).get(c);
				if(visited[ne.v] == false) {
					pq.add(new PHelper(ne.v, fn.v, ne.w));
					
				}
			}
		}
		return mst;
	
	}
	
	public static class Kedge implements Comparable<Kedge>{
		
		int v1,v2,w;
		
		Kedge(int v1,int v2,int w){
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
		public int compareTo(Kedge other) {
			return this.w-other.w;
		}
	}
	
	public static int find(int[] pa,int v) {
		
		if(pa[v] == v) {
			return v;
		}
		else {
			int sl = find(pa,pa[v]);
			return sl;
		}
	}
	
	public static void merge(int[] pa,int[] ra,int v1sl,int v2sl) {
		
		if(ra[v1sl] < ra[v2sl]) {
			pa[v1sl] = v2sl;
		} 
		else if(ra[v1sl] > ra[v2sl]) {
			pa[v2sl] = v1sl;
		} 
		else {
			pa[v2sl] = v1sl;
			ra[v1sl]++;
		}
	}
	public static ArrayList<ArrayList<edge>> getMstKruskals(ArrayList<ArrayList<edge>> graph){
		
		PriorityQueue<Kedge> pq = new PriorityQueue<>();
		int[] pa = new int[graph.size()];
		int[] ra = new int[graph.size()];
		ArrayList<ArrayList<edge>> mst = new ArrayList<ArrayList<edge>>();
		
		for(int i=0;i<graph.size();i++) {
			mst.add(new ArrayList<>());	
			pa[i] = i;
			ra[i] = 1;
		}
		
		for(int v=0; v<graph.size(); v++) {
			for(int n=0; n<graph.get(v).size(); n++) {
				edge ne = graph.get(v).get(n);
				if(v<ne.v) {
					pq.add(new Kedge(v, ne.v, ne.w));
				}
			}
		}
		int counter=0;
		while(pq.size()>0 && counter<graph.size()-1) {
			
			Kedge ne = pq.remove();
			
			int v1sl = find(pa,ne.v1);
			int v2sl = find(pa,ne.v2);
			if(v1sl != v2sl) {
				addEdge(mst,ne.v1,ne.v2,ne.w);
				merge(pa, ra, v1sl, v2sl);
				counter++;
			}
		}
		return mst;
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
		
		//ArrayList<ArrayList<edge>> mst = getMstPrim(graph);
		ArrayList<ArrayList<edge>> mst = getMstKruskals(graph);
		display(mst);
	}

}
