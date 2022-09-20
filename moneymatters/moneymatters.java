import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * moneymatters
 */
public class moneymatters {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out,true);

        String[] line = in.readLine().split(" ");
        int friends = Integer.parseInt(line[0]);
        int friendships = Integer.parseInt(line[1]);

        int[] amounts = new int[friends];
        int[] root = new int[friends];
        HashMap<Integer,Set<Integer>> sets = new HashMap<>();

        //initialisér root array - alle er singleton sets
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        //Initialisér amounts array med værdier fra stdin 
        for (int i = 0; i < friends; i++) {
            amounts[i] = Integer.parseInt(in.readLine());
        }
        //Opdater venskaber
        for (int i = 0; i < friendships; i++) {
            String[] l = in.readLine().split(" ");
            int first = Integer.parseInt(l[0]);
            int second = Integer.parseInt(l[1]);

            if(sets.containsKey(root[first])) sets.get(root[first]).add(root[second]);
            else {
            sets.put(root[first], new HashSet<Integer>()); 
            sets.get(root[first]).add(root[second]);
            sets.get(root[first]).add(root[first]);
            }
            root[second] = root[first];
        }
        // Check at alle indgange i HashMappet har en 0-sum
        for (Set<Integer> i : sets.values()) {
            int sum = 0;
            for (int j : i) {
                sum +=amounts[j];
            }
            if (sum != 0) {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        out.println("POSSIBLE");
    }
}