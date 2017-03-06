import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
	setAnimate(false);
	try{
	    Scanner scan = new Scanner(new File(filename));
	    ArrayList<String> text = new ArrayList<String>();
	    boolean existE=false,existS=false;
	    while (scan.hasNextLine()){
		text.add(scan.nextLine());
	    }
	    maze = new char[text.size()][text.get(0).length()];
	    for (int row=0 ; row<maze.length ; row++){
		for (int col=0 ; col<maze[0].length ; col++){
		    maze[row][col] = text.get(row).charAt(col);
		    if (maze[row][col]=='E'){
			if (existE){
			    System.out.println("File contains multiple 'E's");
			    System.exit(1);
			}
			existE = true;
		    }
		    if (maze[row][col]=='S'){
			if(existS){
			    System.out.println("File contains multiple 'S's");
			    System.exit(1);
			}
			existS = true;
		    }
		}
	    }
	    if (!existE || !existS){
		System.out.println("File does not contain a start and an end");
		System.exit(1);
	    }
	}
	catch (FileNotFoundException exc){
	    System.out.println("Invalid file name");
	    System.exit(1);
	}
    }
    
    public String toString(){
	String ans = "";
	for (int row=0 ; row<maze.length ; row++){
	    for (int col=0 ; col<maze[0].length ; col++){
		ans += maze[row][col];
	    }
	    ans += "\n";
	}
	return ans;
    }

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr=-1,startc=-1;

	//Initialize starting row and startint col with the location of the S. 
	for (int row=0 ; row<maze.length ; row++){
	    for (int col=0 ; col<maze[0].length ; col++){
		if (maze[row][col] == 'S'){
		    startr = row;
		    startc = col;
		}
	    }
	}
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE
	if (row<0 || row>=maze.length || col<0 || col>=maze[0].length){
	    return false;
	}else if (maze[row][col]=='E'){
	    return true;
	}
	if (maze[row][col]==' '){
	    maze[row][col] = '@';
	    if (solve(row-1,col) || solve(row+1,col) || solve(row,col-1) || solve(row,col+1)){
		return true;
	    }
	    maze[row][col] = '.';
	}
        return false; //so it compiles
    }


}
