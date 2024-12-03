import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class day3 {
    public static void part1() throws Exception {
        List<String> matches = new ArrayList<>();
        String content = new String(Files.readAllBytes(Paths.get("day3.txt")));

        Pattern pattern = Pattern.compile("mul[(][0-9]*,[0-9]*[)]");
        Matcher matcher = pattern.matcher(content);

        int result = 0;

        while (matcher.find()) {
            String[] contents = matcher.group().replaceAll("[mul()]+", "").split(",");
            result += Integer.parseInt(contents[0]) * Integer.parseInt(contents[1]);
        }
        System.out.println(" ");

        System.out.println(result);
    }

    public static void part2() throws Exception {    
        List<String> matches = new ArrayList<>();
        String content = new String(Files.readAllBytes(Paths.get("day2.txt")));
        Pattern pattern = Pattern.compile("mul[(][0-9]*,[0-9]*[)]|do[(][)]|don't[(][)]");
        Matcher matcher = pattern.matcher(content);

        boolean mult = true;
        int result = 0;

        while(matcher.find()) {
            if(matcher.group().equals("do()")) {
                mult = true;
            } else if(matcher.group().equals("don't()")) {
                mult = false;
            } else if(matcher.group().startsWith("mul")) {
                if(!mult) continue;
                String[] contents = matcher.group().replaceAll("[mul()]+", "").split(",");
                result += Integer.parseInt(contents[0]) * Integer.parseInt(contents[1]);
            }

        }
        
        System.out.println(result);
    }
}
