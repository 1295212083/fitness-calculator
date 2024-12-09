package fitness.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DailyWeightRecord {
    private List<WeightEntry> weightEntries;

    public DailyWeightRecord() {
        this.weightEntries = new ArrayList<>();
    }

    public void recordWeight(double weight, String date) {
        weightEntries.add(new WeightEntry(weight, date));
    }

    public void inputWeights(Scanner scanner) {
        while (true) {
            System.out.println("Enter weight (kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter date (yyyy-mm-dd): ");
            String date = scanner.nextLine();

            recordWeight(weight, date);

            System.out.println("Do you want to continue entering weight data? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }
        calculateAverageWeightChange();
    }

    public void calculateAverageWeightChange() {
        if (weightEntries.size() < 2) {
            System.out.println("Not enough data to calculate average weight change.");
            return;
        }

        double initialWeight = weightEntries.get(0).getWeight();
        double finalWeight = weightEntries.get(weightEntries.size() - 1).getWeight();
        double totalDays = weightEntries.size() - 1;
        double weightChange = finalWeight - initialWeight;
        double averageWeeklyChange = (weightChange / totalDays) * 7;

        System.out.printf("Average weight change per week: %.2f kg\n", averageWeeklyChange);
    }

    public void manageRecords(Scanner scanner) {
        while (true) {
            System.out.println("Current Weight Records:");
            for (WeightEntry entry : weightEntries) {
                System.out.println("Date: " + entry.getDate() + " | Weight: " + entry.getWeight() + " kg");
            }

            System.out.println("Manage Records - Choose an option:");
            System.out.println("1. Edit Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. Exit Manage Records");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("Enter the date of the entry to edit (yyyy-mm-dd): ");
                String date = scanner.nextLine();
                System.out.println("Enter the new weight (kg): ");
                double newWeight = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                editEntry(date, newWeight);
            } else if (choice == 2) {
                System.out.println("Enter the date of the entry to delete (yyyy-mm-dd): ");
                String date = scanner.nextLine();
                deleteEntry(date);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void editEntry(String date, double newWeight) {
        for (WeightEntry entry : weightEntries) {
            if (entry.getDate().equals(date)) {
                entry.setWeight(newWeight);
                break;
            }
        }
    }

    public void deleteEntry(String date) {
        weightEntries.removeIf(entry -> entry.getDate().equals(date));
    }

    class WeightEntry {
        private double weight;
        private String date;

        public WeightEntry(double weight, String date) {
            this.weight = weight;
            this.date = date;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getDate() {
            return date;
        }
    }
}
