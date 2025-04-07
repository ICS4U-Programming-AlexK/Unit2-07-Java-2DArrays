import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/**
 * This program populates an array with random numbers and sorts it.
 * It then calculates the average of the numbers in the array.
 * @author Alex Kapajika
 * @version 1.0
 * @since 2025-03-18
 */
public final class TwoDArrays {

    private static final int AVERAGE = 75;
    private static final int STD_DEV = 10;
    private static final int NUM_STUDENTS = 15;
    private static final int NUM_ASSIGNMENTS = 6;

    // Prevent instantiation
    private TwoDArrays() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * This method generates random numbers for the 2D array.
     * @param markStud
     */
    public static void numberGenerator(final String[][] markStud) {
        Random randomNum = new Random();
        for (int indexNum = 1; indexNum < markStud.length; indexNum++) {
            for (int indexNum2 = 1; indexNum2
             < markStud[0].length; indexNum2++) {
                int gradMark = (int) randomNum.nextGaussian() * STD_DEV + AVERAGE;
                markStud[indexNum][indexNum2] = String.valueOf(gradMark);
            }
        }
    }
    /**
     * This method is the main method that runs the program.
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        // Check if the correct number of arguments is provided.
        File studFile = new File("students.txt");
        File assignFile = new File("assignments.txt");
        // Create 2D array
        String[][] finalList = new String[NUM_STUDENTS][NUM_ASSIGNMENTS];
        // Correct Scanner usage
        Scanner studReader = new Scanner(studFile);
        Scanner assignReader = new Scanner(assignFile);
        FileWriter csvWriter = new FileWriter("marks.csv");
        finalList[0][0] = "Student Name";
        for (int indexNum = 1; indexNum < finalList.length; indexNum++) {
            finalList[indexNum][0] = studReader.nextLine();
        }
        for (int indexNum = 1; indexNum < finalList[0].length; indexNum++) {
            finalList[0][indexNum] = assignReader.nextLine();
        }
        numberGenerator(finalList);
        for (int indexNum = 0; indexNum < finalList.length; indexNum++) {
            for (int indexNum2 = 0; indexNum2
             < finalList[0].length; indexNum2++) {
                csvWriter.write(finalList[indexNum][indexNum2]);
                if (indexNum2 < finalList[0].length - 1) {
                    csvWriter.write(",");
                }
            }
            csvWriter.write("\n");
        }
        csvWriter.close();
        studReader.close();
        assignReader.close();
        // Print the 2D array
        System.out.println(Arrays.deepToString(finalList));
    }
}
