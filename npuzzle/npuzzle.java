import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class npuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[][] input = new String[4][4];
        Map<String,pair> mapping = new HashMap<>();
        int diff = 0;
        mapping.put("A", new pair(0,0));
        mapping.put("B", new pair(0,1));
        mapping.put("C", new pair(0,2));
        mapping.put("D", new pair(0,3));
        mapping.put("E", new pair(1,0));
        mapping.put("F", new pair(1,1));
        mapping.put("G", new pair(1,2));
        mapping.put("H", new pair(1,3));
        mapping.put("I", new pair(2,0));
        mapping.put("J", new pair(2,1));
        mapping.put("K", new pair(2,2));
        mapping.put("L", new pair(2,3));
        mapping.put("M", new pair(3,0));
        mapping.put("N", new pair(3,1));
        mapping.put("O", new pair(3,2));
        mapping.put(".", new pair(3,3));

        for(int i = 0 ; i<4 ; i++){
            input[i] = in.readLine().split("");
        }
        for(int i = 0 ; i< 4 ; i++){
            for(int j = 0 ; j<4 ; j++){
                if(input[i][j].equals(".")) continue;
                int localDiff = mapping.get(input[i][j]).getDif(i, j); 
                diff+= localDiff;
            }
        }
        System.out.println(diff);
    }
    
    private static class pair{
        private int i;
        private int j;

        public pair(int i, int j){
            this.i = i;
            this.j = j;
        }
        public int getDif(int realI, int realJ){
            return Math.abs(i-realI) + Math.abs(j-realJ); 
        }
    }
}
