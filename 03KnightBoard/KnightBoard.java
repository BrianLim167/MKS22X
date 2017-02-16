public class KnightBoard{
    private int[][]board;

    public KnightBoard(int row,int col){
	board = new int[row][col];
    }

    public void solve(){
	solveH(0);
    }

    private boolean solveH(int row,int col,int level){
	if (row<0 || row>=board.length || col<0 || col>=board[0].length){
	    return false;
	}
	if (level == board.length * board[0].length){
	    if (board[row][col]==0){
		board[row][col] = level;
		return true;
	    }
	    return false;
	}
	if (board[row][col]==0){
	    board[row][col] = level;
	    for (int dir=0 ; dir<8 ; dir++){
		int newX = row+dX(dir);
		int newY = col+dY(dir);
		if (solveH(newX,newY,level+1)){
		    return true;
		}
		board[row][col] = 0;
	    }

}
