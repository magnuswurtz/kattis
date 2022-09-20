import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * rankproblem
 */
public class rankproblem {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] rankingToTeam = new int[n];
        int[] teamsToRanking = new int[n];
        for (int i = 0; i < rankingToTeam.length; i++){
            rankingToTeam[i] = i; 
            teamsToRanking[i] = i;
        } 
        
        for(int i = 0; i<m ; i++){
            String[] teams = in.readLine().split(" ");
            int t1 = Character.getNumericValue(teams[0].charAt(1));
            int t2 = Character.getNumericValue(teams[1].charAt(1));
            if(teamsToRanking[t1] < teamsToRanking[t2]){
                teamsToRanking[t2] = teamsToRanking[t1]+1;
                for (int j = teamsToRanking[t1]; j < teams.length; j++) {
                    
                }
            }
        }
    }
}