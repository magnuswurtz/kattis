import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * shortestpath2
 */
public class shortestpath2 {

   public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), q = Integer.parseInt(line[2]) , s = Integer.parseInt(line[3]);
            if(n == 0 && m == 0 && q == 0 && s == 0) break;

            List<Edge>[] adj = (ArrayList<Edge>[]) new ArrayList[n];
            for(int i = 0 ; i< adj.length ; i++) 
                adj[i] = new ArrayList<>();

            //read in edges            
            for (int i = 0; i < m; i++) {                
                String[] line2 = in.readLine().split(" ");
                int u = Integer.parseInt(line2[0]), v = Integer.parseInt(line2[1]), t0 = Integer.parseInt(line2[2]), P = Integer.parseInt(line2[3]), w = Integer.parseInt(line2[4]);
                adj[u].add(new Edge(u, v, t0, P, w));
            }
            //perform dijkstra
            int[] result = Dijkstra(adj,s);

            //queries
            for(int i = 0 ; i < q ; i++){
                int qq = Integer.parseInt(in.readLine());
                if(result[qq] == Integer.MAX_VALUE) System.out.println("Impossible");
                else System.out.println(result[qq]); 
            }

       }

    } 

public static int[] Dijkstra(List<Edge>[] adj,int s){
    int[] distTo = new int[adj.length];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for(int i = 0 ; i < distTo.length ; i++)
        distTo[i] = Integer.MAX_VALUE;
    
    distTo[s] = 0;
    pq.add(new Node(s,0));

    while(!pq.isEmpty()){
        Node least = pq.remove();
        int dist = least.priority;
        int node = least.node;
        for(Edge e : adj[node]){
            int posDist = e.getWeight(dist);
            if(posDist < distTo[e.to]){
                distTo[e.to] = posDist;
                pq.add(new Node(e.to,posDist));
            }
        }
    }
    
    return distTo;
}
static class Node implements Comparable<Node>{
    int node;
    int priority;
    public Node(int node, int priority){
        this.node = node;
        this.priority = priority;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.priority, o.priority);
    }
}
static class Edge {
    int from;
    int to;
    int t0;
    int P;
    int w;

    public Edge(int from, int to, int t0, int P, int w){
        this.from = from;
        this.to = to;
        this.t0 = t0;
        this.P = P;
        this.w = w;
    }

    public int getWeight(int time){
        int next = t0;
        if (P == 0 && next < time) return Integer.MAX_VALUE;
        
        while(next < time){ //THIS SHIT SHOULD BE OPTIMIZED!
            next += P;
        }
        return (next - time) + time + w;
    }
}
}