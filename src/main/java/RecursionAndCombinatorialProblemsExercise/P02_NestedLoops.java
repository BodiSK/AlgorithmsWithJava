package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P02_NestedLoops {

    public static int[] elements;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        elements = new int[n];
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }

        for(int i=1; i<=n; i++) {
            elements[index] = i;
            permute(index+1);

        }
    }

    private static void print() {
        for(int i=0; i< elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
