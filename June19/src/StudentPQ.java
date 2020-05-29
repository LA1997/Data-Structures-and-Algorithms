import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyPriorityQueue1<T> {

	ArrayList<T> list = new ArrayList<>();
	Comparator<T> comptor = null;
	
	void swap(int i,int j) {
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	boolean isHigherPriority(int i,int j) {
		if(comptor != null) {
			T ith = list.get(i);
			T jth = list.get(j);
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
	
	public MyPriorityQueue1() {
		this.comptor = null;
	}
	
	public MyPriorityQueue1(Comparator<T> comptor) {
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
}

class StudentMarksComparator implements Comparator<Student> {
	
	public int compare(Student ith,Student jth) {
		return ith.marks - jth.marks;
	}
}
class StudentExtraComparator implements Comparator<Student> {
	
	public int compare(Student ith,Student jth) {
		return ith.extra - jth.extra;
	}
}
class StudentMarksExtraComparator implements Comparator<Student> {
	
	public int compare(Student ith,Student jth) {
		if(ith.marks == jth.marks) {
			return ith.extra - jth.extra;
		}
		else {
			return ith.marks - jth.marks;
		}
	}
}
class StudentExtraMarksComparator implements Comparator<Student> {
	
	public int compare(Student ith,Student jth) {
		if(ith.extra == jth.extra) {
			return ith.marks - jth.marks;
		}
		else {
			return ith.extra - jth.extra;
		}
	}
}
class Student implements Comparable<Student>{
	
	String name;
	int marks; 
	int extra;
	
	public Student(String name,int marks,int extra) {
		this.name = name;
		this.marks = marks;
		this.extra = extra;
	}
	
	public void display() {
		System.out.println("["+name+","+marks+","+extra+"]");
	}
	
	public int compareTo(Student other) {
		return this.name.compareTo(other.name);
	}
}
public class StudentPQ {
	
	public static void main(String[] args) {

		MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>();
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(Collections.reverseOrder());
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(new StudentMarksComparator());
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(Collections.reverseOrder(new StudentMarksComparator()));
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(new StudentExtraComparator());
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(Collections.reverseOrder(new StudentExtraComparator()));
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(new StudentMarksExtraComparator());
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(Collections.reverseOrder(new StudentMarksExtraComparator()));
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(new StudentExtraMarksComparator());
		//MyPriorityQueue1<Student> pq = new MyPriorityQueue1<Student>(Collections.reverseOrder(new StudentExtraMarksComparator()));
								
		pq.add(new Student("Z",10,10));
		pq.add(new Student("C",5,10));
		pq.add(new Student("Y",9,7));
		pq.add(new Student("R",5,5));
		pq.add(new Student("P",3,2));
		
		while(pq.size()>0) {
			pq.peek().display();
			pq.remove();	
		}	
	}
}
