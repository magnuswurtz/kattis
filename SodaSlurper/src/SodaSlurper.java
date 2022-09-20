import java.util.Scanner;

public class SodaSlurper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        var emptyBottles = in.nextInt()+in.nextInt();
        var costOfNew = in.nextInt();
        var howMany = 0;

        while(emptyBottles>=costOfNew){
            howMany += emptyBottles/costOfNew;
            emptyBottles = emptyBottles/costOfNew + (emptyBottles%costOfNew);
        }
        System.out.println(howMany);
    }
}
