import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Cat
 */
public class Cat implements Comparable<Cat> {
    private String name;
    private int arrival;
    private int infectionLevel;

    public Cat(String name, int arrival, int infectionLevel){
        this.name = name;
        this.infectionLevel = infectionLevel;
        this.arrival = arrival;
    }
    @Override
    public int compareTo(Cat that) {
        if(this.infectionLevel < that.infectionLevel) return -1;
        if(this.infectionLevel > that.infectionLevel) return 1;
        if(this.arrival < that.arrival) return 1;
        if(this.arrival > that.arrival) return -1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuilder out = new StringBuilder();
        TreeSet<Cat> tree = new TreeSet<>();
        HashMap<String,Cat> nameLookUp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            String task = line[0]; //type of task
            
            switch (task) {
                case "0": //add the cat to tree
                    Cat kitty = new Cat(line[1],i,Integer.parseInt(line[2]));
                    tree.add(kitty);
                    nameLookUp.put(line[1], kitty);
                    break;
                case "1":
                //Update infection level of the given cat by adding to it's infection level
                    Cat miavy = nameLookUp.get(line[1]);
                    tree.remove(miavy);
                    miavy.infectionLevel+=Integer.parseInt(line[2]);
                    tree.add(miavy);
                    break;
                case "2": //remove the given cat
                Cat pussy = nameLookUp.get(line[1]);
                    tree.remove(pussy);
                break;
                case "3": //remove the cat at the root of the tree
                    if (tree.isEmpty()) out.append("The clinic is empty \n");
                    else out.append(tree.last().name).append("\n");
                    
                break;
            }
        }
        System.out.println(out);
    }
}