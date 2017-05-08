public class RunningMedian{
    MyHeap lo,hi;
    int loSize,hiSize;

    public RunningMedian(){
	lo = new MyHeap(true);
	hi = new MyHeap(false);
    }
    
    public void add(int val){
	lo.add(val);
	loSize++;
	if (loSize - hiSize == 2){
	    hi.add(lo.remove());
	    loSize--;
	    hiSize++;
	}
    }
    public double getMedian(){
	if (loSize > hiSize){
	    return lo.peek;
	}else if (loSize < hiSize){
	    return hi.peek;
	}
	return (lo.peek + hi.peek)/2.0;
    }
}
