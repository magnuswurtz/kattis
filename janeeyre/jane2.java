import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class jane2 implements Comparable<jane2>{
    private String title;
    private int pages;

    public jane2(String title, int pages){
        this.title = title;
        this.pages = pages;
    }
    @Override
    public int compareTo(jane2 that) {
        return this.title.compareTo(that.title);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int unread = Integer.parseInt(line[0]);
        int nGiven = Integer.parseInt(line[1]);
        int janeLength = Integer.parseInt(line[2]);
        PriorityQueue<jane2> unreadBooks = new PriorityQueue<>();
        TreeMap<Integer,List<jane2>> givenBooks = new TreeMap<>();
        BigInteger minutes = BigInteger.ZERO;

        //read in unread books
        for (int i = 0; i < unread; i++) {
            String[] book = in.readLine().split("\"");
            unreadBooks.add(new jane2(book[1],Integer.parseInt(book[2].strip()))); //Maybe strip the leading "
        }
        //add jane2 Eyre
        unreadBooks.add(new jane2("Jane Eyre", janeLength));

        //Read in given books
        for (int i = 0; i < nGiven; i++) {
            String[] next = in.readLine().split("\"");
            int giveTime = Integer.parseInt(next[0].strip());
            jane2 nextBook = new jane2(next[1],Integer.parseInt(next[2].strip()));

            //Add a time and book to the list of gifts. If two gifts arrive at the same time they are stored in a list with the given time as key
            if(!givenBooks.containsKey(giveTime)) givenBooks.put(giveTime, new LinkedList<jane2>());
            givenBooks.get(giveTime).add(nextBook);
        }
        //Where the magic happens
        while (!unreadBooks.isEmpty()){ //As long as there are more books to give
            while (!(givenBooks.isEmpty()) && BigInteger.valueOf(givenBooks.firstKey()).compareTo(minutes) <= 0) { //Add books from the givenlist untill there are no more books to give at the specified time
                List<jane2> janes = givenBooks.remove(givenBooks.firstKey());
                for (jane2 jane : janes) {
                    unreadBooks.add(jane); 
                }
            }
            jane2 read = unreadBooks.remove(); //Read a book
            minutes = minutes.add(BigInteger.valueOf(read.pages)); //update minutes
            
            if(read.title.equals("Jane Eyre")){ //If the book that was read was Jane Eyre, output the minutes
                System.out.println(minutes);
                return;
            }
        }
    }
}
