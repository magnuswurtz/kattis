import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * textureanalysis
 */
public class textureanalysis {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine().strip();
        int num = 1;
        while(!line.equals("END")){
            int gaps = line.indexOf("*", 1);

            
            String[] line2 = line.split("");
            boolean even = true;
            if(gaps == -1){
                System.out.println(num + " EVEN");
                line = in.readLine().strip();
                num++;
                continue;
            }
            for (int i = 1; i < line2.length; i++) {
                if((i % gaps == 0 && !line2[i].equals("*")) || (i % gaps != 0 && !line2[i].equals(".")) ){
                    even = false;
                    break;
                }
            }
            if(even){ System.out.println(num+" EVEN");}
            else { System.out.println(num+" NOT EVEN");}
            line = in.readLine().strip();
            num++;
        }
    }
}