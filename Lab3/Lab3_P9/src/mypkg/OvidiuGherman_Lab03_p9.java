package mypkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Define an array of String variables that will be populated with all the playing cards from a complete package. A
 * series of randomly picked cards will be extracted until the current card will have the clubs sign and a value
 * greater than 8. At each step, the current card and the number of already extracted cards will be displayed.
 */

public class OvidiuGherman_Lab03_p9 {
	static int k = 0;
	static void populateArray(String [] strings, String name) {
		int i = 0;
		while(i < 13) {
			if(i + 2 == 11) {
				strings[k] = name + "J";
			}
			else if (i + 2 == 12) {
				strings[k] = name + "Q";
			}
			else if (i + 2 == 13) {
				strings[k] = name + "K";
			}
			else if (i + 2 == 14) {
				strings[k] = name + "A";
			}
			else {
				strings[k] = name + (i + 2);
			}
			i++;
			k++;
		}
	}
	
	static boolean findCard(String [] strings, int card) {
		String tempStrings[] = strings[card].split("\\s");
		int nr = -1;
		try { 
			nr = Integer.parseInt(tempStrings[1]);
		} catch(NumberFormatException ioe) {
			if(tempStrings[1].equals("A")) {
				nr = 13;
			}
			else if(tempStrings[1].equals("J")) {
				nr = 11;
			}
			else if(tempStrings[1].equals("Q")) {
				nr = 12;
			}
			else if(tempStrings[1].equals("K")) {
				nr = 13;
			}
		}
		
		if(tempStrings[0].equals("Clubs") && nr > 8) {
			System.out.println(strings[card]);
			return true;
		}
		else {
			System.out.println(strings[card]);
			return false;
		}
	}
	
	public static void main(String[] args) {
		String strings[] = new String[52];
		
		populateArray(strings, "Spades ");
		populateArray(strings, "Clubs ");
		populateArray(strings, "Hearts ");
		populateArray(strings, "Diamonds ");
		
		Random random = new Random();
		Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
		do {
			int card = random.nextInt(0,52);
			if(!hashMap.containsKey(card)){
				if(findCard(strings, card)) {
					break;
				}
				hashMap.put(card, card);
				}
		} while(true);
	}

}
