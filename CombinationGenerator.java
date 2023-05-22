import java.util.ArrayList;
import java.util.List;


public class CombinationGenerator {

    public static List<List<Double>> generateCombinations(double courses_left, double possibleGradeValuesToPass) {
        List<List<Double>> combinations = new ArrayList<>();
        generateCombinationsHelper(courses_left, possibleGradeValuesToPass, new ArrayList<>(), combinations);
        return combinations;
    }
    
    public static void generateCombinationsHelper(double remainingValue, double remainingNumbers, List<Double> currentCombination, List<List<Double>> combinations) {
        if (remainingNumbers == 0) {
            if (remainingValue == 0) {
                combinations.add(new ArrayList<>(currentCombination));
            }
            return;
        }
        
        for (double i = 0; i <= remainingValue; i++) {
            currentCombination.add(i);
            generateCombinationsHelper(remainingValue - i, remainingNumbers - 1, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

