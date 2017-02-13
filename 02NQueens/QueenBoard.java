public class QueenBoard{

    private int[][]board;

    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	board = new int[board.length][board.length];
	solveH(0);
    }

    private boolean solveH(int col){
        if (col == board.length-1){
	    for (int row=0 ; row<board.length ; row++){
		if (board[row][col] == 0){
		    addQueen(row,col);
		    return true;
		}
	    }
	    return false;
	}
	for (int row=0 ; row<board.length ; row++){
	    if (board[row][col]==0){
		addQueen(row,col);
		if (solveH(col+1)){
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }

    private void addQueen(int row,int col){
	for (int r=0 ; r<board.length; r++){
	    board[r][col]++;
	}
	for (int c=0 ; c<board.length ; c++){
	    board[row][c]++;
	}
	int n;
	n=0;
	while (row+n<board.length && col+n<board.length){
	    board[row+n][col+n]++;
	    n++;
	}
	n=0;
	while (row+n<board.length && col-n>=0){
	    board[row+n][col-n]++;
	    n++;
	}
	n=0;
	while (row-n>=0 && col+n<board.length){
	    board[row-n][col+n]++;
	    n++;
	}
	n=0;
	while (row-n>=0 && col-n>=0){
	    board[row-n][col-n]++;
	    n++;
	}
	board[row][col] = -1;
    }
    
    private void removeQueen(int row,int col){
	for (int r=0 ; r<board.length ; r++){
	    board[r][col]--;
	}
	for (int c=0 ; c<board.length ; c++){
	    board[row][c]--;
	}
	int n;
	n=0;
	while (row+n<board.length && col+n<board.length){
	    board[row+n][col+n]--;
	    n++;
	}
	n=0;
	while (row+n<board.length && col-n>=0){
	    board[row+n][col-n]--;
	    n++;
	}
	n=0;
	while (row-n>=0 && col+n<board.length){
	    board[row-n][col+n]--;
	    n++;
	}
	n=0;
	while (row-n>=0 && col-n>=0){
	    board[row-n][col-n]--;
	    n++;
	}
	board[row][col] = 0;
    }

    public void countSolutions(){
	board = new int[board.length][board.length];
	solutionCount = 0;
	countSolutionsH(0);
    }

    public void countSolutionsH(int col){
        if (col == board.length-1){
	    for (int row=0 ; row<board.length ; row++){
		if (board[row][col] == 0){
		    solutionCount++;
		}
	    }
	}else{
	    for (int row=0 ; row<board.length ; row++){
		if (board[row][col]==0){
		    addQueen(row,col);
		    countSolutionsH(col+1);
		    removeQueen(row,col);
		}
	    }
	}
    }

    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */
    
    public int getCount(){
    	return solutionCount;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String ans = "";
	for (int row=0 ; row<board.length ; row++){
	    for (int col=0 ; col<board.length ; col++){
		if (board[row][col] == -1){
		    ans += "Q ";
		}else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

        public String toStringDebug(){
    	String ans = "";
	for (int row=0 ; row<board.length ; row++){
	    for (int col=0 ; col<board.length ; col++){
	        ans += (board[row][col] + "  ").substring(0,3);
	    }
	    ans += "\n";
	}
	return ans;
    }
}



