import java.util.Random;

public class BmiCalculatorTeam {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int n = 10;
        double[] heights = new double[n];
        double[] weights = new double[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            heights[i] = 1.50 + random.nextDouble() * 0.40;
            weights[i] = 45 + random.nextDouble() * 65;
        }

        printWellnessReport(heights, weights);
    }
}
