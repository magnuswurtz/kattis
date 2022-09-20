import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import edu.princeton.cs.algs4.Merge;

public class grades implements Comparable<grades> {
    private String name;
    private double grade;
    private double gradePost;

    public grades(String name, String grade){
        this.name = name;
        this.grade = Double.valueOf(grade.charAt(0));
        int index = 1;
        if (grade.startsWith("FX")) {
            this.grade -= 0.5;
            index = 2;
        }
        if (grade.length() >= index+1 ) {
            if (grade.charAt(index) == '-') this.gradePost = -grade.length()-index;
            else this.gradePost = grade.length()-index;
        }
    }
    public int compareTo(grades that) {
        if(this.grade > that.grade) return 1;
        if(this.grade < that.grade) return -1;
        if(this.gradePost < that.gradePost) return 1;
        if(this.gradePost > that.gradePost) return -1;
        if(this.name.compareTo(that.name)>0) return 1;
        if(this.name.compareTo(that.name)<0) return -1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        grades[] students = new grades[n];

        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            students[i] = new grades(line[0], line[1]);
        }
        Merge.sort(students);
        StringBuilder out = new StringBuilder();
        for (grades grades : students) {
            out.append(grades.name).append("\n");
        }
        System.out.println(out);
    }
}