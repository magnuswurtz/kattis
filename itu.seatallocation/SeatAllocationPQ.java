import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import edu.princeton.cs.algs4.MaxPQ;

public class SeatAllocationPQ implements Comparable<SeatAllocationPQ> { 
    private double nVotes;
    private int seats;
    private double quotient;

    public SeatAllocationPQ(int nVotes, int id){
        this.nVotes = nVotes;
        this.seats = 0;
        this.quotient = nVotes;
    }

    @Override
    public int compareTo(SeatAllocationPQ that) {
        if(this.quotient < that.quotient) return -1;
        if(this.quotient > that.quotient) return 1;
        return 0;
    }
    public void recalculateQuotient(){

    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        
        int nParties = Integer.parseInt(line.split(" ")[0]);
        int nSeats = Integer.parseInt(line.split(" ")[1]);

        MaxPQ<SeatAllocationPQ> pq = new MaxPQ<>(nParties); //Max priority Queue to keep track of the party with the highest quotient
        SeatAllocationPQ[] parties = new SeatAllocationPQ[nParties]; //array to keep track of the order of parties

        //read in all parties:
        for (int i = 0; i < nParties; i++) {
            int votes = Integer.parseInt(in.readLine().strip());
            SeatAllocationPQ paaaarty = new SeatAllocationPQ(votes,i);
            pq.insert(paaaarty);
            parties[i] = paaaarty; 
        
            
        }
        // allocate seats to the parties
        while (nSeats>0) {
            SeatAllocationPQ party =  pq.delMax();
            party.seats++; //Add a seat to the party with the highest quotient
            party.quotient = party.nVotes / (party.seats + 1); //Recalculate this party's quotient
            pq.insert(party);  //reinsert the party in the PQ
            nSeats--; //count down remaining seats
        }
        //print seats
        StringBuilder output = new StringBuilder();
        for (SeatAllocationPQ seatAllocationPQ : parties) {
            output.append(seatAllocationPQ.seats).append("\n");
        }
        System.out.println(output);
    }

}