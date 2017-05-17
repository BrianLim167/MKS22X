public class MazeSolver{
    private Maze board;
    private Frontier front;
    private boolean animate;

    public MazeSolver(String str){
	this(str,false);
    }
    public MazeSolver(String str,boolean animate){
	board = new Maze(str);
	this.animate = animate;
    }
    
    public void solve(){
	solve(1);
    }
    public void solve(int style){
	if (style == 0){
	    front = new StackFrontier();
	}else if (style == 1){
	    front = new QueueFrontier();
	}else if (style == 2){
	    front = new FrontierPriorityQueue();
	}else if (style == 3){
	    front = new FrontierPriorityQueue();
	}
    }

}
