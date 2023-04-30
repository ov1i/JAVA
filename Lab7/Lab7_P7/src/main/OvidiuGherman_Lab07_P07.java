package main;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/* 7. 
 * Create a generic class called VirtualLibrary that manages a SortedSet of entries. The types of entries are Book, Article,
 * MediaResource, Magazine and Manual. Implement the specific classes for each type of entry, each of them being a subclass of Publication.
 * The VirtualLibrary has methods to add, add multiple, return a specific entry and check if an entry exists in the library.
 * In the main() method, create an instance of VirtualLibrary and use the offered facilities.
 */

class VirtualLibrary <T extends Publication> {
	private SortedSet<T> entries;

	public VirtualLibrary() {
		entries = new TreeSet<>();
	}
	public void add(T entry) {
		entries.add(entry);
	}
	public void add_multiple(TreeSet<T> entries) {
		this.entries.addAll(entries);
	}
	@SuppressWarnings("unchecked")
	public T getEntry(int i) throws ArrayIndexOutOfBoundsException{
		return (T) entries.toArray()[i];
	}
	public boolean checkEntry(T entry) {
		return entries.contains(entry);
	}
}

class Publication implements Comparable<Publication>{
	private String name;
	@Override
	public int compareTo(Publication o) {		
		return this.getName().compareTo(o.getName());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
class Book extends Publication{}
class Article extends Publication{}
class MediaResource extends Publication{}
class Magazine extends Publication{}
class Manual extends Publication{}

public class OvidiuGherman_Lab07_P07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VirtualLibrary<Publication> e_Library = new VirtualLibrary<>();
		Publication obj;
		String input;
		boolean running = true;
		System.out.println("Type \"help\" to see the avialable commands");
		while(running) {
			System.out.print("Please enter a command: ");
			input = scanner.nextLine();
			switch(input.toLowerCase()) {
			case "bye":
				System.out.println("Goodbye!");
				running = false;
				break;
			case "book":
				obj = new Book();
				System.out.print("Please enter the name of the book: ");
				obj.setName(scanner.nextLine());
				e_Library.add(obj);
				break;
			case "article": 
				obj = new Article();
				System.out.print("Please enter the name of the article: ");
				obj.setName(scanner.nextLine());
				e_Library.add(obj);
				break;
			case "mediaresource": 
				obj = new MediaResource();
				System.out.print("Please enter the name of the media resource: ");
				obj.setName(scanner.nextLine());
				e_Library.add(obj);
				break;
			case "magazine": 
				obj = new Magazine();
				System.out.print("Please enter the name of the magazine: ");
				obj.setName(scanner.nextLine());
				e_Library.add(obj);
				break;
			case "manual": 
				obj = new Manual();
				System.out.print("Please enter the name of the manual: ");
				obj.setName(scanner.nextLine());
				e_Library.add(obj);
				break;	
			case "check": 
				System.out.print("Please enter what product you are looking for: ");
				String product = scanner.nextLine();
				switch(product.toLowerCase()) {
				case "book":
					obj = new Book();
					System.out.print("Please enter the name of the book you are searching for: ");
					obj.setName(scanner.nextLine());			
					if(e_Library.checkEntry(obj)) {
						System.out.println("We have the book in stock!");
					}
					else {
						System.out.println("I'm sorry we don't have the book in stock!");
					}
					break;
				case "article":
					obj = new Article();
					System.out.print("Please enter the name of the article you are searching for: ");
					obj.setName(scanner.nextLine());			
					if(e_Library.checkEntry(obj)) {
						System.out.println("We have the article in stock!");
					}
					else {
						System.out.println("I'm sorry we don't have the article in stock!");
					}
					break;
				case "mediaresource":
					obj = new MediaResource();
					System.out.print("Please enter the name of the media resource you are searching for: ");
					obj.setName(scanner.nextLine());			
					if(e_Library.checkEntry(obj)) {
						System.out.println("We have the media resource in stock!");
					}
					else {
						System.out.println("I'm sorry we don't have the media resource in stock!");
					}
					break;
				case "magazine":
					obj = new Magazine();
					System.out.print("Please enter the name of the magazine you are searching for: ");
					obj.setName(scanner.nextLine());			
					if(e_Library.checkEntry(obj)) {
						System.out.println("We have the magazine in stock!");
					}
					else {
						System.out.println("I'm sorry we don't have the magazine in stock!");
					}
					break;
				case "manual":
					obj = new Manual();
					System.out.print("Please enter the name of the manual you are searching for: ");
					obj.setName(scanner.nextLine());			
					if(e_Library.checkEntry(obj)) {
						System.out.println("We have the manual in stock!");
					}
					else {
						System.out.println("I'm sorry we don't have the manual in stock!");
					}
					break;		
				}
				break;
			case "get" :
				System.out.print("Please tell me the the location of the desired product(int): ");
				int index = scanner.nextInt();
				scanner.nextLine();
				try {
					System.out.println("The title of the product is: " + e_Library.getEntry(index).getName());
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("I'm sorry we don't have such a location in our library!");
				}
				break;
			case "addmultiple":
				System.out.print("Please enter how many products you want to add in the library: ");
				int count = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Please enter what type of products we'll add: ");
				String prod = scanner.nextLine();				
				TreeSet<Publication> list = new TreeSet<>();
				switch(prod.toLowerCase()) {
				case "book":
					for(int i = 0; i < count;i++) {
						obj = new Book();
						System.out.print("Please enter the name of the book " + (i+1) + " : ");
						obj.setName(scanner.nextLine());	
						list.add(obj);
					}
					break;
				case "article":
					for(int i = 0; i < count;i++) {
						obj = new Article();
						System.out.print("Please enter the name of the article " + (i+1) + " : ");
						obj.setName(scanner.nextLine());	
						list.add(obj);
					}
					break;
				case "mediaresource":
					for(int i = 0; i < count;i++) {
						obj = new MediaResource();
						System.out.print("Please enter the name of the media resource " + (i+1) + " : ");
						obj.setName(scanner.nextLine());	
						list.add(obj);
					}
					break;
				case "magazine":
					for(int i = 0; i < count;i++) {
						obj = new Magazine();
						System.out.print("Please enter the name of the magazine " + (i+1) + " : ");
						obj.setName(scanner.nextLine());	
						list.add(obj);
					}
					break;
				case "manual":
					for(int i = 0; i < count;i++) {
						obj = new Manual();
						System.out.print("Please enter the name of the manual " + (i+1) + " : ");
						obj.setName(scanner.nextLine());	
						list.add(obj);
					}
					break;
			}
			e_Library.add_multiple(list);
			break;
		case "help":
			System.out.println("Commands: Book, Article, MediaResource, Magazine, Manual, Get, Check, AddMultiple, Bye");
			break;
		}
	}

	scanner.close();
}

}
