public class Recursion{
    public static String name(){
	return "Lim,Brian";
    }

    public static double sqrt(double n){
	return sqrtH(n,1);
    }
    
    public static double sqrtH(double n,double guess){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (isCloseEnough(guess*guess,n)){
	    return guess;
	}else {
	    return sqrtH(n,0.5*(n/guess+guess));
	}
    }

    public static boolean isCloseEnough(double a, double b){
	return a != 0.0 && Math.abs(a-b)/a <= 0.000000000000001
	    || b != 0.0 && Math.abs(a-b)/b <= 0.000000000000001
	    || a == b;
    }
}
