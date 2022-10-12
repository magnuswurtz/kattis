package bachetsgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bachetsgame {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while(line != null){
            //initialization
            String[] inputs = line.split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            boolean[] bachet = new boolean[n+1];
            List<Integer> ks = new ArrayList<>();
            for(int i = 2 ; i<m+2 ; i++){
                ks.add(Integer.parseInt(inputs[i]));
            }
            
            //real stuff
            for(int i = 1; i <= n ; i++){
                for(int num : ks){
                    if(num <= i && !bachet[i-num]){
                        bachet[i] = true; 
                        break;
                    }
                }
            }
            if(bachet[n]) System.out.println("Stan wins");
            else System.out.println("Ollie wins");

            //next iteration
            line = in.readLine();
        }
    }


}
