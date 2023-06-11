package RecursionAndBacktrackingLab;

import java.util.Scanner;

public class P04_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(recursiveFactorial(n));
    }

    private static long recursiveFactorial(int n) {
        if(n == 1) {
            return n;
        }

        return n*recursiveFactorial(n-1);
    }
}


