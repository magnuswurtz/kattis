import java.util.Scanner;

public class Howl{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String howl = sc.nextLine();
        String winnerHowl = howl;

        switch (winnerHowl.substring(winnerHowl.length()-1)) {
            case "H":
                winnerHowl+="OOO";
                break;
            case "W":
                winnerHowl+="HOOW";
                break;
            case "O":
                winnerHowl+="OOO";
                break;
        }
        System.out.println(winnerHowl);
    }
}