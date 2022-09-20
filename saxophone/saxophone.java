import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * saxophone
 */
public class saxophone {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        Map<Character,boolean[]> noteToFingers = new HashMap<Character,boolean[]>(){{
            put('c', new boolean[]{false,true,true,true,false,false,true,true,true,true});
            put('d', new boolean[]{false,true,true,true,false,false,true,true,true,false});
            put('e', new boolean[]{false,true,true,true,false,false,true,true,false,false});
            put('f', new boolean[]{false,true,true,true,false,false,true,false,false,false});
            put('g', new boolean[]{false,true,true,true,false,false,false,false,false,false});
            put('a', new boolean[]{false,true,true,false,false,false,false,false,false,false});
            put('b', new boolean[]{false,true,false,false,false,false,false,false,false,false});
            put('C', new boolean[]{false,false,true,false,false,false,false,false,false,false});

            put('D', new boolean[]{true,true,true,true,false,false,true,true,true,false});
            put('E', new boolean[]{true,true,true,true,false,false,true,true,false,false});
            put('F', new boolean[]{true,true,true,true,false,false,true,false,false,false});
            put('G', new boolean[]{true,true,true,true,false,false,false,false,false,false});
            put('A', new boolean[]{true,true,true,false,false,false,false,false,false,false});
            put('B', new boolean[]{true,true,false,false,false,false,false,false,false,false});
        }};

        for(int i = 0; i < t; i++){
            int[] presses = new int[10];
            char[] line = in.readLine().toCharArray();
            //boolean[] pressed = new boolean[10];
            boolean[] alreadyPressed = new boolean[10];
            for(int j = 0; j < line.length; j++){
                char note = line[j];
                boolean[] fingers = noteToFingers.get(note);
                for(int k = 0; k < fingers.length; k++){
                    if(fingers[k] && !alreadyPressed[k]){
                        presses[k]++;
                    }
                }
                alreadyPressed = fingers;
            }
            for(int press : presses){
                System.out.print(press + " ");
            }
            System.out.println();
        }
    }
}