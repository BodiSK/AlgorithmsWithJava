package CombinatorialProblemsLab;

import java.util.Scanner;

public class P04_VariationsWithRepetitions {
    private static String[] elements;
    private static String[] variations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        variations = new String[Integer.parseInt(scanner.nextLine())];
        variate(0);
    }
    private static void variate(int index) {
        if(index == variations.length) {
            print();
            return;
        }

        for (int i=0; i<elements.length; i++) {
            variations[index] = elements[i];
            variate(index+1);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}
