import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * cd
 */
public class cd {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int jack = Integer.parseInt(line[0]);
        int jill = Integer.parseInt(line[1]);
        HashSet<Integer> jackCDs = new HashSet<>();
        HashSet<Integer> jillCDs = new HashSet<>();
        
        while (jack != 0 && jill != 0) {
            int count = 0;
            while (count < jack) {
                jackCDs.add(Integer.parseInt(in.readLine()));
                count++;
            }
            count = 0;
            while (count < jill) {
                jillCDs.add(Integer.parseInt(in.readLine()));
                count++;
            }
            jackCDs.retainAll(jillCDs);
            System.out.println(jackCDs.size());
            line = in.readLine().split(" ");
            jackCDs.clear();
            jillCDs.clear();
            jack = Integer.parseInt(line[0]);
            jill = Integer.parseInt(line[1]);
        }
    }

}