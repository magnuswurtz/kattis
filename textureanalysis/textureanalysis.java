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
            StringBuilder out = new StringBuilder();
            if(gaps == -1){
                out.append(num).append(" EVEN");
                line = in.readLine().strip();
                num++;
                System.out.println(out);
                continue;
            }
            for (int i = 1; i < line2.length; i++) {
                if((i % gaps == 0 && !line2[i].equals("*")) || (i % gaps != 0 && !line2[i].equals(".")) ){
                    even = false;
                    break;
                }
            }
            if(even){ out.append(num).append(" EVEN");}
            else { out.append(num).append(" NOT EVEN");}
            line = in.readLine().strip();
            num++;
            System.out.println(out);
        }
    }
}