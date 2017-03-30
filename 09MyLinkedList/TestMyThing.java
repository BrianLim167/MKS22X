public class TestMyThing{
    public static void main(String[] args){
	MyLinkedList a = new MyLinkedList();
	System.out.println(a.size());
	System.out.println(a);
	a.add(4);
	System.out.println(a);
	a.add(5);
	System.out.println(a);
	System.out.println(a.size());
	System.out.println(a.get(0));
	System.out.println(a.get(1));
	System.out.println(a.set(1,99));
	System.out.println(a);
    }
}
