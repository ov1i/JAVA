package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* 4.
 *  You are given a binary file which contains a sequence of characters representing a private Bitcoin key (256 characters).
 *  From the keyboard read a sequence of characters which represents the public key for a Bitcoin. Generate the
 *  transaction id for this information by using the XOR bitwise operator applied upon the private and public keys. Write the
 *  result in another binary file. 
 */

public class OvidiuGherman_Lab08_P04 {

	public static void main(String[] args) {
		try {		
			FileInputStream privateKeyFile = new FileInputStream("mykey.bin");
			byte[] privateKey = privateKeyFile.readNBytes(256);
			System.out.println("Private key read succesfully!");
			privateKeyFile.close();

			System.out.print("Please enter a public key: ");
			Scanner scanner = new Scanner(System.in);
			String strPublicKey = scanner.next();
			scanner.close();

			byte[] publicKey = strPublicKey.getBytes();
			byte[] id = new byte[privateKey.length];

			for (int i = 0; i < privateKey.length; i++) {
				for(int j = 0; j < publicKey.length; j++) {
					id[i] = (byte) (privateKey[i] ^ publicKey[j]);
				}
			}

			FileOutputStream transactionFile = new FileOutputStream("id.bin");

			transactionFile.write(id);
			transactionFile.close();

			System.out.println("ID written to id.bin succesfully!");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
