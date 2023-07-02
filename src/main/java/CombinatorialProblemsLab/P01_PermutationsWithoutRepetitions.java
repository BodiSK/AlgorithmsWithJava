package CombinatorialProblemsLab;

import java.util.Scanner;

public class P01_PermutationsWithoutRepetitions {
    private static String[] elements;
    private static String[] permutes;
    private static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        permutes = new String[elements.length];
        isUsed = new boolean[elements.length];
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                permutes[index] = elements[i];
                permute(index + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permutes));
    }

}
