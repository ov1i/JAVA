package mypkg;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Write a Java application which defines an authentication key with the format: XXXXX-XXXXX-XXXXX-XXXXX,
 * where X is a character which can be either a digit or a letter. The application should verify if this key has exactly
 * 4 groups of characters with 5 characters each, and separated by the symbol ‘-‘. Also, compute the number of
 * digits and letters from the authentication key. The number of digits should be greater than the number of
 * letters, and the number of letters cannot be 0.
 * If any of the above conditions are not met, display the message: “Invalid authentication key!”
 */

class AuthKey{
	private StringTokenizer key;
	AuthKey(String key) {
		this.key = new StringTokenizer(key,"-");
	}
	public boolean checkValid() {
		int countDigits = 0;
		int countChar = 0;
		if(key.countTokens() != 4) {
			return false;
		}
		while(key.hasMoreTokens()) {
			String token = key.nextToken();
			if(token.length() != 5) {
				return false;
			}
			else {
				for(int i = 0;i<token.length();i++) {
					if(Character.isDigit(token.charAt(i))) {
						countDigits++;
					}
					else if(Character.isAlphabetic(token.charAt(i))) {
						countChar++;
					}
				}
			}
		}
		
		if(countDigits < countChar || countChar == 0) {
			return false;
		}
		
		return true;
	}
}

public class OvidiuGherman_Lab04_P08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String key;
		do {
			System.out.print("Please enter the key: ");
			key = scanner.nextLine();
			if(!key.matches("[A-Za-z0-9-]+")) {
				key = "\0";
			}	
		}while(key.length() != 23);
		scanner.close();
		
		AuthKey authKey = new AuthKey(key);
		
		if(authKey.checkValid() == false) {
			System.out.println("Invalid authentication key!");
		}
		else {
			System.out.println("The authentication key is valid!");
		}
	}

}
