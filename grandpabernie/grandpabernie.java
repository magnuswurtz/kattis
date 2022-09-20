import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class grandpabernie{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,List<Integer>> trips = new HashMap<>();

        //Read in the trips and maintain a list of years for each visited country
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");
            
            if(!trips.containsKey(line[0])){
                List<Integer> tripList = new ArrayList<>();
                tripList.add(Integer.parseInt(line[1]));
                trips.put(line[0], tripList);
            } else {
                trips.get(line[0]).add(Integer.parseInt(line[1]));
            }
        }
        HashSet<String> queried = new HashSet<>(); //Maintain a set of already queried countries so we only sort the lists for the countries that we need to sort and only sort them once. 
        int q = Integer.parseInt(br.readLine());

        //Write the year of the kth trip to output. Sort the list of years if it is not already sorted.
        while (q-- > 0) {
            String[] line2 = br.readLine().split(" ");
            if(queried.contains(line2[0]))
                output.write(trips.get(line2[0]).get(Integer.parseInt(line2[1])-1)+"\n");
            else{
                trips.get(line2[0]).sort(null);
                output.write(trips.get(line2[0]).get(Integer.parseInt(line2[1])-1)+"\n");
            }
            queried.add(line2[0]);
        }
        output.flush();
    }
}