import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * skolavslutningen
 */
public class skolavslutningen {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));        
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int[][] rows = new int[n][m];
        int[] unions = new int[k];

        //read input
        for (int i = 0; i < n; i++) {
            String row = in.readLine();
            for (int j = 0; j < m; j++) {
                int val = Integer.valueOf(row.charAt(j)-65);
                rows[i][j] = val;
                unions[val] = val;
            }
        }
        //union all classes
        for (int j = 0; j<m; j++) {
            for (int i = 1; i < n; i++) {
               unions[rows[i][j]] = unions[rows[i-1][j]];
            }
        }
        System.out.println(IntStream.of(unions).boxed().collect(Collectors.toSet()).size());
    }
}