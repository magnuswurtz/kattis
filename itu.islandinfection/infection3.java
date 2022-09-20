
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// This version uses an inner point class and a vectorlist of adjacent points 

public class infection3 {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static boolean inBounds(Point p, int R, int C) { //True if the point considered is inside the grid
        return (p.c >= 0 && p.c < C && p.r >= 0 && p.r < R);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] st = in.readLine().split(" ");
        int R = Integer.parseInt(st[0]);
        int C = Integer.parseInt(st[1]);

        char[][] grid = new char[R][C]; //draw the grid of the world
        boolean[][] visited = new boolean[R][C]; //True if a point in the grid has been visited

        Point[] vectors = new Point[]{new Point(1, 0),new Point(-1, 0),new Point(0, 1),new Point(0, -1)}; //Vectors pointing to all neighbours of a point in the grid
        Point humanPos = new Point(0,0);

        LinkedList<Point> next = new LinkedList<Point>(); //The queue used for BFS
        
        //Read input into grid
        for (int r = 0; r < R; r++) {
            String line = in.readLine();
            for (int c = 0; c < C; c++) {
                char val = line.charAt(c);
                grid[r][c] = val;
                if (val == '2'){
                    next.add(new Point(r, c));
                    visited[r][c] = true;
                }
                if (val == '3') {
                    humanPos = new Point(r,c);
                } 
            }
        }
        
        //Perform restricted BFS on all nodes that are not water, starting from virus position
        while (!next.isEmpty()) {
            Point pos = next.pop();

            for (int i = 0; i < vectors.length; i++) {
                Point neighbour = new Point(vectors[i].r+pos.r,vectors[i].c+pos.c);
                if (inBounds(neighbour, R, C) && !visited[neighbour.r][neighbour.c] && grid[neighbour.r][neighbour.c] != '0') {
                    visited[neighbour.r][neighbour.c] = true;
                    next.add(neighbour);
                }
            }
            if(visited[humanPos.r][humanPos.c]) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
