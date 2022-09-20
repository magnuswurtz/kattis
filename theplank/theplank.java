import java.util.Scanner;

/**
 * theplank
 */
public class theplank {
    public static int plank(int n){
        if(n < 0)
            return 0;
        else if( n == 0)
            return 1;
        return plank(n-1)+plank(n-2)+plank(n-3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(plank(sc.nextInt()));
    }
}