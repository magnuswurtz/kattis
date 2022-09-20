import java.util.Scanner;

public class trik {
    public static void main(String[] args) {
        var in = new Scanner(System.in).nextLine();
        var inList = in.split("");
        var out = 1;

        for(String letter : inList) {
            if(letter.equals("A")){
                if(out == 1){
                    out++;
                }
                else if (out == 2){
                    out--;
                }
            }
            else if(letter.equals("B")){
                if(out == 2){
                    out++;
                }
                else if (out == 3){
                    out--;
                }
            }
            else{
                if(out == 1){
                    out = 3;
                }
                else if (out == 3){
                    out = 1;
                }
            }
        }
        System.out.println(out);
    }
}
