import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * arraysmoothening
 */
public class arraysmoothening {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        String[] numbers = in.readLine().split(" ");
        Map<Integer,Long> counts = Arrays.stream(numbers).collect(Collectors.groupingBy(e -> Integer.parseInt(e),Collectors.counting()));
        
        PriorityQueue<Map.Entry<Integer,Long>> pq = new PriorityQueue<>((a,b) -> b.getValue().intValue()-a.getValue().intValue());
        for(Map.Entry<Integer, Long> e : counts.entrySet()){
            pq.add(e);
        }
        
        for(int i = 0 ; i < K ; i++){
            Map.Entry<Integer,Long> e = pq.poll();
            Map.Entry<Integer,Long> e2 = Map.entry(e.getKey(), e.getValue()-1);
            pq.add(e2);
        }
        System.out.println(pq.poll().getValue());
    }
}