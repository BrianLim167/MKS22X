import java.util.*;
public class Driver{
    public static void main(String[]args){
	ArrayList<String> a = Quiz2Redux.combinations("abcd");
	for (int i=0 ; i<a.size() ; i++){
	    System.out.println(a.get(i));
	}
	System.out.println("###");
	a = Quiz2Redux.combinations("kji");
	for (int i=0 ; i<a.size() ; i++){
	    System.out.println(a.get(i));
	}
    }
}
