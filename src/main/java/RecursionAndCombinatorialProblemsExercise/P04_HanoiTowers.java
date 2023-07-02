package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class P04_HanoiTowers {

    private static StringBuilder out = new StringBuilder();
    private static Deque<Integer> source = new ArrayDeque<>();
    private static Deque<Integer> destination = new ArrayDeque<>();
    private static Deque<Integer> spare = new ArrayDeque<>();
    private static int step = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        printRodes();
        solve(disk, source, destination, spare);
        System.out.println(out.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            out.append("Step #").append(step++).append(": Moved disk")
                    .append(System.lineSeparator());
            printRodes();
            return;
        }

        solve(disk-1, source, spare, destination);
        solve(1, source, destination, spare);
        solve(disk-1, spare, destination, source);
    }

    private static void printRodes() {
        out.append(
                String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                        formatRode(source),
                        formatRode(destination),
                        formatRode(spare)
                )
        ).append(System.lineSeparator());
    }

    private static String formatRode(Deque<Integer> rode) {
        return rode.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
