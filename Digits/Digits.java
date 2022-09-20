import java.util.Scanner;

/**
 * Digits
 */
public class Digits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean proceed = true;

        while (proceed) {
            String next = sc.nextLine();

            if (next.equals("END")) {
                proceed = false;
            }
            else{
                String x = next;
                String xPlusOne = String.valueOf(x.length());
                int i = 1;
                while(!x.equals(xPlusOne)){
                    x = xPlusOne;
                    xPlusOne = String.valueOf(x.length());
                    i++;
                }
                   System.out.println(i);
            }
        }
        sc.close();
    }
}