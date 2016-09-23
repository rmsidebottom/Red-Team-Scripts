import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This will brute force the encrypted cipher as long as it was a shift cipher.
 * It ignores spaces.
 * Created by Ryan on 9/22/2016.
 */
public class theBrute {
    private static final ArrayList<String> chars = new ArrayList<>(Arrays.asList
            ("!", "@", "#", "$", "$", "%", "^", "&", "*", "(", ")", "{", "[",
                    "]", "}", "\\", "|", "-", "_", "+", "=", "~", "`", ":", ";",
                    ",", "<", ".", ">", "/", "?", "'", "\""));
    /**
     * This function solves the cipher, or at least traverses the cipher, then
     * calls for the manipulation of the text.
     * Recursive function, breaks when shift reaches 0
     * @param cipher the encrypted text
     * @param shift the amount of characters to shift each letter
     */
    private static void solve(String cipher, int shift){
        if (shift == 0){
            return;
        }
        System.out.println("Plaintext with shift of " + shift + ":");
        StringBuffer plaintext = new StringBuffer("");
        //cipher = cipher.toLowerCase();

        for(int i = 0; i < cipher.length(); i++){
            /*if(cipher.charAt(i) == 'a'){
                char temp = 'z';
                int tShift = shift - 1;
                temp = (char)((int)temp - tShift);
                plaintext.append(temp);
            } else*/ if(chars.contains(cipher.charAt(i))){
                plaintext.append(cipher.charAt(i));
            } else {
               plaintext.append(manipulate(cipher.charAt(i), shift));
            }
        }

        System.out.println(plaintext.toString());

        solve(cipher, shift- 1);
    }

    private static char manipulate(char e, int shift){
        for(int i = shift; i > 0; i--){
            if(e == 'a'){
                e = 'z';
                i = i -1;
            } else if (e == 'A'){
                e = 'Z';
                i = i -1;
            }

            e = (char)((int)e - 1);
        }
        return e;
    }

    /**
     * Main function for theBrute, will execute solution
     * @param args not used
     */
    public static void main(String[] args){
        System.out.println("Enter the encrypted text:");
        Scanner scn = new Scanner(System.in);
        scn.useDelimiter("\n");
        String cipher = scn.next();

        solve(cipher, 25);
    }
}
