

public class coin {
	public static int permu(int[] arr,int tar) {
		int[] tab = new int[tar+1];
		tab[0] = 1;
		for(int i=1;i<tab.length;i++) {
			for(int j=0 ; j<arr.length;j++) {
				
				int js = arr[j];
				int a = i-js;
				if(a>=0) {
					tab[i] += tab[a];
				}
			}
		}
		for(int i=0;i<tab.length;i++) {
			System.out.print(tab[i]+" ");
		}
		return tab[tar];
	}
	
	public static int combi(int[] arr,int tar) {
		int[] tab = new int[tar+1];
		tab[0] = 1;
		for(int j=0 ; j<arr.length;j++) {
			for(int i=1;i<tab.length;i++) {		
				int js = arr[j];
				int a = i-js;
				if(a>=0) {
					tab[i] += tab[a];
				}
			}
		}
		for(int i=0;i<tab.length;i++) {
			System.out.print(tab[i]+" ");
		}
		return tab[tar];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,5,6};
		int tar = 7;
		System.out.println(permu(arr,tar));
		System.out.println(combi(arr,tar));
	}

}