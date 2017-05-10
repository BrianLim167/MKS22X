public class RunningMedian{
    MyHeap lo,hi;
    int loSize,hiSize;

    public RunningMedian(){
	lo = new MyHeap(true);
	hi = new MyHeap(false);
    }
    
    public void add(int val){
	if (loSize == 0 && hiSize == 0 || val <= getMedian()){
	    lo.add(val);
	    loSize++;
	}else{
	    hi.add(val);
	    hiSize++;
	}
	if (loSize - hiSize == 2){
	    hi.add(lo.remove());
	    loSize--;
	    hiSize++;
	}else if (hiSize - loSize == 2){
	    lo.add(hi.remove());
	    hiSize--;
	    loSize++;
	}
    }
    public double getMedian(){
	if (loSize > hiSize){
	    return lo.peek();
	}else if (loSize < hiSize){
	    return hi.peek();
	}
	return (lo.peek() + hi.peek())/2.0;
    }
}
