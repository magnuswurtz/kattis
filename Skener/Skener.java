import java.util.Scanner;

public class Skener {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int nRows = sc.nextInt();
        sc.nextInt(); // skipper tallet, der ikke skal bruges (antallet af kolonner)
        int rowFactor = sc.nextInt();
        int colFactor = sc.nextInt();
        sc.nextLine(); // skipper resten af linjen - dvs- newline-karakteren, så næste nextLine læser den følgende linje

        for (int i = 0; i < nRows; i++) { //kører én gang for hver linje i inputtet
             String line = sc.nextLine();
            for (int j = 0; j < rowFactor; j++) { //kører det antal gange, som faktoren dikterer hver linje skal gentages. dvs. hvis linjen skal printes 2 gange, kører loopet over den samme linje 2 gange
                for (String elem : line.split("")) {
                    System.out.print(elem.repeat(colFactor)); //Printer hvert element i linjen det antal gange, som faktoren dikterer
                }
                System.out.print("\n");
            }
        }
    }
}