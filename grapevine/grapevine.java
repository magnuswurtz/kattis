import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class grapevine {
        private int dist;
        private int skepticism;
        private List<String> adj;
        private boolean spreading;
        private boolean heard;

        public grapevine(int skepticism){ //a person object
            this.dist = 0;
            this.skepticism = skepticism;
            this.adj = new LinkedList<>();
            this.spreading = false;
            this.heard = false; 
        }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int numPeople = Integer.parseInt(line[0]);
        int connections = Integer.parseInt(line[1]);
        int days = Integer.parseInt(line[2]);
        int persons = 0;
        Queue<String> bfsQ = new LinkedList<>(); 
        HashMap<String,grapevine> g = new HashMap<>(); //graph of people

        //read in people
        for (int i = 0; i < numPeople; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String name = st.nextToken();
            g.put(name, new grapevine(Integer.parseInt(st.nextToken())));
        }
        // populate adj
        for (int i = 0; i < connections; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();
            g.get(p1).adj.add(p2);
            g.get(p2).adj.add(p1);
        }

        String first = in.readLine();
        bfsQ.add(first); //add starting node to queue
        grapevine f = g.get(first);
        f.spreading = true;
        f.heard = true;

        while (!bfsQ.isEmpty()) { //run bfs
            String person = bfsQ.remove();
            if(g.get(person).dist>=days) break;
            
            for (String neighbour : g.get(person).adj) {
                grapevine pers = g.get(neighbour);
                pers.skepticism--;//decrement skepticism by 1 when a person is told
                if(!pers.heard){ //if the person hasn't heard before
                    persons++;
                    pers.heard = true;
                }
                if(pers.skepticism <= 0 && !pers.spreading) { //If the person is now convinced and is not spreading already, the person is added to the spreader queue
                    pers.dist = g.get(person).dist+1;
                    pers.spreading = true;
                    bfsQ.add(neighbour); 
                }
            }      
        }
        System.out.println(persons); //Print number of persons that have heard the rumour
    }    
}       
