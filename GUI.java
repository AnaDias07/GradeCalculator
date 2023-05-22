import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {

    public static int obtained_6;
    public static int obtained_7;
    public static int obtained_8;
    public static int obtained_9;
    public static int obtained_10;
    public static int total_courses_passed;
    public static double current_average;
    public static double desired_average;
    public static int courses_left;
    public static double current_total_grade;
    public static int total_courses;

    private static JFrame frame;
    private static JLabel obtained6Label;
    private static JLabel obtained7Label;
    private static JLabel obtained8Label;
    private static JLabel obtained9Label;
    private static JLabel obtained10Label;
    private static JLabel desiredAverageLabel;
    //private static JLabel totalCoursesLabel;
    private static JTextField obtained6TextField;
    private static JTextField obtained7TextField;
    private static JTextField obtained8TextField;
    private static JTextField obtained9TextField;
    private static JTextField obtained10TextField;
    private static JTextField desiredAverageTextField;
    //private static JTextField totalCoursesTextField;
    private static JButton calculateButton;
    private static JButton resetButton;

    public static void main(String[] args) {
        createGUI();
    }

    private static void createGUI() {
        frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        obtained6Label = new JLabel("Courses with a 6:");
        obtained7Label = new JLabel("Courses with a 7:");
        obtained8Label = new JLabel("Courses with a 8:");
        obtained9Label = new JLabel("Courses with a 9:");
        obtained10Label = new JLabel("Courses with a 10:");
        desiredAverageLabel = new JLabel("Desired final average");
        //totalCoursesLabel = new JLabel("Total courses in degree");
        obtained6TextField = new JTextField();
        obtained7TextField = new JTextField();
        obtained8TextField = new JTextField();
        obtained9TextField = new JTextField();
        obtained10TextField = new JTextField();
        desiredAverageTextField = new JTextField();
        //totalCoursesTextField = new JTextField();
        calculateButton = new JButton("Calculate");
        resetButton = new JButton("Reset");

        obtained6Label.setBounds(15, 15, 120, 25);
        obtained6TextField.setBounds(150, 15, 120, 25);
        obtained7Label.setBounds(15, 45, 120, 25);
        obtained7TextField.setBounds(150, 45, 120, 25);
        obtained8Label.setBounds(15, 75, 120, 25);
        obtained8TextField.setBounds(150, 75, 120, 25);
        obtained9Label.setBounds(15, 105, 120, 25);
        obtained9TextField.setBounds(150, 105, 120, 25);
        obtained10Label.setBounds(15, 135, 120, 25);
        obtained10TextField.setBounds(150, 135, 120, 25);
        desiredAverageLabel.setBounds(15, 165, 120, 25);
        desiredAverageTextField.setBounds(150, 165, 120, 25);
        // totalCoursesLabel.setBounds(15, 195, 120, 25);
        // totalCoursesTextField.setBounds(150, 195, 120, 25);
        calculateButton.setBounds(90, 195, 120, 30);
        resetButton.setBounds(90, 235, 120, 30);
        resetButton.setVisible(false);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateButtonClicked();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonClicked();
            }
        });

        frame.add(obtained6Label);
        frame.add(obtained6TextField);
        frame.add(obtained7Label);
        frame.add(obtained7TextField);
        frame.add(obtained8Label);
        frame.add(obtained8TextField);
        frame.add(obtained9Label);
        frame.add(obtained9TextField);
        frame.add(obtained10Label);
        frame.add(obtained10TextField);
        frame.add(desiredAverageLabel);
        frame.add(desiredAverageTextField);
        //frame.add(totalCoursesLabel);
        //frame.add(totalCoursesTextField);
        frame.add(calculateButton);
        frame.add(resetButton);

        frame.setSize(300, 320);
        frame.setVisible(true);

    }

    // public static void showCourseInputDialog() {
    //     int dialogResult = JOptionPane.showConfirmDialog(frame, "Are you pursuing a Bachelor's degree with 180 ECTS (36 courses)?", "Degree Information", JOptionPane.YES_NO_OPTION);
    //     if (dialogResult == JOptionPane.YES_OPTION) {
    //         total_courses = 36;
    //         //totalCoursesTextField.setText(String.valueOf(total_courses));
    //     } else {
    //         String input = JOptionPane.showInputDialog(frame, "Please enter the total number of courses in your degree:");
    //         try {
    //             total_courses = Integer.parseInt(input);
    //             //totalCoursesTextField.setText(String.valueOf(total_courses));
    //         } catch (NumberFormatException e) {
    //             JOptionPane.showMessageDialog(frame, "Invalid input. Using default value (36).", "Invalid Input", JOptionPane.WARNING_MESSAGE);
    //             total_courses = 36;
    //             //totalCoursesTextField.setText(String.valueOf(total_courses));
    //         }
    //     }
    //     calculateButton.setEnabled(true);
    // }

    public static void calculateButtonClicked() {
        showCourseInputDialog();
        obtained_6 = Integer.parseInt(obtained6TextField.getText());
        obtained_7 = Integer.parseInt(obtained7TextField.getText());
        obtained_8 = Integer.parseInt(obtained8TextField.getText());
        obtained_9 = Integer.parseInt(obtained9TextField.getText());
        obtained_10 = Integer.parseInt(obtained10TextField.getText());

        total_courses_passed = obtained_6 + obtained_7 + obtained_8 + obtained_9 + obtained_10;
        courses_left = total_courses - total_courses_passed;

        current_average = ((6 * obtained_6) + (7 * obtained_7) + (8 * obtained_8) + (9 * obtained_9) + (10 * obtained_10)) / ((double) total_courses_passed);

        desired_average = Double.parseDouble(desiredAverageTextField.getText());

        current_total_grade = current_average * total_courses_passed;

        String statisticsMessage = "Courses completed: " + total_courses_passed + "\n"
                + "Current average: " + current_average + "\n"
                + "Courses left to complete: " + courses_left + "\n"
                + "Desired average: " + desired_average;

        JOptionPane.showMessageDialog(frame, statisticsMessage, "Current Statistics", JOptionPane.INFORMATION_MESSAGE);

        resetButton.setVisible(true);

        List<List<Double>> combinations = CombinationGenerator.generateCombinations((double) courses_left, 5);
        List<List<Double>> possibleCombinations = PossibleCombinations.possibleCombinationsCalculator(combinations, desired_average);

        if (!possibleCombinations.isEmpty()) {
            List<Double> firstOptionDouble = possibleCombinations.get(0);
            List<Integer> firstOption = new ArrayList<>();
            for (Double doubleValue : firstOptionDouble) {
                firstOption.add(doubleValue.intValue());
            }
            String resultMessage = "To obtain an average of at least " + desired_average + "\n"
                    + "You need to obtain at least " + firstOption.get(0) + " grades with a value of 10,\n"
                    + firstOption.get(1) + " grades with a value of 9,\n"
                    + firstOption.get(2) + " grades with a value of 8,\n"
                    + firstOption.get(3) + " grades with a value of 7, and\n"
                    + firstOption.get(4) + " grades with a value of 6.\n"
                    + "This will give you an average of " + firstOptionDouble.get(5) + ".";

            JOptionPane.showMessageDialog(frame, resultMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No combinations found to achieve the desired average.", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void showCourseInputDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(frame, "Are you pursuing a Bachelor's degree with 180 ECTS (36 courses)?", "Degree Information", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            total_courses = 36;
            //totalCoursesTextField.setText(String.valueOf(total_courses));
        } else {
            String input = JOptionPane.showInputDialog(frame, "Please enter the total number of courses in your degree:");
            try {
                total_courses = Integer.parseInt(input);
                //totalCoursesTextField.setText(String.valueOf(total_courses));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Using default value (36).", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                total_courses = 36;
                //totalCoursesTextField.setText(String.valueOf(total_courses));
            }
        }
        calculateButton.setEnabled(true);
    }

    public static void resetButtonClicked() {
        obtained6TextField.setText("");
        obtained7TextField.setText("");
        obtained8TextField.setText("");
        obtained9TextField.setText("");
        obtained10TextField.setText("");
        desiredAverageTextField.setText("");
        resetButton.setVisible(false);
    }
}

