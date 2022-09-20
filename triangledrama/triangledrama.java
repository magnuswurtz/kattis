import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * triangledrama
 */
public class triangledrama {
    public static void dfs(){

    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] people = new int[n*n];
        for(int i = 0 ; i < n ; i++){
            String[] line = in.readLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                people[i*n+j] = Integer.parseInt(line[j]);
            }
        }
        
        for (int i = 0; i < n; i++) {
           for (int j = 1; j < n; j++) {
                for (int k = 2; k < n; k++) {
                    
                }
           } 
        }
    }
}