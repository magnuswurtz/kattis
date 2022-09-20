import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Modulo
 */
public class Modulo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> mod42 = new HashSet<>();
        while (sc.hasNextInt()) {
            mod42.add(sc.nextInt()%42);   
        }
     
        System.out.println(mod42.size());
    }
}