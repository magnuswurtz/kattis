//Solves test cases 1 and 3. Does not support the move operation.
//Solution by utilizing UF API.
import java.util.Scanner;
import edu.princeton.cs.algs4.UF;

public class disjointsets{
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 UF uf = new UF(n);
		 int m = sc.nextInt();
		
		 for (int i = 0; i<m;i++) {
			 int operation = sc.nextInt();
			 int s = sc.nextInt();
			 int t = sc.nextInt();
			switch (operation) {
				case 0:
					if (uf.find(s) == uf.find(t)) System.out.println("1");
					else System.out.println("0");
					break;
				case 1:
					uf.union(s, t);
					break;
				case 2:
					break;
			}
		 }	 
	}
}