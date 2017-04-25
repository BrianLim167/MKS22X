import java.util.Stack;
public class StackCalc{
    public static double eval(String exp){
	String[] tokens = exp.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (int ind=0 ; ind<tokens.length ; ind++){
	    if (isOp(tokens[ind])){
		values.push(apply(tokens[ind],values.pop(),values.pop()));
	    }else{
		values.push(Double.parseDouble(tokens[ind]));
	    }
	}
	return values.pop();
    }
    private static boolean isOp(String token){
	return token.length() == 1 && token.compareTo("0") < 0;
    }
    private static double apply(String op,double latter,double former){
	if (op.equals("+")){
	    return former+latter;
	}else if (op.equals("-")){
	    return former-latter;
	}else if (op.equals("*")){
	    return former*latter;
	}else if (op.equals("/")){
	    return former/latter;
	}else if (op.equals("%")){
	    return former%latter;
	}
	return 0;
    }
}
