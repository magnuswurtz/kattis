import java.util.ArrayList;
import java.util.Scanner;

public class LineUp{
    private ArrayList<String> names;

    public LineUp(){
        
        this.names = new ArrayList<>();
                
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < amount; i++) {
            names.add(sc.nextLine());
        }   
    }
    public boolean isIncreasing(){

        String previous = "";
        for(String name : names){
            if(name.compareTo(previous) < 0){
                return false;
            }
            previous = name;
        }
    return true;
}
    public boolean isDecreasing(){
        String previous = "zzzzzzzzzzzzzzzzzzz";
        for(String name : names){
            if(name.compareTo(previous) > 0){
                return false;
            }
            previous = name;
        }
    return true;
}

    public void determineOrder(){
        if(isDecreasing()){
            System.out.println("DECREASING");
        } 
        else if(isIncreasing()){
            System.out.println("INCREASING");
        }
        else{
            System.out.println("NEITHER");
        }
    }

    public static void main(String[] args) {
        LineUp lu = new LineUp();
        lu.determineOrder();
    }
}