public class KnightBoard{
    private int[][]board;

    public KnightBoard(int row,int col){
	board = new int[row][col];
    }

    public void solve(){
	solveH(0,0,0);
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
	return false;
    }

    private int dX(int dir){
	if (dir <= 1){
	    return 2;
	}
	if (dir <= 3){
	    return 1;
	}
	if (dir <= 5){
	    return -1;
	}
	if (dir <= 7){
	    return -2;
	}
	return 0;
    }

    private int dY(int dir){
	if (dir == 2 || dir == 4){
	    return 2;
	}
	if (dir == 0 || dir == 6){
	    return 1;
	}
	if (dir == 1 || dir == 7){
	    return -1;
	}
	if (dir == 3 || dir == 5){
	    return -2;
	}
	return 0;
    }
}
