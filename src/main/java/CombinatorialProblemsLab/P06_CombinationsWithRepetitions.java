package CombinatorialProblemsLab;

import java.util.Scanner;

public class P06_CombinationsWithRepetitions {
    private static String[] elements;
    private static String[] combinations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        combinations = new String[Integer.parseInt(scanner.nextLine())];
        combine(0, 0);
    }

    private static void combine(int index, int start) {
        if (index == combinations.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {

            combinations[index] = elements[i];
            combine(index + 1, i);

        }
    }

    private static void print() {
        System.out.println(String.join(" ", combinations));
    }
}
