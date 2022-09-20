import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Accounting{
    Map<Integer,Integer> accountMap;

    public Accounting(int i){
        accountMap = new HashMap<>();

        for (int j = 1; j <= i; j++) {
            accountMap.put(j, 0);
        }

    }
    public void set(int person, int value){
       accountMap.replace(person, value);
    }
    public void restart(int value){
        for(int elem : accountMap.keySet()){
            accountMap.replace(elem, value);
        }
    }
    public void print(int person){
        System.out.println(accountMap.get(person));
    }

    public void parseInput(String line){
        List<String> lineAL = Arrays.asList(line.split(" "));
         
        if(line.startsWith("RESTART")){
            this.restart(Integer.parseInt(lineAL.get(1)));
        } 

        else if(line.startsWith("SET")){
            this.set(Integer.parseInt(lineAL.get(1)),Integer.parseInt(lineAL.get(2)));
        }

        else if(line.startsWith("PRINT")){
            this.print(Integer.parseInt(lineAL.get(1)));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Accounting aa = new Accounting(sc.nextInt());
        int numLines = sc.nextInt();

        while(numLines >= 0){
            aa.parseInput(sc.nextLine());
            numLines--;
        }
    }
}