package com.dogus;
/**
 * <h1> Creates Cipher </h1>
 * This program implements encryption and decryption approach.
 * There are 2 methods within this program for this purpose.
 * The program allows us to print the results in a file.
 *
 * @author Humeyra Dogus 
 * @version 1.0
 * @since 2020-12-19
 */
import java.io.*;

public class Cipher {
    public static String encrypted (String plaintext, int shift,String filename){
        /**
         * This method is used to Encrypt the file.
         * @param args nothing
         * @return nothing
         */
        String ciphertext = ""; // creates empty String for ciphertext
        char alphabet;

        for(int i=0; i < plaintext.length();i++) {
            alphabet = plaintext.charAt(i); // shifts each character

            if(alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char) (alphabet + shift);

                if(alphabet > 'z') {
                    alphabet = (char) (alphabet+'a'-'z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }

            else if(alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet + shift);

                if(alphabet > 'Z') {
                    alphabet = (char) (alphabet+'A'-'Z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }

            else {
                ciphertext = ciphertext + alphabet;
            }
        }

        System.out.print("Done! File mytext.txt encrypted and saved."); // displays on the screen
        // try catch block to write in the file
        try(FileWriter fw = new FileWriter(filename, true); //true statement allows to add new strings in the file
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw))
        {
            pw.println(ciphertext); // prints the ciphertext
        }
        catch (IOException e) {
            //exception handling
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ciphertext; // return statement
    }

    public static String decrypted(String ciphertext2, int shift, String filename) {
        /**
         * This method is used to Decrypt the file.
         * @param args nothing
         * @return nothing
         */
        String decryptMessage = ""; // creates empty String for decryptMessage

        for(int i=0; i < ciphertext2.length();i++) {
            char alphabet2 = ciphertext2.charAt(i);
            if(alphabet2 >= 'a' && alphabet2 <= 'z') {
                alphabet2 = (char) (alphabet2 - shift);

                if(alphabet2 < 'a') {
                    alphabet2 = (char) (alphabet2-'a'+'z'+1); // reshifts
                }
                decryptMessage = decryptMessage + alphabet2;
            }

            else if(alphabet2 >= 'A' && alphabet2 <= 'Z') {
                alphabet2 = (char) (alphabet2 - shift);

                if (alphabet2 < 'A') {
                    alphabet2 = (char) (alphabet2-'A'+'Z'+1);
                }
                decryptMessage = decryptMessage + alphabet2;
            }

            else {
                decryptMessage = decryptMessage + alphabet2;
            }
        }
        System.out.print("Done! File mytext.txt decrypted and saved! "); // displays on the screen
        // try catch block to write in the file
        try(FileWriter fw = new FileWriter("mytext.txt", true); //true statement allows to add new strings in the file
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw))
        {
            pw.println(decryptMessage); // prints the decryptMessage
        }
        catch (IOException e) {
            //exception handling
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return decryptMessage;
    }
}
