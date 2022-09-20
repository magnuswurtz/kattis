import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class speed {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        while (n != -1) {
            String[][] data = new String[n][2];
            for (int i = 0 ; i < n; i++){
                data[i] = in.readLine().split(" ");
            }
            int former = 0;
            int out = 0;

            for(String[] kk : data){
                out += Integer.parseInt(kk[0])*(Integer.parseInt(kk[1])-former);
                former = Integer.parseInt(kk[1]);
            }
            System.out.println(out + " miles");
            n = Integer.parseInt(in.readLine());
        }
    }
}