public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;
    boolean hasNext;

    public FrontierPriorityQueue(){
	heap = new MyHeap(false);
	hasNext = false;
    }

    public void add(Location loc){
	heap.add(loc);
	hasNext = true;
    }
    public Location next(){
	return heap.remove();
    }
    public boolean hasNext(){
	return hasNext;
    }
}
