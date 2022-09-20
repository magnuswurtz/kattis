import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * bluetooth
 */
public class bluetooth {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int leftUpper = 8;
        int leftLower = 8;
        int rightUpper = 8;
        int rightLower = 8;

        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split("");
            if(line[0].equals("-")){ //lowerLeft
                if (line[3].equals("b")){
                    leftLower = 0;
                    leftUpper = 0;
                }
                else leftLower--;
            }
            else if(line[0].equals("+")) { //upperleft
                if(line[3].equals("b")){
                    leftLower = 0;
                    leftUpper = 0;
                } 
                else leftUpper--;
            }
            else if(line[1].equals("-")){ //lower right
                if(line[3].equals("b")){
                    rightLower = 0;
                    rightUpper = 0;
                }else rightLower--;
            }
            else{//upper right
                if(line[3].equals("b")){
                    rightLower = 0;
                    rightUpper = 0;
                } else rightUpper--;
            }; 
        }
        if (leftUpper > 0 && leftLower > 0) System.out.println(0);
        else if (rightUpper > 0 && rightLower > 0) System.out.println(1);
        else System.out.println(2);

    }
}