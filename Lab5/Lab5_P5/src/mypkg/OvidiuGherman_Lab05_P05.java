package mypkg;

import java.util.Arrays;

/* 5. 
 * Define a String Array. Using lambda expressions sort it by the following criteria: length (small->large), inverse length
 * (large->small), alphabetical order, the strings which start with the letter M are first, then come the rest.
 */
public class OvidiuGherman_Lab05_P05 {
	public static void displayStrings(String[] strings) {
		for(String str : strings) {
			System.out.print("\"" + str + "\"\t");
		}
	}
	public static void main(String[] args) {
		String[] strings = {"COME", "MAYBE","MB", "MDA", "ZMEU", "MORE"};
	
		//Original strings
		System.out.println("::THE STRINGS UNSORTED::");
		displayStrings(strings);
		
		//Sorted small->large
		System.out.println("\n\n::THE STRINGS SORTED(SMALL->LARGE)::");
		Arrays.sort(strings, (str1,str2) -> str1.length() - str2.length());
		displayStrings(strings);
		
		//Sorted large-small
		System.out.println("\n\n::THE STRINGS SORTED(LARGE->SMALL)::");
		Arrays.sort(strings, (str1, str2) -> str2.length() - str1.length());
		displayStrings(strings);
		
		//Sorted alphabetically
		System.out.println("\n\n::THE STRINGS SORTED(ALPHABETICALLY)::");
		Arrays.sort(strings, (str1,str2) -> str1.compareTo(str2));
		displayStrings(strings);
		
		//Sorted alphabetically(reversed)
		System.out.println("\n\n::THE STRINGS SORTED(ALPHABETICALLY REVERSED)::");
		Arrays.sort(strings, (str1,str2) -> str2.compareTo(str1));
		displayStrings(strings);
		
		//Sorted after first letter
		System.out.println("\n\n::THE STRINGS SORTED(AFTER THE FIRST LETTER)::");
		Arrays.sort(strings, (str1,str2) -> {
			if(str1.charAt(0) != 'M' && str2.charAt(0) == 'M') {
				return 1;
			}
			else return str1.compareTo(str2);
		});
		displayStrings(strings);
	}
}
