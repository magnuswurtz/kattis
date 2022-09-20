import java.util.ArrayList;
import java.util.Scanner;

/**
 * AnotherBrick
 */
public class AnotherBrick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> bricks = new ArrayList<>();
        int sumOfLengths = 0;

        for(int i = 0; i<n ; i++){
            bricks.add(sc.nextInt());
            sumOfLengths+=bricks.get(i);
        }

        if (sumOfLengths < (h*w)) { // check whether there are enough bricks
            System.out.println("NO");
            return;
        }

        int bricksLength = bricks.get(0);
        int brickNumber = 0;
    
        for (int i = 0; i < h; i++) {
            boolean rowComplete = false;
            while (!rowComplete) {

                if(bricksLength == w && i!=h-1){ // i !=h-1 to make sure that if it's the last row and every brick is used then bricks.get() will not be called with an index that exceeds the ArrayList
                    rowComplete = true;
                    brickNumber++;
                    bricksLength = bricks.get(brickNumber);
                }
                else if(bricksLength == w && i==h-1){
                    rowComplete = true;
                }
                else if(bricksLength < w){
                    brickNumber++;
                    bricksLength += bricks.get(brickNumber);
                } 
                else{
                    System.out.println("NO");
                    return;
                }
            }
        }
            System.out.println("YES");    
    }
}