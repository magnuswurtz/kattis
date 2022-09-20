import java.util.Scanner;

public class NineKnights{
    String[][] board;

    public NineKnights(){
        board = new String[5][5];

        //Tager inputtet fra scanneren og udfylder brættet
        Scanner sc = new Scanner(System.in);
        int i = 0;
        Boolean stop = false;

        while (sc.hasNextLine() && !stop) {
            populateBoard(i, sc.nextLine());
            i++;
            if(i == 5){
                stop = true;
            }
        }
    }

    public void populateBoard(int index, String inputLine){ //udfylder en række af boardet
        String[] inputArray = inputLine.split("");
        board[index] = inputArray;       
    }

    public String checkConfiguration(){ //tjekker hele brættet igennem og returnerer valid eller invalid

        int count = 0; //Tæller op hver gang, der findes en knight. Der skal være præcis 9 for at et bræt er valid
        String out = "valid";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) { //Går igennem hvert felt på boardet
                if (board[i][j].equals("k")) { //hvis der står en knægt - tjek alle mulige felter i nærheden for knægte.
                    out = checkLocations(i,j);
                    count+=1;

                    if(out.equals("invalid")){ //Afslut tjekket med det samme, hvis out bliver invalid
                        return out;
                    }
                }
            }
        }
        if(count != 9){ // hvis ikke der er præcis 9 knights, er brættet invalid
            out = "invalid";
        }

        return out;
    }
    public String checkLocations(int row, int column){ //Tjekker de 8 mulige positioner, hvor der kan være k'er, som vil gøre brættet invalid. 
       
        //Rækken lige over
        if(row-1 >= 0 && column-2 >= 0){ //for at undgå index-fejl
            if(board[row-1][column-2].equals("k")){
                return "invalid";
            }   
        } 
        if(row-1 >= 0 && column+2 <= 4){
            if (board[row-1][column+2].equals("k")) {
                return "invalid"; 
            }  
        }
        //to rækker over
        if(row-2 >= 0 && column-1 >= 0){
            if (board[row-2][column-1].equals("k")) {
                return "invalid";
            } 
        } 

        if(row-2 >= 0 && column+1 <= 4){
            if (board[row-2][column+1].equals("k")) {
                return "invalid";
            }
        }

        //en række under
        if(row+1 <= 4 && column-2 >= 0){
            if (board[row+1][column-2].equals("k")) {
                return "invalid"; 
            }   
        }

        if(row+1 <= 4 && column+2 <= 4){
            if (board[row+1][column+2].equals("k")) {
                return "invalid";  
            }
        }

        //to rækker under
        if(row+2 <= 4 && column-1 >= 0){
            if (board[row+2][column-1].equals("k")) {
                return "invalid";
            } 
        } 

        if(row+2 <= 4 && column+1 <= 4){
            if (board[row+2][column+1].equals("k")) {
                return "invalid";
            } 
        } 
            return "valid";
    }

    public static void main(String[] args) {
        NineKnights nk = new NineKnights();
        System.out.println(nk.checkConfiguration());
    }
}