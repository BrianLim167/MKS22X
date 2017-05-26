import java.util.NoSuchElementException;
public class MyHeap{
    private Location[] ary;
    private int last;
    private final int mult;

    public MyHeap(){
	this(true);
    }
    public MyHeap(boolean type){
	ary = new Location[10];
	last = 0;
	if (type){
	    mult = 1;
	}else{
	    mult = -1;
	}
    }

    private void swap(Location[] ary,int a,int b){
	Location temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }
    private void pushUp(){
	pushUp(last);
    }
    private void pushUp(int ind){
	if (ind > 1 && ary[ind].compareTo(ary[ind/2])*mult > 0){
	    swap(ary,ind,ind/2);
	    pushUp(ind/2);
	}    
    }
    private void pushDown(){
	pushDown(1);
    }
    private void pushDown(int ind){
	if (2*ind+1 <= last){
	    if (ary[ind].compareTo(ary[2*ind])*mult < 0 &&
		ary[2*ind+1].compareTo(ary[2*ind])*mult <= 0){
		swap(ary,ind,2*ind);
		pushDown(2*ind);
	    }else if (ary[ind].compareTo(ary[2*ind+1])*mult < 0 &&
		ary[2*ind].compareTo(ary[2*ind+1])*mult <= 0){
		swap(ary,ind,2*ind+1);
		pushDown(2*ind+1);
	    }
	}else if (2*ind <= last){
	    if (ary[ind].compareTo(ary[2*ind])*mult < 0){
		swap(ary,ind,2*ind);
		pushDown(2*ind);
	    }
	}
    }

    private void grow(){
	Location[] big = new Location[2*ary.length];
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
    public void add(Location s){
	check();
	last++;
	ary[last] = s;
	pushUp();
    }

    public Location remove(){
	if (last < 1){
	    throw new NoSuchElementException();
	}
	Location ans = ary[1].clone();
	ary[1] = ary[last];
	last--;
	pushDown();
	return ans;
    }
    public Location peek(){
	if (last < 1){
	    throw new NoSuchElementException();
	}
	return ary[1];
    }

    public boolean hasNext(){
        return last >= 1;
	//return true;
    }
}
