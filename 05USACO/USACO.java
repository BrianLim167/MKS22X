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

    public int silver(String filename){
	try{
	    int[][] oldP,newP;
	    int N,M,T;
	    int R1,C1,R2,C2;
	    Scanner scan = new Scanner(new File(filename));
	    N = scan.nextInt();
	    M = scan.nextInt();
	    T = scan.nextInt();
	    scan.nextLine();
	    oldP = new int[N][M];
	    newP = new int[N][M];
	    for (int r=0 ; r<N ; r++){
		String line = scan.nextLine();
		for (int c=0 ; c<M ; c++){
		    if (line.charAt(c)!='.'){
			oldP[r][c] = -1;
			newP[r][c] = -1;
		    }
		    //System.out.println(oldP[r][c]);
		}
	    }
	    R1 = scan.nextInt()-1;
	    C1 = scan.nextInt()-1;
	    R2 = scan.nextInt()-1;
	    C2 = scan.nextInt()-1;
	    if (newP[R1][C1]==0 && newP[R2][C2]==0){
		newP[R1][C1] = 1;
	    }
	    for (int instance=0 ; instance<T ; instance++){
		//String q="";
		//for (int r=0 ; r<N ; r++){
		//    for (int c=0; c<M ; c++){
		//	q+=newP[r][c]+" ";
		//    }
		//    q+="\n";
		//}
		//System.out.println(q);
		for (int r=0 ; r<N ; r++){
		    for (int c=0 ; c<M ; c++){
			oldP[r][c] = newP[r][c];
			if (newP[r][c]!=-1){
			    newP[r][c] = 0;
			}
		    }
		}
		for (int r=0 ; r<N ; r++){
		    for (int c=0; c<M ; c++){
			if (oldP[r][c]>0){
			    if (onAry(oldP,r+1,c) && oldP[r+1][c]!=-1){
				newP[r+1][c]++;
			    }
			    if (onAry(oldP,r-1,c) && oldP[r-1][c]!=-1){
				newP[r-1][c]++;
			    }
			    if (onAry(oldP,r,c+1) && oldP[r][c+1]!=-1){
				newP[r][c+1]++;
			    }
			    if (onAry(oldP,r,c-1) && oldP[r][c-1]!=-1){
				newP[r][c-1]++;
			    }
			}
		    }
		}
	    }
	    return newP[R2][C2];
	}
	catch (FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	return -1;
    }

    public boolean onAry(int[][] ary,int r, int c){
	return r>=0 && r<ary.length && c>=0 && c<ary[0].length;
    }
    
    /**public static void main(String[]args){
	USACO x = new USACO();
	System.out.println(x.bronze("makelake.in"));
    }
    **/
    /**public static void main(String[]args){
	USACO x = new USACO();
	System.out.println(x.silver("ctravel.in"));
    }
    **/
    
}
