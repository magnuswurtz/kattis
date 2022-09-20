import java.util.ArrayList;
import java.util.Scanner;

/**
 * Booking
 */
public class Booking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nRooms = sc.nextInt();
        int roomsTaken = sc.nextInt();

        if (!(nRooms == roomsTaken)){
            ArrayList<Integer> takenRooms = new ArrayList<>();
                int tryInt = 1;
                boolean done = false;
              
                for (int i = 0; i < roomsTaken; i++) {
                    takenRooms.add(sc.nextInt());
                }
                while (!done) {
                    if (!takenRooms.contains(tryInt)){
                        System.out.println(tryInt);
                        done = true;
                    } else{
                        tryInt++;
                    }    
                }    
        }
        else {
            System.out.println("too late");
        }
    }
}