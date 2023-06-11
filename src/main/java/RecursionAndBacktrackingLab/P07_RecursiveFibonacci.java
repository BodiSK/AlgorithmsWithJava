package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class P07_RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(recursiveFib(n, new long[n]));
    }

    private static long recursiveFib(int n, long[] memory) {
        if (n <= 1) {
            return 1;
        }

        if (memory[n - 1] == 0) {
            memory[n - 1] = recursiveFib(n - 1, memory) + recursiveFib(n - 2, memory);
        }

        return memory[n - 1];
    }
}
