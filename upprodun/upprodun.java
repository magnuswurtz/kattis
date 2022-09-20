import java.util.Scanner;

/**
 * upprodun
 */
public class upprodun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] rooms = new String[sc.nextInt()];
        int teams = sc.nextInt();
        int i = 0;

        while (teams > 0) {
            rooms[i]+="*";
            i = (i+1) % rooms.length;
            teams--;
        }
        for (String room : rooms) {
            System.out.println(room.substring(4));
        }    
    }
}