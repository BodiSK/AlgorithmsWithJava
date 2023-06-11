package RecursionAndBacktrackingLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(recursiveArraySum(array, 0));
    }

    private static int recursiveArraySum(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        return arr[index] + recursiveArraySum(arr, index + 1);
    }

}
