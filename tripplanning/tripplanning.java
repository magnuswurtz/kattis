import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class tripplanning {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = in.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        boolean[] connected = new boolean[N+1];
        int[] cNumber = new int[N+1];

        for(int lineNumber = 1; lineNumber <= M; lineNumber++){
            String[] numbers = in.readLine().split(" ");
            int v = Integer.parseInt(numbers[0]);
            int u = Integer.parseInt(numbers[1]);
            if(v == 1 && u == N || u == 1 && v == N){
                connected[N] = true;
                cNumber[N] = lineNumber;
            }
            if (v-u == -1){
                connected[v] = true;
                cNumber[v] = lineNumber;
            }
            else if(v-u == 1){
                connected[u] = true;
                cNumber[u] = lineNumber;
            } 
        }
        StringBuilder out = new StringBuilder();
        List<Integer> order = new ArrayList<>();
        boolean possible = true;
        for(int day = 1; day <= N && possible ; day++){
            if(connected[day]) out.append(cNumber[day] + "\n");
            else possible = false; 
        }
        if(possible) System.out.println(out);
        else System.out.println("impossible");
    }
}