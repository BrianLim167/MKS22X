public class MazeSolver{
    private Maze maze;
    private Frontier front;
    private boolean aStar;
    private boolean animate;

    public MazeSolver(String str){
	this(str,false);
    }
    public MazeSolver(String str,boolean animate){
	maze = new Maze(str);
	this.animate = animate;
    }
    
    public void solve(){
	solve(1);
    }
    public void solve(int style){
	if (style == 0){
	    front = new FrontierStack();
	    aStar = false;
	}else if (style == 1){
	    front = new FrontierQueue();
	    aStar = false;
	}else if (style == 2){
	    front = new FrontierPriorityQueue();
	    aStar = false;
	}else if (style == 3){
	    front = new FrontierPriorityQueue();
	    aStar = true;
	}

	boolean solved = false;
	Location nLoc;
	Location loc = new Location(maze.getStart().row(),maze.getStart().col(),null,0,
				    maze.getStart().distToGoal(),aStar);
	front.add(loc);

	while(front.hasNext() && !solved
	      ){
	    
	    if (animate){
		System.out.println(maze.toString(10));
	    }
	    if (loc.distToGoal()==0){
		solved = true;
	    }else{
		maze.set(loc.row(),loc.col(),'.');
		for (int dir=0 ; dir<4 ; dir++){
		    int nRow,nCol;
		    nRow = -1;
		    nCol = -1;
		    if (dir==0){
			nRow = loc.row();
			nCol = loc.col()+1;
		    }else if (dir==1){
			nRow = loc.row()+1;
			nCol = loc.col();
		    }else if (dir==2){
			nRow = loc.row();
			nCol = loc.col()-1;
		    }else if (dir==3){
			nRow = loc.row()-1;
			nCol = loc.col();
		    }
		    if (maze.get(nRow,nCol)==' ' || maze.get(nRow,nCol)=='?' ||
			maze.get(nRow,nCol)=='E'){
			nLoc = new Location(nRow,nCol,loc,
					    Math.abs(nRow-maze.getStart().row())
					    +Math.abs(nCol-maze.getStart().col()),
					    Math.abs(nRow-maze.getEnd().row())
					    +Math.abs(nCol-maze.getEnd().col()),
					    aStar);
			front.add(nLoc);
			if (nLoc.distToGoal()==0){
			    maze.set(nLoc.row(),nLoc.col(),'E');
			}else{
			    maze.set(nLoc.row(),nLoc.col(),'?');
			}
		    }
		}
		loc = front.next();
	    }
	}
	if (solved){
	    while (loc.previous() != null){
		loc = loc.previous();
		if (loc.distToStart()==0){
		    maze.set(loc.row(),loc.col(),'S');
		}else{
		    maze.set(loc.row(),loc.col(),'@');
		}
	    }
	}
	//System.out.println(maze);
    }

    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("java MazeSolver [filename] [style] [animate]");
	}
	else if (args.length == 2) {
	    MazeSolver q = new MazeSolver(args[0], false);
	    q.solve(Integer.parseInt(args[1]));
	}
	else {
	    MazeSolver q = new MazeSolver(args[0], args[2].equals("animate"));
	    q.solve(Integer.parseInt(args[1]));
	}
    }
}

