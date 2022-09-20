import java.util.Scanner;

/**
 * GuessTheNumber
 */
public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean correct = false;
        int guess = 500;
        int rangeHigh = 1001;
        int rangeLow = 1;
        System.out.println(guess);
        System.out.flush();

        while (!correct) {
            String feedback = sc.next();
            if(feedback.equals("lower")){
                rangeHigh = guess;
                guess = (rangeHigh+rangeLow)/2;
                System.out.println(guess);
                System.out.flush();
            }
            else if(feedback.equals("higher")){
                rangeLow = guess;
                guess = (rangeHigh+rangeLow)/2;
                System.out.println(guess);
                System.out.flush();
            }
            else if(feedback.equals("correct")){
                correct = true;
                sc.close();
            }  
        }
    }
}