import java.util.Scanner;

public class Tri {

    public static String whichOperation(int one, int two, int three){
        if(one == two + three){
          return one+"="+two+"+"+three;  
        }
        if(one == two - three){
            return one+"="+two+"-"+three;  
          }
        if(one == two / three){
            return one+"="+two+"/"+three;  
        }
        if(one == two * three){
            return one+"="+two+"*"+three;  
        }
        
        if(one + two == three){
            return one+"+"+two+"="+three;  
        }
        if(one - two == three){
              return one+"-"+two+"="+three;  
        }
        if(one / two == three){
            return one+"/"+two+"="+three;  
        }
        else{
              return one+"*"+two+"="+three;  
        } 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();
        System.out.println(whichOperation(first, second, third));
    }
}