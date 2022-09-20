import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kornislav
 */
public class Kornislav {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(sc.nextInt());
        ints.add(sc.nextInt());
        ints.add(sc.nextInt());
        ints.add(sc.nextInt());
        ints.sort(null);
        System.out.println(ints.get(0)*ints.get(2));
    }
}