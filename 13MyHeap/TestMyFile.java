import java.util.Random;
public class TestMyFile{
    public static void main(String[]args){
	MyHeap alpha = new MyHeap();
	MyHeap beta = new MyHeap(false);
	Random rand = new Random();
	
	for (int i=0 ; i<26 ; i++){
	    alpha.add(Character.toString((char)(122-i)));
	    beta.add(Character.toString((char)(97+i)));
	}
	for (int i=0 ; i<26 ; i++){
	    System.out.print(alpha.remove());
	}
	System.out.println();
	for (int i=0 ; i<26 ; i++){
	    System.out.print(beta.remove());
	}
	System.out.println();
	
	for (int i=0 ; i<26 ; i++){
	    alpha.add(Character.toString((char)(97+i)));
	    beta.add(Character.toString((char)(122-i)));
	}
	for (int i=0 ; i<26 ; i++){
	    System.out.print(alpha.remove());
	}
	System.out.println();
	for (int i=0 ; i<26 ; i++){
	    System.out.print(beta.remove());
	}
	System.out.println();
	
	for (int i=0 ; i<60 ; i++){
	    alpha.add(Character.toString((char)(97+rand.nextInt(26))));
	    beta.add(Character.toString((char)(97+rand.nextInt(26))));
	}
	for (int i=0 ; i<60 ; i++){
	    System.out.print(alpha.remove());
	}
	System.out.println();
	for (int i=0 ; i<60 ; i++){
	    System.out.print(beta.remove());
	}
	System.out.println();
	
    }
}
