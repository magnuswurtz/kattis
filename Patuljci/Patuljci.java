import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Patuljci
 */
public class Patuljci {

    public static boolean hundred(List<Integer> integerList ){
        int sum = 0;
        for (Integer integer : integerList) {
            sum+=integer;
        }
        return (sum == 100);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            inputs.add(sc.nextInt());
        }
        
        boolean found = false;
        int x = 0;
        int y = 1;

        while (!found) {
            List<Integer> dwarfs = new ArrayList<>(inputs);
            dwarfs.remove(y);
            dwarfs.remove(x);
            

            if (hundred(dwarfs)) {
                dwarfs.forEach(dwarf -> System.out.println(dwarf));
                found = true;
            }
            else{
                y = (y+1)%9;
                x = (y == 0) ? (x+1)%8 : x;
                if (x ==y) {
                    y++;
                }     
            }
        }
        sc.close();
    }   
}