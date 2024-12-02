import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class day1
{
    public static void day1(String[] args) throws Exception {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        
        Map<Integer, Integer> occurences = new HashMap<>();
            
        FileReader fileReader = new FileReader("day1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] contents = currentLine.split("\\s+");
            int a = Integer.parseInt(contents[0]);          
            int b = Integer.parseInt(contents[1]);
            first.add(a);
            second.add(b);
            
            occurences.put(b, occurences.getOrDefault(b, 0) + 1);
        }      
        
        int sim = 0;
        for(int num : first) {
            sim = sim + num * occurences.getOrDefault(num, 0);
        }
        
        System.out.println("Similarity: " + sim);

    }
}
