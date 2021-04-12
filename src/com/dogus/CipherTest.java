package com.dogus;
/**
 * <h1> Creates CipherTest </h1>
 * This program implements an easy encryption approach is
 * called Caesar cipher, which uses a key to encrypt messages.
 *
 * @author Humeyra Dogus - 20181701057
 * @version 1.0
 * @since 2020-12-19
 */

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class CipherTest {

    public static void main(String[] args) throws IOException {
        /**
         * This method is the main method, which takes the input
         * to choice Encrypt or Decrypt the file. Also, this method
         * takes the file name to write the encrypted or decrypted
         * file.
         * @param args nothing
         * @return nothing
         */

        System.out.println("Greetings, what would you like to do?");
        System.out.println("1 - Encrypt the file");
        System.out.println("2 - Decrypt the file");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        Cipher test = new Cipher();

        System.out.println("Please provide the file name.");
        String fileName = input.next();
        String plaintext = "";
        Scanner secondInput = new Scanner(Paths.get(fileName));
        while (secondInput.hasNext()) {
            plaintext = plaintext + (secondInput.next()+" ");
        }

        if (choice == 1){ // if user enter 1, then the program calls the encrypted method to encrypt
            Scanner scan = new Scanner(System.in);
            System.out.println("What will be your key?");
            int shift = scan.nextInt();

            test.encrypted(plaintext,shift, fileName); // calls the method
            System.out.println();
        }

        if (choice == 2){ // if user enter 2, then the program calls the decrypted method to decrypt
            Scanner scan2 = new Scanner(System.in);
            System.out.println("What was the key you used to encrypt this file?");
            int shift2 = scan2.nextInt();

            test.decrypted(plaintext, shift2, fileName); // calls the method
        }
    }
}
