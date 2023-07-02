package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P09_SchoolTeams {
    private static String[] girls;
    private static String[] boys;
    private static List<String> girlsCombinations = new ArrayList<>();
    private static List<String> boysCombinations = new ArrayList<>();
    private static String[] combinations;
    private static int girlsMaxCount = 3;
    private static int boysMaxCount = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        girls = reader.readLine().split(", ");
        boys = reader.readLine().split(", ");

        combinations = new String [girlsMaxCount];
        combine(0,0, "girls", girls);

        combinations = new String[boysMaxCount];
        combine(0,0, "boys", boys);

        for(int i =0; i<girlsCombinations.size(); i++) {
            for(String boysCombo: boysCombinations) {
                System.out.println(girlsCombinations.get(i) + ", " + boysCombo);
            }
        }
    }

    private static void combine(int index, int start, String gender, String[] arr) {
        if(index == combinations.length) {
            print(gender);
            return;
        }

        for(int i = start; i< arr.length; i++) {
            combinations[index] = arr[i];
            combine(index+1, i+1, gender, arr);
        }
    }

    private static void print(String gender) {
        if(gender.equals("boys")){
            boysCombinations.add(String.join(", ", combinations));
        }else{
            girlsCombinations.add(String.join(", ", combinations));
        }
    }
}
