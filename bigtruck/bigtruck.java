import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bigtruck{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
        int[] adj = new int[n];
        int[] dist = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(n);

        for(int i = 0; i<n ; i++){

        }

    }
    private class Node implements Comparable<Node>{
        private int priority;
        private int name;
        private int items;

        public Node(int name, int items){
            this.name = name;
            this.items = items;
            this.priority = 0;
        }

        public void cP(int newP){
            this.priority = newP;
        }

        public int getP(){
            return this.priority;
        }
        public int getName(){
            return this.name;
        }

        @Override
        public int compareTo(Node that) {
            if(this.getP() < that.getP()) return -1;
            else if(this.getP() > that.getP()) return 1;
            return 0;
        }

    }
}