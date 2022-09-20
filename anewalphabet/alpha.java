import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static java.util.Map.entry; 

public class alpha {
    public static void main(String[] args) throws IOException {
        String[] in = new BufferedReader(new InputStreamReader(System.in)).readLine().toLowerCase().split("");
        StringBuilder out = new StringBuilder();
        Map<String, String> alpha = Map.ofEntries(
        entry("a", "@"),
        entry("b", "8"),
        entry("c", "("),
        entry("d", "|)"),
        entry("e", "3"),
        entry("f", "#"),
        entry("g", "6"),
        entry("h", "[-]"),
        entry("i", "|"),
        entry("j", "_|"),
        entry("k", "|<"),
        entry("l", "1"),
        entry("m", "[]\\/[]"),
        entry("n", "[]\\[]"),
        entry("o", "0"),
        entry("p", "|D"),
        entry("q", "(,)"),
        entry("r", "|Z"),
        entry("s", "$"),
        entry("t", "']['"),
        entry("u", "|_|"),
        entry("v", "\\/"),
        entry("w", "\\/\\/"),
        entry("x", "}{"),
        entry("y", "`/"),
        entry("z", "2")
        );

        for (String str : in) {
            if (alpha.containsKey(str)) out.append(alpha.get(str));
            else out.append(str);
        }
        System.out.println(out);
    }    
}