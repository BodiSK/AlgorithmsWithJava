package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class P02_Recursive_Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        recursiveDrawing(n);

    }

    private static void recursiveDrawing(int n) {
        if (n <= 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        System.out.println();

        recursiveDrawing(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
