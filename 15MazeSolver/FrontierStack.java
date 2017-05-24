public class FrontierStack implements Frontier{
    private MyDeque deque;

    public FrontierStack(){
	deque = new MyDeque();
    }

    public void add(Location loc){
	deque.addLast(loc);
    }
    public Location next(){
	return deque.removeLast();
    }
    public boolean hasNext(){
	return deque.hasNext();
    }
}
