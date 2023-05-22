package lab2;

import java.util.Random;
import java.util.Scanner;

public class lab2 {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width, height;

        // Read matrix dimensions from the user
        System.out.print("Enter the width of the matrix (not more than 20): ");
        width = readMatrixDimension(scanner);
        System.out.print("Enter the height of the matrix (not more than 20): ");
        height = readMatrixDimension(scanner);

        // Create the matrix
        int[][] matrix;
        if (width <= 0 || height <= 0) {
            System.out.println("Invalid matrix dimensions.");
            return;
        } else if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Matrix dimensions exceed the maximum size of 20x20.");
            return;
        } else {
            matrix = createMatrix(width, height, scanner);
        }

        // Calculate the average value of the matrix
        double average = calculateAverage(matrix);

        // Find the maximum and minimum elements of the matrix
        int maximum = findMaximum(matrix);
        int minimum = findMinimum(matrix);

        // Print the matrix and calculated values
        System.out.println("\nMatrix:");
        printMatrix(matrix);
        System.out.println("Average value: " + average);
        System.out.println("Maximum value: " + maximum);
        System.out.println("Minimum value: " + minimum);
    }

    private static int readMatrixDimension(Scanner scanner) {
        int dimension = 0;
        while (dimension <= 0) {
            if (scanner.hasNextInt()) {
                dimension = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } else {
                scanner.nextLine(); // Consume invalid input
            }

            if (dimension <= 0) {
                System.out.println("Invalid dimension. Please enter a positive integer.");
                System.out.print("Enter the dimension again: ");
            }
        }
        return dimension;
    }

    private static int[][] createMatrix(int width, int height, Scanner scanner) {
        int[][] matrix = new int[height][width];

        System.out.println("\nEnter the matrix elements:");
        System.out.println("1. Manually");
        System.out.println("2. Randomly");
        System.out.print("Choose an option (1 or 2): ");

        int option = 0;
        while (option != 1 && option != 2) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } else {
                scanner.nextLine(); // Consume invalid input
            }

            if (option != 1 && option != 2) {
                System.out.println("Invalid option. Please choose 1 or 2.");
                System.out.print("Choose an option again: ");
            }
        }

        if (option == 1) {
            // Manual input
            System.out.println("Enter the matrix elements row by row:");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                    matrix[i][j] = scanner.nextInt();
                }
            }
        } else {
            // Random generation
            Random random = new Random();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
                }
            }
        }

        return matrix;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        if (count > 0) {
            return (double) sum / count;
        } else {
            return 0.0;
        }
    }

    private static int findMaximum(int[][] matrix) {
        int maximum = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element > maximum) {
                    maximum = element;
                }
            }
        }

        return maximum;
    }

    private static int findMinimum(int[][] matrix) {
        int minimum = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < minimum) {
                    minimum = element;
                }
            }
        }

        return minimum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}

