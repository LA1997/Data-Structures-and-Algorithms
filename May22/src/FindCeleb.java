
public class FindCeleb {

	public static int findCeleb(boolean[][] arr) {
		
		int left=0,right=arr.length-1;
		while(left<right) {
			if(arr[left][right] == true) {
				left++;
			}
			else {
				right--;
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(i != left) {
				if(arr[left][i] == true || arr[i][left] == false) 
					return -1;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] arr = {{false,false,true,false,true,true},
							{true,false,true,true,true,true},
							{true,false,false,true,true,true},
							{true,true,true,false,true,false},
							{false,false,false,false,false,false},
							{true,false,true,true,true,false}
						};
		
		System.out.println(findCeleb(arr));
	}
	
}
