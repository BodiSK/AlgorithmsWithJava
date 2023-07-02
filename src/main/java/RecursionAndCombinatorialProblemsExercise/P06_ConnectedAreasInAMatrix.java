package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P06_ConnectedAreasInAMatrix {
    private static char[][] matrix;
    private static List<int[]> areas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = reader.readLine().toCharArray();
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (matrix[row][col] == '-') {
                    areas.add(new int[]{row, col, 0});
                    findAreas(row, col);
                }
            }
        }

        System.out.println("Total areas found: " + areas.size());

        AtomicInteger counter = new AtomicInteger(1);
        areas.stream()
                .sorted((f, s) -> Integer.compare(s[2], f[2]))
                .forEach(a -> {
                    System.out.println("Area #" + counter.getAndIncrement()
                            + " at (" + a[0] + ", " + a[1] + "), size: " + a[2]);
                });
    }

    private static void findAreas(int row, int col) {
        if (!isValidPositionOfMatrix(row, col) || matrix[row][col] != '-') {
            return;
        }

        matrix[row][col] = 'V';
        areas.get(areas.size() - 1)[2]++;

        findAreas(row + 1, col);
        findAreas(row, col + 1);
        findAreas(row - 1, col);
        findAreas(row, col - 1);
    }

    private static boolean isValidPositionOfMatrix(int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[0].length;
    }
}
