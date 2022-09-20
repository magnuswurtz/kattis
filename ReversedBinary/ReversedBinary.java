import java.util.Scanner;

/**
 * ReversedBinary
 */
public class ReversedBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nu = sc.nextInt();
        String binaryNu = Integer.toBinaryString(nu);
        String reversed = reverse(binaryNu);
        int out = Integer.parseInt(reversed, 2);
        System.out.println(out);
    }
    public static String reverse(String number){
        String[] str = number.split("");
        String reverse = "";

        for (int i = str.length-1; i >= 0; i--) {
            reverse += str[i];   
        }
        return reverse;
    }
}