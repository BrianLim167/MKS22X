public class MyLinkedList{
    LNode start;
    int size;
    public MyLinkedList(){}

    public boolean add(int value){
	LNode temp = new LNode(value);
	temp.next(start);
	start = temp;
	return true;
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
