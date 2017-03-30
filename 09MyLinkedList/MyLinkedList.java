public class MyLinkedList{
    LNode start;
    int size;
    public MyLinkedList(){}

    public boolean add(int value){
	LNode temp = new LNode(value);
	temp.next(start);
	start = temp;
	size++;
	return true;
    }
    public int size(){
	return size;
    }
    public int get(int index){
	LNode current = start;
	for (int i=0 ; i<index ; i++){
	    current = current.next;
	}
	return current.value;
    }
    public int set(int index,int value){
	LNode current = start;
	for (int i=0 ; i<index ; i++){
	    current = current.next;
	}
	int old = current.value;
	current.value = value;
	return old;
    }

    public String toString(){
	LNode current = start;
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
    LNode next;
    public LNode(){}
    public LNode(int value){
	this.value = value;
    }
    public void next(LNode next){
	this.next = next;
    }
}
