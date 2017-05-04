public class MyHeap{
    private String[] ary;
    private int last;
    private final int mult;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean type){
	ary = new String[10];
	last = 0;
	if (type){
	    mult = 1;
	}else{
	    mult = -1;
	}
    }

    private void pushUp(){
	pushUp(last);
    }
    private void pushUp(int ind){
	if (ind > 1 && ary[ind].compareTo(ary[ind/2])*mult > 0){
	    String temp = ary[ind];
	    ary[ind] = ary[ind/2];
	    ary[ind/2] = temp;
	}    
    }
    private void pushDown(){
	pushDown(1);
    }
    private void pushDown(int ind){
    }

    private void grow(){
	String[] big = new String[2*ary.length];
	for (int ind=0 ; ind<ary.length ; ind++){
	    big[ind] = ary[ind];
	}
	ary = big;
    }
    private void check(){
	if (last == ary.length-1){
	    grow();
	}
    }
    public void add(String s){
	check();
	last++;
	ary[last] = s;
	pushUp();
    }

    public String remove(){
	if (last < 1){
	    throw new NoSuchElementException();
	}
	String ans = ary[1];
	ary[1] = last;
	last--;
	pushDown();
	return ans;
    }
    public String peek(){
	if (last < 1){
	    throw new NoSuchElementException();
	}
	return ary[1];
    }
}
