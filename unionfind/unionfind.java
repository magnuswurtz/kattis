
public class unionfind {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int m = io.getInt();
        int[] parent = new int[n];
        int[] componentSize = new int[n];

        for(int i = 0; i < n ; i++){
          parent[i] = i;
          componentSize[i] = 1;
        }
        for (int i = 0; i<m;i++) {
            String operation = io.getWord();
            int s = io.getInt();
            int t = io.getInt();
            int sRoot;
            int tRoot;
          switch (operation) {
              case "?":
                while( s!= parent[s]){
                  parent[s] = parent[parent[s]]; //path compression by halving
                  s = parent[s];
                }
                while( t!= parent[t]){
                  parent[t] = parent[parent[t]]; //path compression by halving
                  t = parent[t];
                }
                if (s == t) System.out.println("yes");
                else System.out.println("no");
                break;

              case "=":
                while( s!= parent[s]){
                  parent[s] = parent[parent[s]]; //path compression by halving
                  s = parent[s];
                }
                while( t!= parent[t]){
                  parent[t] = parent[parent[t]]; //path compression by halving
                  t = parent[t];
                }
                if(s == t) return; //If the two nodes have the same root, then they are already in the same component and nothing should happen
      
                //Attach the root of the smaller tree directly to the root of the larger 
                if(componentSize[s]< componentSize[t]){ 
                  parent[s] = t;
                  componentSize[t] += componentSize[s];
                } else{
                  parent[t] = s;
                  componentSize[s] += componentSize[t];
                }
          }             
        }
      }
    }