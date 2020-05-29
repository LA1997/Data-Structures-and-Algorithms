import java.util.ArrayList;

public class KnightsTour {

	public static boolean isValid(int[][] chess,int row,int col) {
		if(row<0 || row>=chess.length || col<0 || col>=chess.length) {
			return false;
		}
		else if(chess[row][col] != -1) {
			return false;
		}
		return true;
	}
	
	static int counter = 0;
	public static void knightsTour(int[][] chess,int row,int col,int mov) {
		
		if(mov == chess.length * chess.length - 1) {
			
			chess[row][col] = mov;
			counter++;
			System.out.println("------------"+counter+"--------------");
			for(int i=0; i<chess.length; i++) {
				for(int j=0; j<chess[i].length; j++) {
					System.out.print(chess[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("------------"+counter+"--------------");
			chess[row][col] = -1;
			return;
		}
		
		chess[row][col] = mov;
		
		if(isValid(chess, row-2, col+1)) {
			knightsTour(chess, row-2, col+1, mov+1);
		}
		if(isValid(chess, row-1, col+2)) {
			knightsTour(chess, row-1, col+2, mov+1);
		}
		if(isValid(chess, row+1, col+2)) {
			knightsTour(chess, row+1, col+2, mov+1);
		}
		if(isValid(chess, row+2, col+1)) {
			knightsTour(chess, row+2, col+1, mov+1);
		}
		if(isValid(chess, row+2, col-1)) {
			knightsTour(chess, row+2, col-1, mov+1);
		}
		if(isValid(chess, row+1, col-2)) {
			knightsTour(chess, row+1, col-2, mov+1);
		}
		if(isValid(chess, row-1, col-2)) {
			knightsTour(chess, row-1, col-2, mov+1);
		}
		if(isValid(chess, row-2, col-1)) {
			knightsTour(chess, row-2, col-1, mov+1);
		}
		
		chess[row][col] = -1;
		
	}
	public static void main(String[] args) {

		int n=5;
		int[][] chess = new int[n][n];
		for(int i=0; i<chess.length; i++) {
			for(int j=0; j<chess[i].length; j++) {
				chess[i][j] = -1;
			}
		}
		knightsTour(chess, 1, 1, 0);
	}

}
