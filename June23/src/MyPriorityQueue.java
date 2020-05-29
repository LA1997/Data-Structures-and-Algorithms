import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyPriorityQueue<T> {

	ArrayList<T> list = new ArrayList<>();
	Comparator<T> comptor;
	
	void swap(int i,int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	boolean isHigherPriority(int i,int j) {
		if(comptor != null) {
			T ith = list.get(i);
			T jth = list.get(i);
			return comptor.compare(ith,jth) < 0;	
		}
		else {
			Comparable<T> ith = (Comparable<T>) list.get(i);
			T jth = list.get(j);
			return ith.compareTo(jth) < 0;
		}
	}
	void upheapify(int i) {
		if(i == 0) {
			return;
		}
		int pi = (i-1)/2;
		if(isHigherPriority(i, pi)) {
			swap(i,pi);
			upheapify(pi);;
		}
	}
	void downheapify(int i) {
		int lci = 2*i+1;
		int rci = 2*i+2;
		int hpi = i;
		if(lci < list.size() && isHigherPriority(lci, i)) {
			hpi = lci;
		}
		if(rci < list.size() && isHigherPriority(rci, hpi)) {
			hpi = rci;
		}
		if(hpi != i) {
			swap(hpi,i);
			downheapify(hpi);
		}
	}
	
	public MyPriorityQueue() {
		this.comptor = null;
	}
	
	public MyPriorityQueue(T[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		for(int i=arr.length-1; i>=0; i++) {
			downheapify(i);
		}
	}
	
	public MyPriorityQueue(Comparator<T> comptor) {
		this.comptor = comptor;
	}
	
	
	public void add(T val) {
		list.add(val);
		upheapify(list.size()-1);
	}
	
	public T remove() {
		T val = list.get(0);
		swap(0,list.size()-1);
		list.remove(list.size()-1);
		downheapify(0);
		return val;
	}
	
	public T peek() {
		return list.get(0);
	}
	
	public int size() {
		return list.size();
	}
	
	public ArrayList<T> getList() {
		return list;
	}
	
	public static void main(String[] args) {
		
		Integer[] arr = {10,2,5,9,3,1,8};
		MyPriorityQueue<Integer> pq = new MyPriorityQueue<Integer>(arr);
		
		
	}
	
}
