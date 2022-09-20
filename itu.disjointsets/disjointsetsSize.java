
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//This second version is the version that should solve test cases 2 and 4. Providing implementation for move operation
//This is an implementation of weighted quick-union as described in W&S 1.5 p. 228 plus a method for the move operation
//Use of parent and componentSize arrays and the methods find and union is more or less a direct reflection of the weighted quick-union implementation in S&W page 228 

public class disjointsetsSize {
    private int[] parent;
    private int[] componentSize;

    public disjointsetsSize(int n){
        this.parent = new int[n];
        this.componentSize = new int[n];

        for(int i = 0; i< n ; i++){
          parent[i] = i;
          componentSize[i] = 1;
        }
    }
    public int find(int s){ //find and return the root of the tree in which s belong
      while( s!= parent[s]){
        s = parent[s];
      }
      return s;
    }
    public void union(int s, int t){
      int rootS = find(s);
      int rootT = find(t);

      if(rootS == rootT) return; //If the two nodes have the same root, then they are already in the same component and nothing should happen
      
      //Attach the root of the smaller tree directly to the root of the larger 
      if(componentSize[rootS]< componentSize[rootT]){ 
        parent[rootS] = rootT;
        componentSize[rootT] += componentSize[rootS];
      } else{
        parent[rootT] = rootS;
        componentSize[rootS] += componentSize[rootT];
      }
    }
    public void move(int s, int t){
      int rootS = find(s);
      int rootT = find(t);

      parent[s] = rootT;
      //if s and t have the same root return
      if(rootS == rootT) return; 
      
      if(componentSize[s] == 1){ //if s has no children 
        componentSize[rootS] -= 1;//size of the root of s is reduced by 1
        componentSize[rootT] += 1; //size of the root of t is incremented by 1
      return;
      }
      else if(s == rootS){ // else if s is the root of a tree
        boolean first = true;
        int newRoot = 0;
        for(int i = 0; i < parent.length ; i++){
          if (first && parent[i] == s) { //first matching child is set as new root
            newRoot = i;
            parent[i] = i;
            first = false;
          }
          else if (parent[i] == s) { //all the rest have the new root as parent
            parent[i] = newRoot;
          }
        }
        componentSize[newRoot] = componentSize[s]-1;
        componentSize[s] = 1; //s now only has itself as child
        componentSize[rootT] ++; //the root of t has one more childElement

      } else{  // else if s is not the root (but does have children)
        for(int i = 0; i < parent.length ; i++){
          if (parent[i] == s) { //all children of s changes parents
            parent[i] = rootS;
          }
        }
        componentSize[rootS]--;
        componentSize[rootT]++;
        componentSize[s] = 1;
      }
    }

    public static void main(String[] args){
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        disjointsetsSize ds = new disjointsetsSize(n);
        
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