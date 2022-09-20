import java.util.Scanner;

/**
 * Planina
 */
public class Planina {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = (int)Math.pow(2,n)+1;
        System.out.println(result*result);
    }
}