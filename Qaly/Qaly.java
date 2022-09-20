import java.util.Scanner;

public class Qaly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float qaly = 0;
        int i = 0;

        while(i < n){
            var one = Double.parseDouble(sc.next());
            var two = Double.parseDouble(sc.next());
            qaly += one*two;
            i++;
        }
        System.out.println(qaly);
    } 
}