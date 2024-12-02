import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

class day2 {
    public static void day2(String[] args) throws Exception {
        List<List<Integer>> reports = new ArrayList<>();

        FileReader fileReader = new FileReader("day1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null) {
            String[] contents = currentLine.split("\\s+");
            List<Integer> report = new ArrayList<>();

            for(String s : contents) {
                report.add(Integer.parseInt(s));
            }

            reports.add(report);
        }

        int numValid = 0;
        for(List<Integer> report : reports) {
            if(is_safe_part2(report)) {
                numValid++;
            }
        }

        System.out.println("Number of valid: " + numValid);

    }

    public static boolean is_safe(List<Integer> report) {
        float sign = Math.signum(report.get(0) - report.get(1));

        for(int i = 0; i < report.size() - 1; i++) {
            int difference = report.get(i) - report.get(i + 1);

            if(Math.abs(difference) < 1 || Math.abs(difference) > 3 || (Math.signum(difference) != sign)) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean is_safe_part2(List<Integer> report) {
        if(is_safe(report)) return true;
        
        for(int i = 0; i < report.size(); i++) {
            List<Integer> temp = new ArrayList<>(report);
            temp.remove(i);
            
            if(is_safe(temp)) {
                return true;
            }
        }
        
        return false;
    }
}
