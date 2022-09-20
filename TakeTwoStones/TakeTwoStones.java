import java.util.Scanner;

public class TakeTwoStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int factor = sc.nextInt()%2;

            switch(factor){
                case 1:
                System.out.println("Alice"); 
                break;

                case 0:
                System.out.println("Bob");
                break;
            }
    }
}