import java.util.Scanner;

public class Filip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = {sc.nextInt(),sc.nextInt()};
      
        for(int i = 0 ; i<2 ; i++){
            int first = input[i]%10;
            int second = (input[i]/10)%10;
            int third = input[i]/100;

            input[i] = first*100 + (second*10) + third;
        }
        int out = input[0]>input[1] ? input[0] : input[1];

        System.out.println(out);
    }
}