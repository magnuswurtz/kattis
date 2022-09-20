import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class infection2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] st = in.readLine().split(" ");
        int R = Integer.parseInt(st[0]);
        int C = Integer.parseInt(st[1]);

        char[][] grid = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        int humanPosRow = 0;
        int humanPosCol = 0;

        LinkedList<int[]> next = new LinkedList<int[]>();
        
        //Read input into grid
        for (int r = 0; r < R; r++) {
            String line = in.readLine();
            for (int c = 0; c < C; c++) {
                char val = line.charAt(c);
                grid[r][c] = val;
                if (val == '2') next.add(new int[]{r,c});
                if (val == '3') {
                    humanPosRow = r; 
                    humanPosCol = c;
                } 
            }
        }
        //Perform restricted BFS on all nodes that are not water, starting from virus position
        while (!next.isEmpty()) {
            int[] pos = next.pop();
            int r = pos[0];
            int c = pos[1];

            if (r+1 < R && !visited[r+1][c] && grid[r+1][c] != '0') {
                visited[r+1][c] = true;
                next.add(new int[]{r+1,c});
            }
            if (r-1 >= 0 && !visited[r-1][c] && grid[r-1][c] != '0') {
                visited[r-1][c] = true;
                next.add(new int[]{r-1,c});
            }
            if (c+1 < C && !visited[r][c+1] && grid[r][c+1] != '0') {
                visited[r][c+1] = true;
                next.add(new int[]{r,c+1});
            }
            if (c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] != '0') {
                visited[r][c-1] = true;
                next.add(new int[]{r,c-1});
            }
            if(visited[humanPosRow][humanPosCol]) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
