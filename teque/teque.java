import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * teque
 */
public class teque {

    public static void main(String[] args) throws IOException {    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        String[] front = new String[N];
        String[] back = new String[N]; 

        int frontSize = 0;
        int backSize = 0;
        int frontHead = N/2;
        int backHead = N/2;

        for(int i = 0 ; i<N ; i++){
            String[] operation = in.readLine().split(" ");
            if(operation[0].equals("push_back")) {
                if(frontSize==backSize){
                    back[backHead+backSize] = operation[1];
                    front[frontHead+frontSize] = back[backHead++];
                    frontSize++;
                }else{
                    back[backHead+backSize] = operation[1];
                    backSize++;
                }
            }    
            else if(operation[0].equals("push_front")){
                if(frontSize==backSize){
                    front[--frontHead] = operation[1];
                    frontSize++;
                }else{
                    back[backHead+backSize] = front[frontHead+frontSize];
                    backSize++;
                }
            } 
            else if(operation[0].equals("push_middle")){
                if(frontSize==backSize){
                    front[frontHead+frontSize] = operation[1];
                    frontSize++;
                }else{
                    back[--backHead] = operation[1];
                    backSize++;
                }
            } 
            else{//get logic
                int index = Integer.parseInt(operation[1]);
                if(index >= frontSize) System.out.println(back[backHead+backSize-index]);
                else System.out.println(front[frontHead+index]);
            }
        }
    }
}
