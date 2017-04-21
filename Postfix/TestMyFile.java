public class TestMyFile{
    public static void main(String[]args){
	System.out.println(Postfix.eval("10 2.0 +"));
	System.out.println(Postfix.eval("11 3 - 4 + 2.5 *"));
	System.out.println(Postfix.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
