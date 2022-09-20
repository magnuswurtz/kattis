
import java.util.HashMap;
import java.util.Scanner;

public class cetvrta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer,Integer> x = new HashMap<>();
        HashMap<Integer,Integer> y = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int xx = sc.nextInt();
            int yy = sc.nextInt();

            if(x.containsKey(xx)){
                x.put(xx, 2);                
            } else{
                x.put(xx, 1);
            }
            if(y.containsKey(yy)){
                y.put(yy, 2);                
            } else{
                y.put(yy, 1);
            }
        }
        x.forEach((k,v) -> {
            if(v.equals(1)){System.out.print(k+" ");};
        });
        y.forEach((k,v) -> {
            if(v.equals(1)){System.out.println(k);};
        });
    }
}