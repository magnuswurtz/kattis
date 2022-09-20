/**
 * balanceFixedSizeStack
 */
import edu.princeton.cs.algs4.StdIn;

public class balancePushdownStack<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public static void main(String[] args) {
        balancePushdownStack<Character> stacki = new balancePushdownStack<>();
        
        while (StdIn.hasNextChar()) {
            Character c = StdIn.readChar();
            switch (c) {
                case '(': 
                    stacki.push(c);
                    break;

                case '[':
                    stacki.push(c);
                    break;

                case ')':
                    if (stacki.isEmpty() || stacki.pop() != '('){
                        System.out.println("0");
                        return;
                    }
                    break;
                case ']':
                    if (stacki.isEmpty() || stacki.pop() != '['){
                        System.out.println("0");
                        return;
                }
            }
        }
        if (!stacki.isEmpty()) {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }
}