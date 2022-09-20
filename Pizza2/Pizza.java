import java.util.Scanner;

/**
 * Pizza
 */
public class Pizza {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double R = sc.nextInt();
        double C = sc.nextInt();
        double pArea = (R*R)*Math.PI;
        double innerArea = ((R-C)*(R-C))*Math.PI;
        double pctInner = (innerArea/pArea)*100;

        System.out.println(pctInner);
    }
}