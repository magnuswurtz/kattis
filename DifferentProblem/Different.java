import java.util.Scanner;

/**
 * Different
 */
public class Different {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            long y = Long.parseLong(s[0]);
            long x = Long.parseLong(s[1]);

            System.out.println(Math.abs(y-x));
        }
    }
}