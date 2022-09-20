import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

//Heavily inspired by the class BipartiteX by Robert Sedgewick and Kevin Wayne in the book Algorithms Fourth Edition.

public class harmony2 {

    private boolean isHarmonious;   // is the graph harmonious?
    private boolean[] color;       // color[v] gives vertices on one side of bipartition
    private boolean[] marked;      // marked[v] = true iff v has been visited in DFS
    private Set<Integer>[] harmonyEdges; // adjacencylist for harmony-edges of the graph
    
    public harmony2(Graph G,Set<Integer>[] harmonyEdgeList) {
        isHarmonious = true;
        color  = new boolean[G.V()];
        marked = new boolean[G.V()];

        harmonyEdges = harmonyEdgeList;
        for (int v = 0; v < G.V() && isHarmonious; v++) {
            if (!marked[v]) {
                bfs(G, v);
            }
        }
    }

    private void bfs(Graph G, int s) { 
        Queue<Integer> q = new Queue<Integer>();
        color[s] = false;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    if(harmonyEdges[w] != null && harmonyEdges[w].contains(v)) color[w] = color[v]; //it's a harmony edge. Make same color
                    else color[w] = !color[v];
                    q.enqueue(w);
                }
                else if ((harmonyEdges[w] == null || !harmonyEdges[w].contains(v)) && color[w] == color[v]) { //not a harmony edge and same color
                    isHarmonious= false;
                    return;
                }
            }
        }
    }

    public boolean isHarmonious() {
        return isHarmonious;
    }

    public static void main(String[] args) throws IOException {
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
    
        Graph graph = new Graph(vertices);
        HashSet<Integer>[] harmonyEdges = new HashSet[vertices];
        
        for (int i = 0; i < edges; i++) {
            StringTokenizer t = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(t.nextToken());
            int v = Integer.parseInt(t.nextToken());
        
            if (t.nextToken().equals("0")){
                if (harmonyEdges[u] == null) {
                    harmonyEdges[u] = new HashSet<>();   
                }  
                if (harmonyEdges[v] == null) {
                    harmonyEdges[v] = new HashSet<>();   
                }  
                harmonyEdges[u].add(v);
                harmonyEdges[v].add(u);
            }
            graph.addEdge(u,v);
        }
        harmony2 harmony = new harmony2(graph,harmonyEdges);
        
        if (harmony.isHarmonious()) System.out.println("1");
        else System.out.println("0");
    }
}
