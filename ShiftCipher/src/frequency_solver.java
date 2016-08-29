/**
 * Created by Ryan on 8/24/2016.
 *
 * The purpose of this class is to solve a shift cipher by using the
 * frequency count of each letter. It will brute force the solution
 * and print all of them to the display.
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class frequency_solver {
     static ArrayList<String> alpha = new ArrayList<>(Arrays.asList("a", "b",
             "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
             "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
     static ArrayList<Double> frequencies = new ArrayList<>(
             Arrays.asList(0.0817, 0.0150, 0.0278, 0.0425, 0.1270, 0.0223,
                     0.0202, 0.0609, 0.0697, 0.0015, 0.0077, 0.0403, 0.0241,
                     0.0675, 0.0751, 0.0193, 0.0010, 0.0599, 0.0633, 0.0906,
                     0.0276, 0.0098, 0.0236, 0.0015, 0.0197, 0.0007));
    /**
     * This function will find the frequency of each character and
     * change that character to the proper letter
     * Returns an array of the
     * @param cipherText - the encrypted text
     * @return - array of the frequency of each letter in encrypted text
     *
     */
    private static ArrayList<Double> findFrequency(String cipherText){
        //gather the number of occurrences of each letter
        ArrayList<Double> freqs = new ArrayList<>(26);
        for (int i = 0; i < 26; i++){
            freqs.add(i, 0.0);
        }
        int spaces = 0;
//        System.out.println(alpha.toString());
        for (int i = 0; i < cipherText.length(); i++){
            if (cipherText.charAt(i) == ' '){
                spaces++;
            } else {
//                System.out.print(cipherText.charAt(i) + "\t");
                int freqLoc = findSpot(cipherText.charAt(i));
//                System.out.print(freqLoc + "\t");
                double occurrences = freqs.get(freqLoc) + 1;
                freqs.add(freqLoc, occurrences);
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        for (int i = 0; i < freqs.size(); i++){
            double value = (freqs.get(i) / (cipherText.length() - spaces));
            freqs.set(i, Double.parseDouble(df.format(value)));
        }
        return freqs;
    }

    /**
     * This will search the alphabet arrary for char c's position
     * @param c - the character to find
     * @return - the position to be used to reference c's position in alphabet
     */
    private static int findSpot(char c) {
//        System.out.print(c + "\t");
        String s = c + "";
        return alpha.indexOf(s);
    }

    /**
     *
     * @param freqs
     * @return - the unencrypted string
     */
    private static String solve(String encrypted, double[] freqs) {
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < encrypted.length(); i++) {
            if (encrypted.charAt(i) == ' ') {
                answer.append(' ');
            } else {
                // numeric location of letter in alphabet
                int letterNum = findSpot(encrypted.charAt(i));
                for (int c = 0; c < frequencies.size(); i++) {
                    if (freqs[letterNum] == frequencies.get(c)) {
                        answer.append(alpha.get(c));
                    }
                }
            }
        }
        return answer.toString();
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

        ArrayList<Double> resFreq = findFrequency(cipherText);
        System.out.println(frequencies.toString() + "\n" + alpha.toString() +
                "\n" + resFreq.toString());
//        System.out.println( solve(cipherText, resFreq));
    }
}
