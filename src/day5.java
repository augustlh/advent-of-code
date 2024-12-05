import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class day5 {
    static class Rule {
        int first;
        int second;

        public Rule(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }

    public static void part1() throws Exception{
        List<Rule> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();     

        String[] content = new String(Files.readAllBytes(Paths.get("day4.txt"))).split("\n");
        for(String str : content) {
            if(str.contains("|")) {
                String[] contents = str.split("\\|");
                rules.add(new Rule(Integer.parseInt(contents[0]), Integer.parseInt(contents[1])));
            } else {
                if(str.equals("")) continue;
                List<Integer> update = new ArrayList<>();
                String[] arr = str.split(",");

                for(String s : arr) {
                    update.add(Integer.parseInt(s));
                }

                updates.add(update);

            }
        }

        List<List<Integer>> validUpdates = new ArrayList<>();

        for(List<Integer> update : updates) {
            if(isValid(rules, update)) {
                System.out.println("Update: " + update + " is valid!");
                validUpdates.add(update);
            }
        }

        int sum = 0;

        for(List<Integer> update : validUpdates) {
            int m = update.size() / 2;

            sum += update.get(m);
        }

        System.out.println("SUM: " + sum);
    }

    public static void part2() throws Exception {
        List<Rule> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();     

        String[] content = new String(Files.readAllBytes(Paths.get("day4.txt"))).split("\n");
        for(String str : content) {
            if(str.contains("|")) {
                String[] contents = str.split("\\|");
                rules.add(new Rule(Integer.parseInt(contents[0]), Integer.parseInt(contents[1])));
            } else {
                if(str.equals("")) continue;
                List<Integer> update = new ArrayList<>();
                String[] arr = str.split(",");

                for(String s : arr) {
                    update.add(Integer.parseInt(s));
                }

                updates.add(update);

            }
        }

        List<List<Integer>> invalidUpdates = new ArrayList<>();

        for(List<Integer> update : updates) {
            if(!isValid(rules, update)) {
                invalidUpdates.add(update);
            }
        }

        for(List<Integer> u : invalidUpdates) {
            orderByRules(rules, u);
        }

        System.out.println(invalidUpdates);
        int sum = 0;
        for(List<Integer> update : invalidUpdates) {
            int m = update.size() / 2;

            sum += update.get(m);
        }

        System.out.println("SUM: " + sum);
    }

    public static void orderByRules(List<Rule> rules, List<Integer> update) {
        while(!isValid(rules, update)) {
            for(Rule rule : rules) {
                int first = rule.first;
                int second = rule.second;

                if(!update.contains(first) || !update.contains(second)) continue;

                Map<Integer, Integer> indices = new HashMap<>();
                for(int i = 0; i < update.size(); i++) {
                    indices.put(update.get(i), i);
                }

                if(indices.get(first) > indices.get(second)) {
                    update.set(indices.get(first), second);
                    update.set(indices.get(second), first);
                }

            }
        }   
    }

    public static boolean isValid(List<Rule> rules, List<Integer> update) {
        Map<Integer, Integer> indices = new HashMap<>();
        for(int i = 0; i < update.size(); i++) {
            indices.put(update.get(i), i);
        }

        for(Rule rule : rules) {
            int first = rule.first;
            int second = rule.second;

            if(!update.contains(first) || !update.contains(second)) continue;            
            if(indices.get(first) > indices.get(second)) return false;

        }

        return true;
    }
}

