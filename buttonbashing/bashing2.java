import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class bashing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int testCases = Integer.parseInt(line);

        while (testCases > 0) {

            //Read input for each test case
            String[] nt = in.readLine().split(" ");
            int nButtons = Integer.parseInt(nt[0]);
            int time = Integer.parseInt(nt[1]);
        
            int[] buttons = new int[nButtons];
            String[] but = in.readLine().split(" ");

            for (int i = 0; i < nButtons; i++) {
                buttons[i] = Integer.parseInt(but[i]);
            }
            //create arrays for bfs
            boolean[] visited = new boolean[3601];
            int[] distTo = new int[3601];

            //create queue and add starting node 0
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            visited[0] = true;
            //bfs
            while (!q.isEmpty()) {
                int v = q.remove();
                for (int i = 0; i < nButtons; i++) {
                    int w = v+buttons[i];
                    if( w <= 0) continue;
                    if( w > 3600) w = 3600;
                    if(!visited[w]){
                        visited[w] = true;
                        distTo[w] = distTo[v] + 1;
                        q.add(w);
                    }    
                }
                if(visited[time]){ //Finish bfs and print output if the time-node is visited
                    System.out.println(distTo[time] + " 0"); break;
                }
            }
            //print output if the timenode has not been visited
            if (!visited[time]) {
                int x = time;
                while (!visited[x]) {
                    x++;
                }
                System.out.println(distTo[x] + " " + (x-time));
            }

            testCases--;
        }
    }
}
