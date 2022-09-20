import java.util.Scanner;

/**
 * Faktor
 */
public class Faktor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int nArticles = sc.nextInt();
        int impactFactor = sc.nextInt();
        int nScientists = nArticles * (impactFactor-1)+1;

        System.out.println(nScientists);
    }
}