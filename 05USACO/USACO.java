import java.util.*;
import java.io.*;
public class USACO{
    public  USACO(){
    }
    public int bronze(String filename){
	try{
	    int[][] pasture;
	    int R,C,E,N;
	    Scanner scan = new Scanner(new File(filename));
	    R = scan.nextInt();
	    C = scan.nextInt();
	    E = scan.nextInt();
	    N = scan.nextInt();
	    pasture = new int[R][C];
	    for (int i = 0 ; i < R ; i++){
		for (int j = 0 ; j < C ; j++){
		    pasture[i][j] = scan.nextInt();
		    //System.out.print(pasture[i][j]);
		}
	    }
	    int row,col,dec;
	    for (int stomp=0 ; stomp<N ; stomp++){//while (scan.hasNextLine()){
		row = scan.nextInt()-1;
		col = scan.nextInt()-1;
		dec = scan.nextInt();
		//scan.nextLine();
		int max = 0; 
		for (int i = row; i < row + 3 && i < R; i++){
		    for (int j = col; j < col + 3 && j < C; j++){
			if (pasture[i][j] > max){
			    max = pasture[i][j];
			}
		    }
		}
		for (int i = row; i < row + 3 && i < R; i++){
		    for (int j = col; j < col + 3 && j < C; j++){
			if (pasture[i][j] > max - dec){
			    pasture[i][j] = max - dec;
			}
		    }
		}
	    }
	    int ans = 0;
	    for (int i = 0 ; i < R ; i++){
		for (int j = 0 ; j < C; j++){
		    if (pasture[i][j] < E){
			ans += E - pasture[i][j];
		    }
		}
	    }
	    return ans * 72 * 72;
	}
	catch (FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	return -1;
    }
    public static void main(String[]args){
	USACO x = new USACO();
	System.out.println(x.bronze("makelake.in"));
    }
}
