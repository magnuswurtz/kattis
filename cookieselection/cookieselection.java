import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class cookieselection {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> upper = new PriorityQueue<>(); //min priority queue with the upper half of cookies according to diameter size
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());//max priority queue with the lower half of cookies according to diameter size
        StringBuilder out = new StringBuilder();

        String line = in.readLine();
        while (line != null) {
            //Check and resize so they're always equal or upper is at most 1 bigger than lower
            if(lower.size() > upper.size()) upper.add(lower.poll()); 
            if(upper.size() > 1 + lower.size()) lower.add(upper.poll());
            
            if(line.equals("#")){
                out.append(upper.poll()).append("\n"); //add median cookie to output-string
                line = in.readLine();
                continue;
            }
            int cookie = Integer.parseInt(line);

            //Add new cookie to lower or upper
            if (upper.peek() != null && cookie < upper.peek()) lower.add(cookie);
            else upper.add(cookie);

            line = in.readLine();
        }
        System.out.println(out);
    }
}