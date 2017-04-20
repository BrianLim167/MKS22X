import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    LNode head,tail;
    int size;


    private class LNode{
	int value;
	LNode prev,next;
	public LNode(){}
	public LNode(int value){
	    this.value = value;
	}
    }
    public class MyLinkedListIterator implements Iterator<Integer>{
	private LNode temp;
	
	public MyLinkedListIterator(){
	    temp = head; 
	}

	public boolean hasNext(){
	    return temp.next != null;
	}
	public Integer next(){
	    if (!hasNext()){
		throw new NoSuchElementException();
	    }
	    Integer ans = temp.value;
	    temp = temp.next;
	    return ans;
	}
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator();
    }
    
    public MyLinkedList(){
    }

    private LNode getNthNode(int index){
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current;
	if (index <= size/2){
	    current = head;
	    for (int i=0 ; i<index ; i++){
		current = current.next;
	    }
	}else{
	    current = tail;
	    for (int i=0 ; i<size-index ; i++){
		current = current.prev;
	    }
	}
	return current;
    }
    
    public boolean add(int value){
	LNode temp = new LNode(value);
	if (size == 0){
	    head = temp;
	}else{
	    tail.next = temp;
	    temp.prev = tail;
	}
	tail = temp;
	size++;
	return true;
    }
    private void addAfter(LNode target,LNode after){
	if (target == tail){
	    after.prev = target;
	    tail = target;
	    target.next = after;
	}else{
	    after.prev = target;
	    after.next = target.next;
	    target.next.prev = after;
	    target.next = after;
	}
    }
    public void add(int index,int value){
	LNode temp = new LNode(value);
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0){
	    head = temp;
	    tail = temp;
	}else if (index == 0){
	    temp.next = head;
	    head.prev = temp;
	    head = temp;
	}else {
	    addAfter(getNthNode(index-1),temp);
	}
	size++;
    }

    private void remove(LNode target){
	if (size == 1){
	    head = null;
	    tail = null;
	}else if (target == head){
	    head = head.next;
	    head.prev = null;
	}else if (target == tail){
	    tail = tail.prev;
	    tail.next = null;
	}else {
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }
    public int remove(int index){
	LNode target = getNthNode(index);
	int value = target.value;
	remove(target);
	return value;
    }
    
    public int size(){
	return size;
    }
    
    public int get(int index){
	return getNthNode(index).value;
    }
    public int set(int index,int value){
	LNode current = getNthNode(index);
	int old = current.value;
	current.value = value;
	return old;
    }
    
    public int indexOf(int value){
	LNode current;
	current = head;
	int index=0;
	while (current != null){
	    if (current.value == value){
		return index;
	    }
	    current = current.next;
	    index++;
	}
	return -1;
    }

    public String toString(){
	if (size == 0){
	    return "[]";
	}
	LNode current = head ;
	String ans = "[";
	while (current != null){
	    ans += current.value+", ";
	    current = current.next;
	}
	return ans.substring(0,ans.length()-2) + "]";
    }
}


