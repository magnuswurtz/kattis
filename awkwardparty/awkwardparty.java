import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * awkwardparty
 */
public class awkwardparty {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long awkwardness = Integer.parseInt(in.readLine());
        String[] seating = in.readLine().split(" ");
        HashMap<Integer,Integer> latestSeen = new HashMap<>();
        
        for (int i = 0; i < seating.length; i++) {
            int language = Integer.parseInt(seating[i]);
            if(latestSeen.get(language) != null){
                awkwardness = Math.min(awkwardness,i-latestSeen.get(language));
            }
            latestSeen.put(language, i);
        }
        System.out.println(awkwardness);
    }
}