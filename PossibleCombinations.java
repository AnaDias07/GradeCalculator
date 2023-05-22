import java.util.ArrayList;
import java.util.List;

public class PossibleCombinations extends UserInformationScanner {
    public static List<List<Double>> possibleCombinationsCalculator(List<List<Double>> combinations, double desired_average) {
        List<List<Double>> possibleCombinations = new ArrayList<>();
        possibleCombinationsHelper(possibleCombinations, combinations);
        return possibleCombinations;
    }
    
    double current_total_grade = current_average*total_courses_passed;

    public static void possibleCombinationsHelper(List<List<Double>> possibleCombinations, List<List<Double>> combinations) {
    
        double current_total_grade = current_average*total_courses_passed; 
        double compute_average_helper = desired_average * (total_courses_passed + courses_left) - current_total_grade;
        List<List<Double>> combinationsWithAverage = new ArrayList<>(combinations);
        for (List<Double> combination : combinationsWithAverage) {
            if (10*combination.get(0) + 9*combination.get(1)+8*combination.get(2) + 7*combination.get(3)+ 6*combination.get(4)  >= compute_average_helper) {
                combination.add((current_total_grade+10*combination.get(0) + 9*combination.get(1)+8*combination.get(2) + 7*combination.get(3)+ 6*combination.get(4))/(total_courses_passed+courses_left));
                possibleCombinations.add(new ArrayList<>(combination));
            }
        }
    }

}
