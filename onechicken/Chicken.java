import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chicken {
    public static void main(String[] args) throws IOException {
        String[] in = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int leftover = n-m;
        String out="";
        if (leftover > 1) out = "Dr. Chaz needs "+ leftover + " more pieces of chicken!";
        else if (leftover == 1) out = "Dr. Chaz needs 1 more piece of chicken!";
        else if (leftover == -1) out = "Dr. Chaz will have 1 piece of chicken left over!";
        else out = "Dr. Chaz will have "+ (leftover*-1) + " pieces of chicken left over!";

        System.out.println(out);
    }

}