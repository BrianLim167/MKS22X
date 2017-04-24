import java.util.NoSuchElementException;
public class MyDeque{
    private String[] ary;
    private int front,back,size;
    
    public MyDeque(){
	ary = new String[10];
	front = 0;
	back = 0;
	size = 0;
    }

    private void grow(){
	String[] big = new String[2*ary.length];
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

    
    public void addFirst(String str){
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
    public void addLast(String str){
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

    public String removeFirst(){
        check(1);
	String str = ary[front];
	if (front == ary.length-1){
	    front = 0;
	}else{
	    front++;
	}
	size--;
	return str;
    }
    public String removeLast(){
        check(1);
	if (back == 0){
	    back = ary.length-1;
	}else{
	    back--;
	}
	size --;
	return ary[back];
    }

    public String getFirst(){
	check(1);
	return ary[front];
    }
    public String getLast(){
	check(1);
	if (back == 0){
	    return ary[ary.length-1];
	}
	return ary[back-1];
    }

}
