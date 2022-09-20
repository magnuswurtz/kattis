import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * easiest
 */
public class easiest {

    static int digitSum(int in){
        String[] inString = String.valueOf(in).split("");
        int out = 0;
        for (String s : inString) {
            out += Integer.parseInt(s);
        }
        return out;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n != 0) {
            int out = 11;
            int crossOut = digitSum(out*n);
            int crossN = digitSum(n);
            while (crossN != crossOut) {
                out ++;
                crossOut = digitSum(out*n);
            }
            System.out.println(out);
            n = in.nextInt();
        }  
    }
}