import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Vegetables
 */
public class Vegetables {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        float t = Float.parseFloat(st.nextToken());
        int nVeg = Integer.parseInt(st.nextToken());
        int[] veggies = new int[nVeg];
    }
}