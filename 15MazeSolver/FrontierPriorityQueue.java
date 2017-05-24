public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;

    public FrontierPriorityQueue(){
	heap = new MyHeap(false);
    }

    public void add(Location loc){
	heap.add(loc);
    }
    public Location next(){
	return heap.remove();
    }
    public boolean hasNext(){
	return heap.hasNext();
    }
}
