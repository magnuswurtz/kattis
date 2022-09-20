import java.util.Scanner;

/**
 * BabyBites
 */
public class BabyBites {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String nl = sc.nextLine(); //new line
        String[] line = sc.nextLine().split(" ");
        boolean makesSense = true;
        for(int i = 0; i<n ; i++){
            if(line[i].equals("mumble"))
                continue;
            else if(Integer.parseInt(line[i]) != i+1)
                makesSense = false;
            }
        System.out.println(makesSense ? "makes sense" : "something is fishy");
    }
}