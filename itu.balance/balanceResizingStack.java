import edu.princeton.cs.algs4.StdIn;

/**
 * This is an implementation of a stack of chars. The implementation of a stack structure follows
 * the implementation in S&W p. 141
 * */
public class balanceResizingStack {
    private Character[] stack = new Character[1];
    private int n = 0;

    public boolean isEmpty(){return n == 0;}

    public void resize(int max){
        Character[] temp = new Character[max];
        for (int i = 0; i < n; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void push(char c){
        if(n == stack.length){
            resize(2*stack.length);
        }
        stack[n++] = c;
    }

    public Character pop(){
        Character removed = stack[--n];
        stack[n] = null;
        if (n>0 && n == stack.length/4) {
            resize(stack.length/2);
        }
        return removed;
    }

    public static void main(String[] args) {
        balanceResizingStack balance = new balanceResizingStack();

        while (StdIn.hasNextChar()) {
            Character next = StdIn.readChar();
            if(next == '(' || next == '['){
                balance.push(next);
            }
            else if(next == ')'){
                if (balance.isEmpty() || balance.pop() != '('){
                    System.out.println("0");
                    return;
                }
            }
            else if(next == ']'){
                if (balance.isEmpty() || balance.pop() != '['){
                    System.out.println("0");
                    return;
                }
            }
        }
        if (!balance.isEmpty()) {
            System.out.println("0");
            return;
        }  
        System.out.println("1"); 
    }
}