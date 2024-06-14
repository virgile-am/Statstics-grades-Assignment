import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {
        // Main function to run the program
        int[] scores = inputGrades();
        displayStatistics(scores);
    }

    // Function to input grades
    private static int[] inputGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the grades separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] scores = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }
        return scores;
    }

    // Function to calculate and display statistics
    private static void displayStatistics(int[] scores) {
        int max = findMax(scores);
        int min = findMin(scores);
        double average = calculateAverage(scores);
        int[] gradeDistribution = calculateGradeDistribution(scores);

        System.out.printf("The maximum grade is %d%n", max);
        System.out.printf("The minimum grade is %d%n", min);
        System.out.printf("The average grade is %.6f%n%n", average);

        displayGraph(gradeDistribution);
    }

    // Function to find the maximum grade
    private static int findMax(int[] scores) {
        int max = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // Function to find the minimum grade
    private static int findMin(int[] scores) {
        int min = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    // Function to calculate the average grade
    private static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    // Function to calculate the grade distribution
    private static int[] calculateGradeDistribution(int[] scores) {
        int[] stats = new int[5];
        for (int score : scores) {
            if (score >= 81) {
                stats[4]++;
            } else if (score >= 61) {
                stats[3]++;
            } else if (score >= 41) {
                stats[2]++;
            } else if (score >= 21) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }
        return stats;
    }

    // Function to display the bar graph
    private static void displayGraph(int[] stats) {
        int maxBarHeight = findMax(stats);
        System.out.println("Graph:");
        for (int i = maxBarHeight; i > 0; i--) {
            System.out.printf("%2d  > ", i);
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print(" ####### ");
                } else {
                    System.out.print("         ");
                }
            }
            System.out.println();
        }
        System.out.println("    +-----------+---------+---------+---------+---------+");
        System.out.println("    I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");
    }
}
