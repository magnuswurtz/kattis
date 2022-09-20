import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class guessing {
    private int high = 11;
    private int low = -1;

    public void reset(){
        high = 11;
        low = -1;
    }
    public static void main(String[] args) throws IOException { 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        guessing guesser = new guessing();
        int guess;
       
        while (!(0 == (guess = Integer.parseInt(in.readLine())))) {
            String judgement = in.readLine();
            switch (judgement){
                case "too high":
                    guesser.high = Math.min(guess,guesser.high); //minimum af den højeste og gættet. For at sikre at hvis gættet er højere end det tidligere max, så sættes max ikke op igen.
                    break;

                case "too low":
                    guesser.low = Math.max(guess,guesser.low); //tilsvarende ovenover. Bare omvendt. 
                    break;

                case "right on":   
                    if (guess<guesser.high && guess > guesser.low) System.out.println("Stan may be honest");
                    else System.out.println("Stan is dishonest");
                    guesser.reset();
                    break;
            }
        }
    }
}