import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/**
 * Lost
 */
public class Lost {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int howMany = sc.nextInt();
        Map<Integer,Integer> lineNumberToPerson = new TreeMap<>();
        
        for (int i = 2; i <= howMany; i++) {
            lineNumberToPerson.put(sc.nextInt()+1, i);
        }
        System.out.print("1 ");
        lineNumberToPerson.forEach((k,v) -> System.out.print(lineNumberToPerson.get(k)+ " "));
    }
}