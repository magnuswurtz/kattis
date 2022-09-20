import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * countingstars
 */
public class countingstars {

    static void bfs(int r, int c,int R,int C,char[][] grid){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r, c));
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(!(p.c-1 < 0) && grid[p.r][p.c-1] == '-'){
                q.add(new Pair(p.r, p.c-1));
                grid[p.r][p.c-1] = '#';
            }
            if(!(p.c+1 >= C) && grid[p.r][p.c+1] == '-'){
                q.add(new Pair(p.r, p.c+1));
                grid[p.r][p.c+1] = '#';
            }
            if(!(p.r-1 < 0) && grid[p.r-1][p.c] == '-'){
                q.add(new Pair(p.r-1, p.c));
                grid[p.r-1][p.c] = '#';
            }
            if(!(p.r+1 >= R) && grid[p.r+1][p.c] == '-'){
                q.add(new Pair(p.r+1, p.c));
                grid[p.r+1][p.c] = '#';
            }
        }
    } 

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1;
        int cc = 1;

        while((line1 = in.readLine()) != null){

            String[] line = line1.split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            char[][] grid = new char[R][C];
            
            for (int i = 0; i < R; i++) {
                String row = in.readLine();
                for (int j = 0; j < row.length(); j++) {
                    grid[i][j] = row.charAt(j);
                }
            }

            int stars = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(grid[i][j] == '-'){
                        stars += 1;
                        bfs(i,j,R,C,grid);
                    }
                }
            }
            System.out.println("Case "+cc + ": "+ stars);
            cc++;
        }
    }

    static class Pair{
        int r;
        int c;

        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}