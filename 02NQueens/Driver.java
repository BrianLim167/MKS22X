public class Driver{
    public static void main(String[]args){
	QueenBoard A = new QueenBoard(5);
	System.out.println(A.toStringDebug());
	A.solve();
	System.out.println(A.toStringDebug());
	A.countSolutions();
	System.out.println(A.getSolutionCount());
	System.out.println("#####");
	QueenBoard B = new QueenBoard(1);
	for (int n=1 ; n<=10 ; n++){
	    B = new QueenBoard(n);
	    B.solve();
	    System.out.println(B);
	    B.countSolutions();
	    System.out.println(B.getSolutionCount());
	    System.out.println("-----");
	}
    }
}
