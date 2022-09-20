import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("What is your name?");
        var name = in.nextLine();
        System.out.println("Hello "+name);
    }
} 