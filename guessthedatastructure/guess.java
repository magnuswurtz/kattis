import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class guess {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        String outer;
        while ((outer = in.readLine()) != null) {
            int outer2 = Integer.parseInt(outer);
            PriorityQueue<Integer> pq = new PriorityQueue<>(outer2, Comparator.reverseOrder());
            Stack<Integer> stacki = new Stack<>();
            LinkedList<Integer> queuei = new LinkedList<>();

            boolean stack = true;
            boolean queue = true;
            boolean priority = true;
            String[] type = new String[]{"stack", "queue","priority queue"};
            int possibleTypes = 3;


            for (int i = 0; i < outer2; i++) {
                String[] line = in.readLine().split(" ");
                switch (line[0]) {
                    case "1":
                        int ss = Integer.parseInt(line[1]);
                        pq.add(ss);
                        stacki.push(ss);
                        queuei.add(ss);
                        break;
                    case "2":
                        int outputValue = Integer.parseInt(line[1]);
                        if (pq.size() <= 0 || stacki.size() <= 0 || queuei.size() <= 0) { 
                            possibleTypes = 0;
                            break;}
        
                        if (outputValue != pq.remove() && priority) { //priority queue?
                            priority = false;
                            possibleTypes--;
                            type[2] = null;
                        }
                        if (outputValue != queuei.removeFirst() && queue) { //queue?
                            queue = false;
                            possibleTypes--;
                            type[1] = null;
                        }
                        if (outputValue != stacki.pop() && stack){ //stack?
                            stack = false;
                            possibleTypes--;
                            type[0] = null;
                        }
                        if(possibleTypes == 0) break; 
                        break;
                }
            }
            //Add stuff on the outputstring
            switch (possibleTypes) {
                case 0:
                    out.append("impossible \n");
                    break;
                case 1:
                    for (String t : type) {
                        if (t != null) {
                            out.append(t+"\n");
                        }
                    }
                    break;
                default:
                    out.append("not sure \n");
            }
        }
        System.out.println(out);
    }
}