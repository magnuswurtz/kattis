import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class infection {

    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of elements in subtree rooted at i
    private char[] value;
    private int humanIndex;
    private int virusIndex;
    private int R;
    private int C;

    public infection() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] st = in.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        parent = new int[R*C];   // parent[i] = parent of i
        size = new int[R*C];     // size[i] = number of elements in subtree rooted at i
        value = new char[R*C];    // value[i] = the value of i, indicating if its water, land, human or virus

        // read input into an array. Two dimensional grid is turned into one dimension with indices 0-(R*C-1)
        int index = 0;
        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            for (int j = 0; j < C; j++) {
                parent[index] = index;
                size[index] = 1;
                char val = line.charAt(j);
                value[index] = val;
                if (val == '2') virusIndex = index;
                else if (val == '3') humanIndex = index;
                index++;
            }
        }
    }
    static boolean isWater(char val){
        return val == '0';
    }
    public int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
    public static void main(String[] args) throws IOException {
        infection island = new infection();
    // Union each node with it's neighbour to the right and down if they're both land, virus or human 
    for (int i = 0; i < island.value.length; i++) {
        if (isWater(island.value[i])) continue;
        
        //If the neighbour is not water and not out of bounds, union the two
        if ((i + 1) % island.C != 0 && !isWater(island.value[i+1])) island.union(i, i+1);
    
        //If the node straight down is in bounds and is not water, union the two
        if((i + island.C) < island.value.length && !isWater(island.value[i+island.C])) island.union(i, i+island.C);  
    }
    // If virus and human belong to the same component output 1, else 0 
    if (island.find(island.humanIndex) == island.find(island.virusIndex)) System.out.println(1);
    else System.out.println(0);
    }
}
