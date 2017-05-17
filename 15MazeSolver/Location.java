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
}
