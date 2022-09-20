import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class basicProgramming1 {
    public static void case2(int[] A){
        if (A[0] > A[1]) System.out.println(("Bigger"));
        else if (A[0] == A[1]) System.out.println("Equal");
        else System.out.println("Smaller");
        
    }
    public static void case3(int[] A){
        int[] B = Arrays.copyOfRange(A, 0, 3);
        Arrays.sort(B);
        System.out.println(B[1]);
    }
    public static void case4(int[] A){
        long sum = 0;
        for (int index = 0; index < A.length; index++) {
            sum+=A[index];
        }
        System.out.println(sum);
        
    }
    public static void case5(int[] A){
        long sum = 0;
        for (int index = 0; index < A.length; index++) {
            if(A[index] % 2 == 0)
                sum+=A[index];
        }
        System.out.println(sum);
    }
    public static void case6(int[] A){
        StringBuilder out = new StringBuilder();
        for (int i : A) {
            out.append((char) (97 + i % 26));
        }
        System.out.println(out);     
    }

    public static void case7(int[] A, int N){
        int i = 0;

        while(true){
            if(i >= N){
                System.out.println("Out");
                return;
            }
            else if(A[i] == -1){
                System.out.println("Cyclic");
                return;
            }
            else if(i == N-1){
                System.out.println("Done");
                return;
            }
            int temp = A[i];
            A[i] = -1;
            i = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int t = Integer.parseInt(line[1]);
        int N = Integer.parseInt(line[0]);
        int[] A = (int[]) Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        switch (t) {
            case 1:
                System.out.println(7);
                break;
            case 2:
                case2(A);
                break;
            case 3:
                case3(A);
                break;
            case 4:
                case4(A);
                break;
            case 5:
                case5(A);
                break;
            case 6:
                case6(A);
                break;
            case 7:
                case7(A,N);
                break;
        }
    }    
}
