import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * cprnummer
 */
public class cprnummer {
    
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        String input = sc.readLine();
        int[] factors = new int[]{4,3,2,7,6,5,0,4,3,2,1};
        int i = 0;
        while( i < input.length()){
            if(input.charAt(i) != '-')
                sum += factors[i] * Character.getNumericValue(input.charAt(i));
            i++;
        }
        System.out.println(sum % 11 == 0 ? 1 : 0);
    }
}