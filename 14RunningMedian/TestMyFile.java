import java.util.Random;
public class TestMyFile{
    public static void main(String[]args){
	int val;
	Random rand = new Random();
	RunningMedian a = new RunningMedian();
	RunningMedian b = new RunningMedian();
	RunningMedian c = new RunningMedian();
	a.add(42);
	System.out.println(a.getMedian()+"\n=======");
	for (int i=0 ; i<101 ; i++){
	    val = i;
	    val = (int)(rand.nextInt(100));
	    //System.out.println(val);
	    b.add(val);
	}
	System.out.println("--------\n"+b.getMedian()+"\n=========\n");
	for (int i=0 ; i<100 ; i++){
	    val = i;
	    val = (int)(rand.nextInt(100));
	    //System.out.println(val);
	    c.add(val);
	}
	System.out.println("--------\n"+c.getMedian()+"\n=========\n");
    }
}
