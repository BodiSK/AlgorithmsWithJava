package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class P08_WordCruncher {

    private static List<String> input;
    private static String target;
    private static List<String> permutations = new ArrayList<>();
    private static HashMap<Integer, List<String>> table = new HashMap<>();
    private static HashMap<String, Integer> occurrences = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        input = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());
        target = reader.readLine();

        input.removeIf(word -> !target.contains(word));

        for (int i = 0; i < input.size(); i++) {
            String subStr = input.get(i);
            int index = target.indexOf(subStr);
            occurrences.putIfAbsent(subStr, 0);
            occurrences.put(subStr, occurrences.get(subStr) + 1);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(subStr);
                index = target.indexOf(subStr, index + 1);
            }
        }

        permute(0);
    }

    private static void permute(int index) {

        if (index == target.length()) {
            if (String.join("", permutations).equals(target)) {
                printResult();
            }
            return;
        }

        List<String> strings = table.get(index);
        if (strings != null) {
            for (int i = 0; i < strings.size(); i++) {
                String str = strings.get(i);
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    permutations.add(str);
                    permute(index + str.length());
                    permutations.remove(permutations.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void printResult() {
        System.out.println(String.join(" ", permutations));
    }
}
