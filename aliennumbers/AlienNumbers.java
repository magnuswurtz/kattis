import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.Source;

/**
 * AlienNumbers
 */
public class AlienNumbers {
    private String aNumber;
    private String source;
    private String target;
    private Map<String,String> SourceToTarget;

    public AlienNumbers(String aNumber, String source, String target){
        this.aNumber = aNumber;
        this.source = source;
        this.target = target;
        this.SourceToTarget = new LinkedHashMap<>();

        for (int i = 0; i < source.length(); i++) {
            this.SourceToTarget.put(source.substring(i, i+1),"");   
        }
        setTargetInDictionary();
    }
    private void setTargetInDictionary(){
            for (String cipher : SourceToTarget.keySet()) {
                SourceToTarget.put(cipher, );
            }
        
    }
    public String translate(){
        String translatedNumber = "";
        return translatedNumber;
    }
    public void display(int i){
        System.out.println("Case #"+i+":");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            AlienNumbers AN = new AlienNumbers(sc.next(), sc.next(),sc.next());   
        }      
    }
}