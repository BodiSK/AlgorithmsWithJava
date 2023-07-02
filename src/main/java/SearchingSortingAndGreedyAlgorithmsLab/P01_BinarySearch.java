package SearchingSortingAndGreedyAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(scanner.nextLine());

        System.out.println(binarySearch(input, key));
    }

    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int current = arr[mid];

            if (current < key) {
                start = mid + 1;
            } else if (current > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
