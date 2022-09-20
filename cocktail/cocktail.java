import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * cocktail
 */
public class cocktail {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int T = Integer.parseInt(line[1]);
        int time = 0;
        int runOut = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(in.readLine()));
        }
        while(!pq.isEmpty()){
            int dose = pq.remove();
            time += T;
            int doseRunOut = time + dose;
            if(doseRunOut < runOut)
                runOut = doseRunOut;
        }
            if(runOut <= time) System.out.println("NO");
            else System.out.println("YES");

            
        
    }
}