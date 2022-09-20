import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Flights implements Comparable<Flights> {
    private int hours;
    private int minutes;
    private int seconds;

    public Flights(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    @Override
    public int compareTo(Flights that) {
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
        TreeMap<Flights,String> flights = new TreeMap<>();
        //Read in flights
        for(int i = 0; i < nFlights; i++){
            StringTokenizer fl = new StringTokenizer(in.readLine());
            String[] times = fl.nextToken().split(":");
            flights.put(new Flights(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2])), fl.nextToken());
        }
        //Read in operations and compute output
        for (int i = 0; i < nOperations; i++) {
            StringTokenizer op = new StringTokenizer(in.readLine());
            String operation = op.nextToken();
            String[] times = op.nextToken().split(":");
            Flights flight = new Flights(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));

            switch (operation) {
                case "cancel":
                    flights.remove(flight);
                break;
                case "delay":
                    String destination = flights.remove(flight);
                    flight.delay(Integer.parseInt(op.nextToken()));
                    flights.put(flight, destination);
                break;
                case "reroute":
                    flights.replace(flight, op.nextToken());
                break;
                case "destination":
                    if (flights.containsKey(flight)) System.out.println(flights.get(flight));
                    else System.out.println("-");
                break;
                case "next":
                    Map.Entry<Flights,String> out = flights.ceilingEntry(flight);
                    System.out.println(out.getKey()+ " " + out.getValue());
                break;
                case "count":
                    Flights lower = flight;
                    String[] t = op.nextToken().split(":");
                    Flights upper = new Flights(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2]));
                    int count = flights.subMap(lower,true,upper,true).size();
    
                    System.out.println(count);
                break;        
            }
        }
    }
}