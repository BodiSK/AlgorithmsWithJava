package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P07_Cinema {

    private static List<String> names;
    private static boolean[] fixed;
    private static String[] permutations;
    private static String[] seats;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        names = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        seats = new String[names.size()];

        String line;

        while (!(line = reader.readLine()).equals("generate")) {
            String[] commands = line.split(" - ");
            String name = commands[0];
            int index = Integer.parseInt(commands[1]) - 1;
            seats[index] = name;
            names.remove(name);
        }

        permutations = new String[names.size()];
        fixed = new boolean[names.size()];

        permute(0);
    }

    private static void permute(int index) {
        if (index == permutations.length) {
            printPermutations();
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            if(!fixed[i]) {
                fixed[i] = true;
                permutations[index] = names.get(i);
                permute(index+1);
                fixed[i] = false;
            }
        }
    }

    private static void printPermutations() {
        int index = 0;
        String[] out = new String[seats.length];
        for (int i = 0; i < out.length; i++) {
            if (seats[i] != null) {
                out[i] = seats[i];
            } else {
                out[i] = permutations[index++];
            }
        }
        System.out.println(String.join(" ", out));
    }

}
