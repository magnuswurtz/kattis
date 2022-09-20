import java.util.Scanner;

/**
 * Spavanac
 */
public class Spavanac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        int minutes = sc.nextInt();

        if (minutes < 45) {
            hours = hours == 0 ? 23 : hours-1;
        }
        minutes = (minutes+15) % 60; 

        // String minutesString = minutes<10 ? "0"+minutes : String.valueOf(minutes);
        System.out.println(hours + " " + minutes);
    }
}