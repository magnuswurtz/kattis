import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class ptice implements Comparable<ptice> {
    private String name;
    private String seq;
    private int correctAnswers;

    public ptice(String name, String seq){
        this.name = name;
        this.seq = seq;
        this.correctAnswers = 0;
    }
    @Override
    public int compareTo(ptice that) {
        if (this.correctAnswers < that.correctAnswers) return 1;
        if (this.correctAnswers > that.correctAnswers) return -1;
        return this.name.compareTo(that.name);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();
        ptice Adrian = new ptice("Adrian","ABC");
        ptice Bruno = new ptice("Bruno","BABC");
        ptice Goran = new ptice("Goran","CCAABB");
        PriorityQueue<ptice> pq = new PriorityQueue<>(3);

        for (int i = 0 ; i < n ; i++){
            char current = input.charAt(i);
            if(current == Adrian.seq.charAt(i % Adrian.seq.length())) Adrian.correctAnswers++;
            if(current == Bruno.seq.charAt(i % Bruno.seq.length())) Bruno.correctAnswers++;
            if(current == Goran.seq.charAt(i % Goran.seq.length())) Goran.correctAnswers++;
        }
        pq.add(Adrian);
        pq.add(Bruno);
        pq.add(Goran);

        int max = pq.peek().correctAnswers;
        System.out.println(max);
        
        while (!pq.isEmpty() && pq.peek().correctAnswers == max){
        System.out.println(pq.remove().name);
        }
    }
}