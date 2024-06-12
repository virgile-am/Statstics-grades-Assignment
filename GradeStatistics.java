import java.util.Scanner;

public class GradeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the grades separated by spaces:");
        String[] input = scanner.nextLine().split(" ");

        int[] scores = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }

        // Calculate max, min, and average
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int score : scores) {
            if (score > max) max = score;
            if (score < min) min = score;
            sum += score;
        }

        double average = (double) sum / scores.length;

        // Create stats array
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

        // Display max, min, and average
        System.out.printf("The maximum grade is %d%n", max);
        System.out.printf("The minimum grade is %d%n", min);
        System.out.printf("The average grade is %.6f%n%n", average);

        // Display bar graph
        System.out.println("Graph:");
        int maxBarHeight = 0;
        for (int stat : stats) {
            if (stat > maxBarHeight) maxBarHeight = stat;
        }

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
