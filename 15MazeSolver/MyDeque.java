import java.util.NoSuchElementException;
public class MyDeque{
    private Location[] ary;
    private int front,back,size;
    
    public MyDeque(){
	ary = new Location[10];
	front = 0;
	back = 0;
	size = 0;
    }

    private void grow(){
	Location[] big = new Location[2*ary.length];
	for (int ind=0 ; ind<ary.length-front ; ind++){
	    big[big.length-1-ind] = ary[ary.length-1-ind];
	}
	for (int ind=0 ; ind<back ; ind++){
	    big[ind] = ary[ind];
	}
	front += big.length-ary.length;
	ary = big;
    }
    private void check(int mode){
	if (mode == 0 && front == back && size == ary.length){
	    grow();
	}else if (mode == 1 && size == 0){
	    throw new NoSuchElementException();
	}
    }

    
    public void addFirst(Location str){
	if (str == null){
	    throw new NullPointerException();
	}
	check(0);
	if (front == 0){
	    front = ary.length-1;
	}else{
	    front--;
	}
	ary[front] = str;
	size++;
    }
    public void addLast(Location str){
	if (str == null){
	    throw new NullPointerException();
	}
	check(0);
	ary[back] = str;
	if (back == ary.length-1){
	    back = 0;
	}else{
	    back++;
	}
	size++;
    }

    public Location removeFirst(){
        check(1);
	Location str = ary[front];
	if (front == ary.length-1){
	    front = 0;
	}else{
	    front++;
	}
	size--;
	return str;
    }
    public Location removeLast(){
        check(1);
	if (back == 0){
	    back = ary.length-1;
	}else{
	    back--;
	}
	size --;
	return ary[back];
    }

    public Location getFirst(){
	check(1);
	return ary[front];
    }
    public Location getLast(){
	check(1);
	if (back == 0){
	    return ary[ary.length-1];
	}
	return ary[back-1];
    }

    public boolean hasNext(){
	return size != 0;
    }
}
