package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bank {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int T = Integer.parseInt(line[1]);
        Costumer[] costumers = new Costumer[N];
        int[] cash = new int[T];
        //read in costumers
        for(int i = 0 ; i<N ; i++){
            String[] inp = in.readLine().split(" ");
            costumers[i] = new Costumer(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
        }

        Arrays.sort(costumers); //sort by money
        for (Costumer p : costumers) {
            for(int i = p.time ; i>=0 ; i--){
                if(p.cash > cash[i]){
                    cash[i] = p.cash;
                    break;  
                } 
            }
        }
        System.out.println(Arrays.stream(cash).sum());
    }
    private static class Costumer implements Comparable<Costumer>{
        private int cash;
        private int time;

        public Costumer(int cash, int time){
            this.cash = cash;
            this.time = time;
        }

        @Override
        public int compareTo(Costumer that) {
            if(this.cash > that.cash) return -1;
            if(this.cash < that.cash) return 1;
            return 0;
        }
    }
}
