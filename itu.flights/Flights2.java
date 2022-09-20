import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import edu.princeton.cs.algs4.RedBlackBST;

//This version uses RedBlackBST from algs4 library instead of java TreeMap - it is faster
public class Flights2 implements Comparable<Flights2> {
    private int hours;
    private int minutes;
    private int seconds;

    public Flights2(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    @Override
    public int compareTo(Flights2 that) {
        if (this.hours < that.hours) return -1;
        if (this.hours > that.hours) return 1;
        if (this.minutes < that.minutes) return -1;
        if (this.minutes > that.minutes) return 1;
        if (this.seconds < that.seconds) return -1;
        if (this.seconds > that.seconds) return 1;
        return 0;
    }

    public void delay(int delaySeconds){

        int h = delaySeconds / 3600;
        delaySeconds -= (3600*h);
        int m = delaySeconds / 60;
        delaySeconds -= (60*m);
        int s = delaySeconds;

        if(this.seconds + s >= 60) this.minutes++;
        this.seconds = (this.seconds+s) % 60;

        if(this.minutes + m >= 60) this.hours++;
        this.minutes = (this.minutes+m) % 60;

        this.hours += h;
        }

    @Override
    public String toString() { 
        String out = hours<10 ? "0" + hours +":" : hours +":";
        out = minutes<10 ? out + "0" + minutes + ":" : out + minutes + ":";
        out = seconds<10 ? out + "0" + seconds : out + seconds;
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int nFlights = Integer.parseInt(st.nextToken());
        int nOperations = Integer.parseInt(st.nextToken());
        RedBlackBST<Flights2,String> fly = new RedBlackBST<>();
        //Read in flights
        for(int i = 0; i < nFlights; i++){
            StringTokenizer fl = new StringTokenizer(in.readLine());
            String[] times = fl.nextToken().split(":");
            fly.put(new Flights2(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2])), fl.nextToken());

        }
        //Read in operations and compute output
        for (int i = 0; i < nOperations; i++) {
            StringTokenizer op = new StringTokenizer(in.readLine());
            String operation = op.nextToken();
            String[] times = op.nextToken().split(":");
            Flights2 flight = new Flights2(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));

            switch (operation) {
                case "cancel":
                    fly.delete(flight);
                break;
                case "delay":
                    String destination = fly.get(flight);
                    fly.delete(flight);
                    flight.delay(Integer.parseInt(op.nextToken()));
                    fly.put(flight, destination);
                break;
                case "reroute":
                    fly.put(flight, op.nextToken());
                break;
                case "destination":
                    if (fly.contains(flight)) System.out.println(fly.get(flight));
                    else System.out.println("-");
                break;
                case "next":
                    Flights2 key = fly.ceiling(flight);
                    String value = fly.get(key);
                    System.out.println(key + " " + value);
                break;
                case "count":
                    Flights2 lower = flight;
                    String[] t = op.nextToken().split(":");
                    Flights2 upper = new Flights2(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                    int count = fly.size(lower, upper);
                    System.out.println(count);
                break;        
            }
        }
    }
}