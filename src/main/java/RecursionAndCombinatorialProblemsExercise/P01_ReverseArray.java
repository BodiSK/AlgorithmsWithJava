package RecursionAndCombinatorialProblemsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01_ReverseArray {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        printReverse(arr, arr.length-1);
    }

    private static void printReverse(int[] arr, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        printReverse(arr, index-1);
    }
}
