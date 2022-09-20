import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * addingwords
 */
public class addingwords {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> charsToNums = new HashMap<>();
        HashMap<Integer,String> numsToChars = new HashMap<>();

        while (true) {
            String line = br.readLine();
            String[] exp;
            if(line == null) break;
            else exp = line.split(" ");

            switch (exp[0]) {
                case "def":
                    numsToChars.remove(charsToNums.get(exp[1])); //Essential: Remove the old value associated with the variable from the reverse hashmap!
                    charsToNums.put(exp[1], Integer.parseInt(exp[2]));
                    numsToChars.put(Integer.parseInt(exp[2]), exp[1]);
                    break;
                case "calc":
                    String[] calculation = Arrays.copyOfRange(exp, 1,exp.length);
                    Integer result = charsToNums.get(calculation[0]);
                    if(result == null){
                        System.out.println(String.join(" ",calculation)+" unknown");
                        break;
                    }
                    for (int i = 2; i < calculation.length; i+=2) {
                        Integer number = charsToNums.get(calculation[i]);
                        if(number == null) {
                            result = 1000000000;
                            break;
                        }
                        if(calculation[i-1].equals("+")) result += number;
                        if(calculation[i-1].equals("-")) result -= number;
                    }
                    System.out.println(String.join(" ",calculation) + (numsToChars.get(result) == null ? " unknown" : " " + numsToChars.get(result)));
                    break;
                case "clear":
                    charsToNums = new HashMap<>();
                    numsToChars = new HashMap<>();
                    break;
                default:
                    break;
            }
        }
    }
    
}