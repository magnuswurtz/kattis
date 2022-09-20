import java.util.ArrayList;
import java.util.Scanner;
/**
 * SeatAllocation
 */
public class SeatAllocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nParties = sc.nextInt();
        int mSeats = sc.nextInt();
        ArrayList<Integer> votes = new ArrayList<>();
        ArrayList<Double> quotients = new ArrayList<>();
        ArrayList<Integer> seats = new ArrayList<>();

        for (int i = 0; i < nParties; i++) {
            Integer vote = sc.nextInt();
            seats.add(0);
            votes.add(vote);
            quotients.add((double) vote/1);   
        }
        while (mSeats>0) {
            int indexOfHighest = 0;
            Double highest = quotients.get(0);

            //Find highest quotient
            for (int i = 1; i < quotients.size(); i++) {
                if(quotients.get(i)>highest){
                    indexOfHighest = i;
                    highest = quotients.get(i);
                }
            }
            //Add a seat to the party with the highest quotient
            seats.set(indexOfHighest,seats.get(indexOfHighest)+1);
            
            //Recalculate this party's quotient
            quotients.set(indexOfHighest,(double) votes.get(indexOfHighest)/(seats.get(indexOfHighest)+1));
            
            //count down remaining seats
            mSeats--;
        }
        //print seats
        seats.forEach(seat -> System.out.println(seat));
    }
}