import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * allpairspath
 */
public class allpairspath {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = in.readLine()).equals("0 0 0")){
            String[] numbers = line.split(" ");
            int n = Integer.parseInt(numbers[0]);
            int m = Integer.parseInt(numbers[1]);
            int q = Integer.parseInt(numbers[2]);
        };
    }
}