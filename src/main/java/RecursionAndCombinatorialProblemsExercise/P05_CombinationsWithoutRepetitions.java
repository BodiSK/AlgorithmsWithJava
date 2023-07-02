package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05_CombinationsWithoutRepetitions {
    public static int[] elements;
    private static int n;
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());

        elements = new int[k];
        combine(0,1);
    }

    private static void combine(int index, int start) {
        if (index == k) {
            print();
            return;
        }

        for(int i=start; i<=n; i++) {
            elements[index] = i;
            combine(index+1, i+1);

        }
    }

    private static void print() {
        for(int i=0; i< elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
