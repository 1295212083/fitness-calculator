package fitness.calculator;
import java.util.Scanner;

public class FitnessCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a feature to use:");
            System.out.println("1. Daily Calorie Intake Planning");
            System.out.println("2. Daily Weight Record");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("Enter your weight (kg): ");
                double weight = scanner.nextDouble();

                System.out.println("Enter your height (cm): ");
                double height = scanner.nextDouble();

                System.out.println("Enter your age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter your gender (male/female): ");
                String gender = scanner.nextLine();

                UserProfile user = new UserProfile(weight, height, age, gender);

                System.out.println("Choose a fitness goal (weight loss, weight gain, maintain): ");
                String goal = scanner.nextLine();

                System.out.println("Specify calorie adjustment (mild, moderate, extreme): ");
                String intensity = scanner.nextLine();

                DailyCalorieIntake calorieIntake = new DailyCalorieIntake(user, goal, intensity);
                calorieIntake.displayDailyIntake();

                while (true) {
                    System.out.println("Do you want to edit your plan? (yes/no): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("yes")) {
                        calorieIntake.editPlan(scanner);
                    } else {
                        break;
                    }
                }
            } else if (choice == 2) {
                DailyWeightRecord weightRecord = new DailyWeightRecord();
                weightRecord.inputWeights(scanner);

                while (true) {
                    System.out.println("Do you want to manage your weight records? (yes/no): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("yes")) {
                        weightRecord.manageRecords(scanner);
                    } else {
                        System.out.println("Do you want to recalculate average weight loss/gain? (yes/no): ");
                        String recalculateResponse = scanner.nextLine();
                        if (recalculateResponse.equalsIgnoreCase("yes")) {
                            weightRecord.calculateAverageWeightChange();
                        }
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Do you want to use another feature? (yes/no): ");
            String anotherFeature = scanner.nextLine();
            if (!anotherFeature.equalsIgnoreCase("yes")) {
                System.out.println("Exiting the Application. Goodbye!");
                break;
            }
        }
    }
}
