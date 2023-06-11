package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class P03_VectorGenerating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Integer [] arr = new Integer[n];
        generateVector(arr, 0);
    }

    private static void generateVector(Integer [] memory, int index) {

        if(index == memory.length) {
            print(memory);
            return;
        }

        for(int i=0; i<=1; i++) {
            memory[index] = i;
            generateVector(memory, index+1);
        }
    }

    private static  void print(Integer [] arr) {
        for (Integer element: arr) {
            System.out.print(element);
        }
        System.out.println();
    }
}
