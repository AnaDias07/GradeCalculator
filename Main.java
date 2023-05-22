import java.util.ArrayList;
import java.util.List;
public class Main{
    public static void main(String args[]){

        UserInformationScanner.userInformationRequest();  
        double possibleGradeValuesToPass = 5; //At Tu/e to pass a course the final grade must be a 6, 7, 8, 9 or 10 therefore there are 5 possible value
        double desired_average = (double) UserInformationScanner.desired_average;
        double courses_left = (double) UserInformationScanner.courses_left;


        List<List<Double>> combinations = CombinationGenerator.generateCombinations(courses_left, possibleGradeValuesToPass);
        List<List<Double>> possibleCombinations = PossibleCombinations.possibleCombinationsCalculator(combinations, desired_average);
        
        
        
        // Print all combinations
        // int tmp_count = 0;
        // for (List<Double> combination : possibleCombinations) {
        //     tmp_count = tmp_count + 1;
        //     System.out.println(combination);
        // }
        List<Double> firstOptionDouble = possibleCombinations.get(0);
        System.out.println(firstOptionDouble);

        List<Integer> firstOption = new ArrayList<>();
        for (Double double_value : firstOptionDouble) {
            firstOption.add(double_value.intValue());
        }

        System.out.println("To obtain an average of atleast " + desired_average + "\nYou need to obtain at least " + firstOption.get(0) + " grades with a value of 10,\n" + firstOption.get(1) + " grades with a value of 9 \n" + firstOption.get(2) + " grades with a value of 8 \n" + firstOption.get(3) + " grades with a value of 7, and \n" + firstOption.get(4) + " grades with a value of 6 \nThis will give you an average of " + firstOption.get(5));
       }  
}
