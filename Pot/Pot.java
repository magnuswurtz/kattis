import java.util.Scanner;
import java.lang.Math;

/**
 * Pot
 */
public class Pot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int count = 0;
        int result = 0;   

        while(count < max){
            String number = sc.next();
            double base = Double.parseDouble(number.substring(0, number.length()-1));
            double exponent = Double.parseDouble(number.substring(number.length()-1));
            double correctNumber = Math.pow(base, exponent);
            result += correctNumber;
            count++;
        }
        System.out.println(result);
    }
}
