import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import edu.princeton.cs.algs4.BipartiteX;
import edu.princeton.cs.algs4.Graph;

public class harmony {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        edu.princeton.cs.algs4.
        Graph conflictGraph = new Graph(vertices);
        LinkedList<int[]> harmonyEdges = new LinkedList<>();
    
        //Read input:
            //Make a graph out of all conflict edges
            //Save all harmony edges for later checks
        for (int i = 0; i < edges; i++) {
            String[] line = in.readLine().split(" ");

            if (line[2].equals("1")){
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                conflictGraph.addEdge(u,v);
                //System.out.println(u + " " + v + " Conflict");
            }
            else{
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);
                harmonyEdges.add(new int[]{u,v}); 
                //System.out.println(u + " " + v + " Harmony"); 
            }  
        }
        //Check bipartiteness
        BipartiteX biPart = new BipartiteX(conflictGraph);
        
        //If this graph is not bipartite, print 0
        if (!biPart.isBipartite()) {
            System.out.println("0");
            return;
        }
        //If it is bipartite, check for each harmony edge if the endpoints have the same colour.
        else { 
            for (int[] edge : harmonyEdges) {
                //If they don't, output 0
                if (!(biPart.color(edge[0]) == biPart.color(edge[1]))) {
                    System.out.println("0");
                    return;
                }
            }    
        }
        //If they do, continue untill all edges have been processed, output 1 if they have
        System.out.println("1");
            //Problem: If one endpoint of a harmony edge is not present as an edge point of a conflict edge
    }
}