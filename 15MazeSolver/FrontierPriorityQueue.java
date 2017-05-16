public class FrontierPriorityQueue implements Frontier{
    private MyHeap heap;

    public FrontierPriorityQueue(){
	heap = new MyHeap(false);
    }

    public void add(Location loc){}
    public Location next(){return null;}
}
