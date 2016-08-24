/**
 * Created by Ryan on 8/24/2016.
 *
 * The purpose of this class is to solve a shift cipher by using the
 * frequency count of each letter. It will brute force the solution
 * and print all of them to the display.
 */

import java.util.Scanner;

public class frequency_solver {
    char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
    double[] freqs = {0.0817, 0.0150, 0.0278, 0.0425, 0.1270, 0.0223,
            0.0202, 0.0609, 0.0697, 0.0015, 0.0077, 0.0403, 0.0241,
            0.0675, 0.0751, 0.0193, 0.0010, 0.0599, 0.0633, 0.0906,
            0.0276, 0.0098, 0.0236, 0.0015, 0.0197, 0.0007};
    /**
     * This function will find the frequency of each character and
     * change that character to the proper letter
     * @param cipherText - the encrypted text
     */
    private static void findFrequency(String cipherText){

        }

    /**
     * Runs the whole program, gets user input
     * @param args - not used
     */
    public static void main(String[] args){
        // To make a range when checking for frequency
        double variation = 0.0010;

        // Get user input to crack
        Scanner scn = new Scanner(System.in);
        scn.useDelimiter("\n");
        String cipherText = scn.next();

        findFrequency(cipherText);

        System.out.println(cipherText);
    }
}
