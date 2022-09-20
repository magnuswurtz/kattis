import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * pivot
 */
public class pivot {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] numbers = in.readLine().split(" ");
        boolean[] potentials = new boolean[numbers.length];
        int numPivot = 0;
        int lmax = Integer.parseInt(numbers[0]);
        int rmin = Integer.parseInt(numbers[numbers.length-1]);
        
        for (int i = 0; i < numbers.length; i++) {
            int current = Integer.parseInt(numbers[i]);
            if (current >= lmax) {
                potentials[i] = true;
                lmax = current;
            }
        }
        for (int i = numbers.length-1; i >= 0; i--) {
            int current = Integer.parseInt(numbers[i]);
            if(current <= rmin) {
                rmin = current;
                if (potentials[i]){
                    numPivot++;
                }
            }
        }
        System.out.println(numPivot);
    }
}
