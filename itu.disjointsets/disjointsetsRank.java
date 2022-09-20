import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//This second version is the version that should solve test cases 2 and 4. Providing implementation for move operation
//This is an implementation of weighted quick-union as described in W&S 1.5 p. 228 plus a method for the move operation
//Use of parent and componentSize arrays and the methods find and union is more or less a direct reflection of the weighted quick-union implementation in S&W page 228 

public class disjointsetsRank {
    private int[] parent;
    private int[] rank;

    public disjointsetsRank(int n){
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i = 0; i< n ; i++){
          parent[i] = i;
          rank[i] = 0;
        }
    }
    public int find(int s){ //find and return the root of the tree in which s belong
      while( s!= parent[s]) s = parent[parent[s]]; //path compression by halving
      return s;
    }

    public void union(int s, int t){
      int rootS = find(s);
      int rootT = find(t);

      if(rootS == rootT) return; //If the two nodes have the same root, then they are already in the same component and nothing should happen 
 
      if(rank[rootS]<rank[rootT]) parent[rootS] = rootT;//Attach the root of the smaller tree directly to the root of the larger 
      else if(rank[rootS]>rank[rootT]) parent[rootT] = rootS;
      else{
        parent[rootT] = rootS;
        rank[rootS]++;
      }
    }
    public void move(int s, int t){
      int rootS = find(s);
      int rootT = find(t);
      
      parent[s] = rootT;//move s to set T

      if(rootS == rootT) return;//if s and t have the same root return

      else if(s == rootS){// if s is the root of a tree
        boolean first = true;
        int newRoot = 0;
        for(int i = 0; i < parent.length ; i++){
          if (parent[i] == s) { //first matching child is set as new root
            if (first) {
              newRoot = i;
              first = false;
            }
            parent[i] = newRoot;
          }
        }
      }
      else{  // s is not the root 
        for(int i = 0; i < parent.length ; i++){
          if (parent[i] == s) { //all children of s changes parents
            parent[i] = rootS;
          }
        }
      }
    }

    public static void main(String[] args){
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        disjointsetsRank ds = new disjointsetsRank(n);
        for (int i = 0; i<m;i++) {
            int operation = StdIn.readInt();
            int s = StdIn.readInt();
            int t = StdIn.readInt();
 
          switch (operation) {
              case 0:
                if (ds.find(s) == ds.find(t)) StdOut.println("1");
                else StdOut.println("0");
                break;
              case 1:
                ds.union(s, t);
                break;
              case 2:
                ds.move(s, t);
                break;
          }
        }
    }
}
