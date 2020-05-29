import java.util.ArrayList;
import java.util.Collections;

public class Lis {

//	public static void printPathHelper(int[] val,int[] strg,int p,int i) {
//		
//		if(i == 0) {
//			return;
//		}
//		p--;
//		while(strg[p] != i-1 || val[p])
//		printPath
//	}
//	public static void printPath(int[] val,int[] strg,int p) {
//		
//		int i=strg[p];
//		printPathHelper(val, strg, p, i);
//	}
	public static int lis(int[] val) {
		
		int[] strg =  new int[val.length];
		strg[0] = 1;
		int max = Integer.MIN_VALUE;
		for(int i=1; i<strg.length; i++) {
			max = strg[i];
			for(int j=0; j<i; j++) {
				if(val[i]>val[j]) {
					if(strg[j]>max) {
						max = strg[j];
					}
				}
			}
			strg[i] =max+ 1;
		}
		int maxl = Integer.MIN_VALUE; 
		int p=0;
		for(int i=0; i<strg.length; i++) {
			if(strg[i]>maxl) {
				maxl = strg[i];
				p=i;
			}
		}
//		printPath(val,strg,p);
		return maxl;
	}
	public static void main(String[] args) {
		int[] val = {10,22,9,33,21,50,41,60,80,1};
		System.out.println(lis(val));
	}
}
