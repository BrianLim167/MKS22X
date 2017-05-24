public class Location implements Comparable<Location>{
    private int row,col;
    private Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;
    

    public Location(int row,int col){
	this.row = row;
	this.col = col;
    }
        public Location (int row,int col,Location previous,int distToStart,int distToGoal){
	this.row = row;
	this.col = col;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
    }
    public Location (int row,int col,Location previous,int distToStart,int distToGoal,boolean aStar){
	this.row = row;
	this.col = col;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }
    
    
    public int compareTo(Location other){
	if (aStar){
	    return (distToStart+distToGoal)-(other.distToStart+other.distToGoal);
	}
	return distToGoal-other.distToGoal;
    }

    public int row(){
	return row;
    }
    public int col(){
	return col;
    }
    public Location previous(){
	return previous;
    }
    public int distToStart(){
	return distToStart;
    }
    public int distToGoal(){
	return distToGoal;
    }
    public boolean aStar(){
	return aStar;
    }
    /*
    public void row(int row){
	this.row = row;
    }
    public int col(){
    }
    public Location previous(){
	return previous;
    }
    public int distToStart(){
	return distToStart;
    }
    public int distToGoal(){
	return distToGoal;
    }
    public boolean aStar(){
	return aStar;
    }
    */

}
