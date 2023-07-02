package CombinatorialProblemsLab;

import java.util.Scanner;

public class P03_VariationsWithoutRepetitions {
    private static String[] elements;
    private static String[] variations;
    private static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        variations = new String[Integer.parseInt(scanner.nextLine())];
        isUsed = new boolean[elements.length];
        variate(0);
    }

    private static void variate(int index) {
        if (index == variations.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                variations[index] = elements[i];
                variate(index + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}
