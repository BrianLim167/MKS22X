import java.util.LinkedList;
public class FrontierQueue implements Frontier{
    private MyDeque deque;

    public FrontierQueue(){
	deque = new MyDeque();
    }

    public void add(Location loc){
	deque.addLast(loc);
    }
    public Location next(){
	return deque.removeFirst();
    }
    public boolean hasNext(){
	return deque.hasNext();
    }

    /*
    private LinkedList<Location> list;

    public FrontierQueue(){
	list = new LinkedList<Location>();
    }

    public void add(Location loc){
	list.add(loc);
    }
    public Location next(){
	return list.remove(0);
    }
    public boolean hasNext(){
	return list.size()!=0;
    }
    */
}
