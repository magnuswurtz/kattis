import java.util.Scanner;
import java.lang.Math;

public class Thanos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numLine = sc.nextInt();

        for (int i = 0; i < numLine; i++) {

            int population = sc.nextInt();
            int growthRatio = sc.nextInt();
            int annFoodProd = sc.nextInt();

    
            double yearsleft = Math.log(annFoodProd / population) / Math.log(growthRatio);
            int k = (int) yearsleft;

            // while (population < annFoodProd) {
            //     if(population *growthRatio <= annFoodProd){
            //         population *=growthRatio;
            //         yearsleft++;   
            //     } else{
            //         break;
            //     }
            // }
        
            System.out.println(k);
        }   
    }
}