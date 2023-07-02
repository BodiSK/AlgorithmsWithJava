package CombinatorialProblemsLab;

import java.util.Scanner;

public class P01_1PermutationsWithoutRepetitionsSwap {
    private static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }
        permute(index+1);
        for (int i = index + 1; i < elements.length; i++) {
            swap(i, index);
            permute(index+1);
            swap(i, index);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }

    private static void swap(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

}

