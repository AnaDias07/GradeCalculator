import java.util.Scanner;
public class UserInformationScanner{
    public static int obtained_6;
    public static int obtained_7;
    public static int obtained_8;
    public static int obtained_9;
    public static int obtained_10;
    public static int total_courses_passed;
    public static double current_average;
    public static double desired_average;
    public static int courses_left;

    public static void userInformationRequest() {
        Scanner scanner = new Scanner(System.in); //Create a Scanner Objects
        //System.out.println();
        System.out.println("How many grades with the value of 6 have you obtained so far?");
        obtained_6 = scanner.nextInt();
        System.out.println("How many grades with the value of 7 have you obtained so far?");
        obtained_7 = scanner.nextInt();
        System.out.println("How many grades with the value of 8 have you obtained so far?");
        obtained_8 = scanner.nextInt();
        System.out.println("How many grades with the value of 9 have you obtained so far?");
        obtained_9 = scanner.nextInt();
        System.out.println("How many grades with the value of 10 have you obtained so far?");
        obtained_10 = scanner.nextInt();

        total_courses_passed = obtained_6 + obtained_7 + obtained_8 + obtained_9 + obtained_10;
        System.out.println("You have passed " + total_courses_passed + " courses");

        courses_left = 36 - total_courses_passed;
        System.out.println("To obtain a bachelor of 180 ECTS you need to pass " + courses_left + " more courses is this right? [y/n]");
        if (scanner.nextLine()=="n"){
            System.out.println("How many courses do you need to complete your studies?");
            courses_left = scanner.nextInt();
        }

        current_average = ((6 * obtained_6) + (7 * obtained_7) + (8 * obtained_8) + (9 * obtained_9) + (10 * obtained_10))/ ((double)total_courses_passed);
        System.out.println("Your current average is " + current_average);

        System.out.println("What is your desired average?");
        desired_average = scanner.nextDouble();

        scanner.close();
    }
}

