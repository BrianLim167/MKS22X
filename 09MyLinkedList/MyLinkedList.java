public class MyLinkedList{
    LNode head,tail;
    int size;
    public MyLinkedList(){}

    public boolean add(int value){
	LNode temp = new LNode(value);
	temp.prev(tail);
	tail = temp;
	size++;
	return true;
    }
    public int size(){
	return size;
    }
    public int get(int index){
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
	return current.value;
    }
    public int set(int index,int value){
	LNode current;
	if (index <= size/2){
	    current = start;
	    for (int i=0 ; i<index ; i++){
		current = current.next;
	    }
	}else{
	    current = tail;
	    for (int i=0 ; i<size-index ; i++){
		current = current.prev;
	    }
	}
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
	LNode current = head ;
	String ans = "[";
	while (current != null){
	    ans += " "+current.value;
	    current = current.next;
	}
	ans += "]";
	return ans;
    }
}


class LNode{
    int value;
    LNode prev,next;
    public LNode(){}
    public LNode(int value){
	this.value = value;
    }
    public void prev(LNode prev){
	this.prev = prev;
    }
    public void next(LNode next){
	this.next = next;
    }
}
