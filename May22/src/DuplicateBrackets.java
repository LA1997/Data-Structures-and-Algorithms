import java.util.Stack;

public class DuplicateBrackets {

	public static boolean isDuplicateBrackets(String exp) {
		
		Stack<Character> stck = new Stack<>();
		for(int i=0;i<exp.length();i++) {
			
			char ch = exp.charAt(i);
			if(ch == ')') {
				if(stck.peek() == '(') {
					return true;
				}
				else {
					while(stck.peek() !=  '(') {
						stck.pop();
					}
					stck.pop();
				}
			}
			else {
				stck.push(ch);
			}	
		}
		return false;
	}
	public static void main(String[] args) {
		
		System.out.println(isDuplicateBrackets("((a+b)+((c+d)))"));
		System.out.println(isDuplicateBrackets("((a+b)+((c+d)+e))"));
		System.out.println(isDuplicateBrackets("((a))"));
		System.out.println(isDuplicateBrackets("(a)"));
		
	}

}
