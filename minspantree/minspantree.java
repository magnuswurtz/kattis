import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Not solved. Some error on test input 2 on kattis
 * minspantree
 */
public class minspantree {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] testCase = in.readLine().split(" ");
            int n = Integer.valueOf(testCase[0]);
            int m = Integer.valueOf(testCase[1]);

            if(n == 0 && m == 0) break;
            if(m == 0) {System.out.println("Impossible"); continue;};
            ArrayList<Edge>[] adj = (ArrayList<Edge>[]) new ArrayList[n];
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            PriorityQueue<Edge> mst = new PriorityQueue<>(new EdgeComparator());
            int totalWeight = 0;
            boolean[] visited = new boolean[n];
            for(int i = 0; i<n ; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] line = in.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v= Integer.parseInt(line[1]);
                int weight = Integer.parseInt(line[2]);
                adj[v].add(new Edge(v,u,weight));
                adj[u].add(new Edge(u,v,weight));
            }
            
            //Start prim's
            visited[0] = true;
            for(Edge e : adj[0])
                pq.add(e); 

            while(!pq.isEmpty()){
                Edge minEdge = pq.remove();
                int v = minEdge.either();
                int u = minEdge.other(v);
                if(visited[u]) continue;
                mst.add(minEdge);
                totalWeight += minEdge.getWeight();
                //visit u
                if(!visited[u]){
                    visited[u] = true;
                    for(Edge e : adj[u])
                        if(!visited[e.other(u)]) pq.add(e);
                } 
            }
            //If there is no msp print: Impossible
            if(mst.size() < n-1)
               System.out.println("Impossible");
            else{
                System.out.println(totalWeight);
                while(!mst.isEmpty()){
                    System.out.println(mst.remove());
                }
            }
        }
    }
    private static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(minspantree.Edge o1, minspantree.Edge o2) {
            return o1.stringName.compareTo(o2.stringName);
        }
        
    }

    private static class Edge implements Comparable<Edge> {
        private int v;
        private int u;
        private int weight;
        private String stringName;

        public Edge(int v, int u, int weight){
            this.v = v;
            this.u = u;
            this.weight = weight;
            this.stringName = v < u ? v + " " + u : u + " " + v;
        }
        public int either(){
            return v;
        }
        public int other(int v){
            if(v == this.v) return u;
            else return v;
        }
        public int getWeight(){
            return this.weight;
        }

        public String toString(){
            return v < u ? v + " " + u : u + " " + v;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.getWeight());
        }
        
    }
}