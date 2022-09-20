import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Password
 */
public class Password {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double expectedValue = 0.0;
        int j = sc.nextInt();
        Set<Double> inputs  = new TreeSet<>();
        
        for (int i = 0; i < j; i++) {
            sc.next();
            inputs.add(Double.parseDouble(sc.next()));
        }
        for (Double dd : inputs) {
            expectedValue += dd*j;
            j--;
        }
        System.out.println(expectedValue);
    }
}
