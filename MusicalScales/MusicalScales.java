import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * MusicalScales
 */
public class MusicalScales {
    
    public static Map<String,ArrayList<String>> createScales(){
        String[] note1 = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#","A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
        ArrayList<String> notes = new ArrayList<>(Arrays.asList(note1));
        
        Map<String,ArrayList<String>> toneToNotesinScale = new HashMap<>();
        
        //Add note as key and the corresponding notes of this keys scale to toneToNotesinScale-map.

        for (String note : notes) {
            ArrayList<String> scaleNotes = new ArrayList<>();
            int index = notes.indexOf(note);
            while (scaleNotes.size() <= 6) {
                scaleNotes.add(notes.get(index));
                index = (index == notes.indexOf(note)+4 || index == notes.indexOf(note)+11) ? index+1: index+2; //ændrer index svarende til en hel tone bortset fra de to steder, hvor det kun skal være halvtoner
            }
            toneToNotesinScale.put(note, scaleNotes);
        }
        return toneToNotesinScale;
    }

    public static void main(String[] args) {
        Map<String, ArrayList<String>> toneToScale = createScales();
        Scanner sc = new Scanner(System.in);
        Set<String> input = new HashSet<String>();
        ArrayList<String> instanceOfScale = new ArrayList<>();
        int nTones = sc.nextInt();

        //Tilføjer input-tonerne til sættet
        while (nTones > 0) {
            input.add(sc.next());
            nTones--;
        }
        //Checker om alle input-tonerne matcher til en skala, og tilføjer navnet på den skala, hvis true
        for (String entry : toneToScale.keySet()) {
            if(toneToScale.get(entry).containsAll(input)){
                instanceOfScale.add(entry);
            }
        } //Hvis ikke der er nogen skalaer der passer på alle inputtonerne
        if(instanceOfScale.isEmpty()){
            System.out.println("none");
        } else{ //Sorterer og printer alle de skalaer der passer på inputtonerne
            instanceOfScale.sort(null);
            instanceOfScale.forEach(scale -> System.out.print(scale+" "));
        }
        sc.close();
    }
}