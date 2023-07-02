package SearchingSortingAndGreedyAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    private static  int[] counts;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr =  Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(arr[i]>max) {
                max = arr[i];
            }
        }
        counts = new int [max+1];

        sort(arr);
        for(int index = 0; index<counts.length; index++) {
            if(counts[index]!=0) {
                for(int i=0; i< counts[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }

    private static  void sort(int arr[]) {
        for(int i=0; i< arr.length; i++) {
            counts[arr[i]]++;
        }
    }
}
