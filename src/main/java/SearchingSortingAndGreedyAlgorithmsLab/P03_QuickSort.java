package SearchingSortingAndGreedyAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_QuickSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(arr);

        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int smaller = low - 1;

        for (int i = low; i < high; i++) {

            if (arr[i] <= pivot) {
                smaller++;
                swap(arr, i, smaller);

            }
        }
        swap(arr, smaller + 1, high);
        return smaller + 1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
