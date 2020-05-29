import java.util.Stack;

public class Expressions {

	public static int getPriority(char ch) {
		switch(ch) {
			case '+':
			case '-': return 1;
			case '*': 
			case '/': return 2;
			case '^': return 3;
			default: return -1;
		}
		
	}
	public static int eval(int op1,int op2,char op) {
		int a = op1;
		int b = op2;
		switch(op) {
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;
			case '^': return (int)Math.pow(a, b);
			default: return Integer.MIN_VALUE;
	
		}
	}
	public static int infixeval(String exp) {
		
		Stack<Character> oprst = new Stack<>();
		Stack<Integer> valst = new Stack<>();
		
		for(int i=0;i<exp.length();i++) {
			
			char ch = exp.charAt(i);
			if(ch == '(') {
				oprst.push(ch);
			}
			else if(ch >= '0' && ch <= '9') {
				valst.push(ch-'0');
			}
			else if(ch == ')') {
				while(oprst.peek()!='(') {
					char op = oprst.pop();
					int op2 = valst.pop();
					int op1 = valst.pop();
					valst.push(eval(op1,op2,op));
				}
				oprst.pop();
			}
			else {
				int priority = getPriority(ch);
				while(!(oprst.size() == 0 || priority > getPriority(oprst.peek()) || oprst.peek() == '('))  {
					char op = oprst.pop();
					int op2 = valst.pop();
					int op1 = valst.pop();
					valst.push(eval(op1,op2,op));
				}
				oprst.push(ch);
			}
		}
		while(oprst.size()>0) {
			char op = oprst.pop();
			int op2 = valst.pop();
			int op1 = valst.pop();
			valst.push(eval(op1,op2,op));
		}
		return valst.pop();
	}
	public static String infixtopostfix(String exp) {
		
		String postfix = "";
		Stack<Character> stck = new Stack<Character>();
		for(int i=0;i<exp.length();i++) {
			
			char ch = exp.charAt(i);
			
			if(ch == '(') {
				stck.push(ch);
			}
			else if(ch >= '0' && ch <= '9') {
				postfix += ch;
			}
			else if(ch == ')') {
				while(stck.peek() != '(') {
					postfix += stck.pop();
				}
				stck.pop();
			}
			else {
				while(!(stck.size() == 0 || stck.peek() == '(' || getPriority(ch) > getPriority(stck.peek()))) {
					postfix += stck.pop();
				}
				stck.push(ch);
			}
			
		}
		while(stck.size() > 0) {
			postfix += stck.pop();
		}
		return postfix;
	}
	
	public static String reverse(String exp) {
		
		String rev = "";
		for(int i=exp.length()-1;i>=0;i--) {
			rev+=exp.charAt(i);
		}
		return rev;
	}
	public static String infixtoprefix(String exp) {
		
		String prefix = "";
		//Reverse the infix exp
		exp = reverse(exp);
		//Exchange '(' and ')'
		
		
		//Find the postfix of reversed
		return prefix;
	}
	public static void post123(String post) {
		
		Stack<Integer> es = new Stack<Integer>();
		Stack<String> ins = new Stack<String>();
		Stack<String> prs = new Stack<String>();
		
		for(int i=0;i<post.length();i++) {
			
			char ch = post.charAt(i);
			if(ch >= '0' && ch <= '9') {
				es.push(ch-'0');
				ins.push(""+ch);
				prs.push(""+ch);
			}
			else {
				int op2 = es.pop();
				int op1 = es.pop();
				es.push(eval(op1,op2,ch));
				
				String inop2 = ins.pop();
				String inop1 = ins.pop();
				ins.push('('+inop1+ch+inop2+")");
				
				String prop2 = prs.pop();
				String prop1 = prs.pop();
				prs.push(""+ch+prop1+prop2);	
			}
		}
		System.out.println(es.peek());
		System.out.println(ins.peek());
		System.out.println(prs.peek());
		
		
	}
	public static void pre123(String pre) {
		
		Stack<Integer> es = new Stack<Integer>();
		Stack<String> ins = new Stack<String>();
		Stack<String> pts = new Stack<String>();
		
		for(int i=pre.length()-1;i>=0;i--) {
			
			char ch = pre.charAt(i);
			if(ch >= '0' && ch <= '9') {
				es.push(ch-'0');
				ins.push(""+ch);
				pts.push(""+ch);
			}
			else {
				int op1 = es.pop();
				int op2 = es.pop();
				es.push(eval(op1,op2,ch));
				
				String inop1 = ins.pop();
				String inop2 = ins.pop();
				ins.push('('+inop1+ch+inop2+")");
				
				String ptop1 = pts.pop();
				String ptop2 = pts.pop();
				pts.push(""+ch+ptop1+ptop2);	
			}
		}
		System.out.println(es.peek());
		System.out.println(ins.peek());
		System.out.println(pts.peek());
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String e1 = "8+2/3+2^1*(1+3)";
		String e2 = "8+2/(3+2)^(1*1+3)";
		String e3 = "(8+2)/3+2^(1*1+3)";
		
		System.out.println(infixeval(e1));
		System.out.println(infixtopostfix(e1));
		System.out.println();
		
		System.out.println(infixeval(e2));
		System.out.println(infixtopostfix(e2));
		System.out.println();
		
		System.out.println(infixeval(e3));
		System.out.println(infixtopostfix(e3));
		System.out.println();
		
		String poste1 = infixtopostfix(e1);
		post123(poste1);
		String pree1 = infixtoprefix(e1);
		post123(poste1);
		
	}

}
