import java.util.Stack;

public class di_string {

	public static void getnumdi(String str) {
		
		int num = 1;
		Stack<Integer> stck = new Stack<Integer>(); 
		for(int i=0;i<str.length();i++) {
			
			stck.push(num++);
			if(str.charAt(i) == 'i') {
				while(stck.size()>0) {
					System.out.print(stck.peek()+" ");
					stck.pop();
				}
			}	
		}
		stck.push(num++);
		while(stck.size()>0) {
			System.out.print(stck.peek()+" ");
			stck.pop();
		}
		System.out.println();
	}
	public static void main(String[] args) {

		getnumdi("d");
		getnumdi("dd");
		getnumdi("dididddd");
		getnumdi("dddddddd");
		getnumdi("iiiiiiii");
	}

}
