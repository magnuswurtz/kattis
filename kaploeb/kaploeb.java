import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * kaploeb
 */
public class kaploeb implements Comparable<kaploeb> {
    int startNumber;
    int seconds;
    int laps;

    public kaploeb(int startNumber,String time){
        this.startNumber = startNumber;
        addToTotalTime(time);
    }
    
    public void addToTotalTime(String time){
        int minutes = Integer.parseInt(time.substring(0,2));
        int sec =  Integer.parseInt(time.substring(3,5));
        this.seconds += (minutes * 60) + sec;
        this.laps += 1;
    }

    @Override
    public int compareTo(kaploeb kp) {
        if(this.seconds < kp.seconds) return -1;
        if (this.seconds > kp.seconds) return 1;
        if(this.startNumber < kp.startNumber) return -1;
        else return 1;
    }
    @Override 
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof kaploeb)) return false;

        kaploeb kp = (kaploeb) o;
        return this.startNumber == kp.startNumber;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int laps = Integer.parseInt(line[0]);
        int minLaps = Integer.parseInt(line[1]);
        HashMap<Integer,kaploeb> runners2 = new HashMap<>();

        for (int i = 0; i < laps; i++) {
            String[] line2 = br.readLine().split(" ");
            int id = Integer.parseInt(line2[0]);
            String time = line2[1];
            if(runners2.containsKey(id)) runners2.get(id).addToTotalTime(time);
            else runners2.put(id, new kaploeb(id, time));
        }
        
        new TreeSet<>(runners2.values()).forEach(runner -> {
            if(runner.laps >= minLaps) System.out.println(runner.startNumber);
        });

    }
}