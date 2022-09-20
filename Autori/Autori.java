import java.util.Scanner;

/**
 * Autori
 */
public class Autori {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        String[] arr = in.split("-");
        for (String string : arr) {
            System.out.print(string.substring(0,1));
        }
    }
}