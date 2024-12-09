package fitness.calculator;
import java.util.Scanner;
public class DailyCalorieIntake {
    private UserProfile userProfile;
    private String goal;
    private String intensity;

    public DailyCalorieIntake(UserProfile userProfile, String goal, String intensity) {
        this.userProfile = userProfile;
        this.goal = goal;
        this.intensity = intensity;
    }

    public double calculateBMR() {
        double bmr;
        if (userProfile.getGender().equalsIgnoreCase("male")) {
            bmr = 10 * userProfile.getWeight() + 6.25 * userProfile.getHeight() - 5 * userProfile.getAge() + 5;
        } else {
            bmr = 10 * userProfile.getWeight() + 6.25 * userProfile.getHeight() - 5 * userProfile.getAge() - 161;
        }
        return bmr;
    }

    public double calculateDailyIntake() {
        double bmr = calculateBMR();
        double adjustmentFactor = 1.0;
        if (goal.equalsIgnoreCase("weight loss")) {
            switch (intensity.toLowerCase()) {
                case "mild":
                    adjustmentFactor = 0.9;
                    break;
                case "moderate":
                    adjustmentFactor = 0.8;
                    break;
                case "extreme":
                    adjustmentFactor = 0.7;
                    break;
            }
        } else if (goal.equalsIgnoreCase("weight gain")) {
            switch (intensity.toLowerCase()) {
                case "mild":
                    adjustmentFactor = 1.1;
                    break;
                case "moderate":
                    adjustmentFactor = 1.2;
                    break;
                case "extreme":
                    adjustmentFactor = 1.3;
                    break;
            }
        }
        return bmr * adjustmentFactor;
    }
    public void displayDailyIntake() {
        System.out.println("Daily Calorie Intake: " + calculateDailyIntake() + " kcal");
    }
    public void editPlan(Scanner scanner) {
        System.out.println("Choose a fitness goal (weight loss, weight gain, maintain): ");
        this.goal = scanner.nextLine();
        System.out.println("Specify calorie adjustment (mild, moderate, extreme): ");
        this.intensity = scanner.nextLine();

        displayDailyIntake();
    }
}
