package mypkg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Scanner;

/* 4. 
 * Implement a class called UserFile (name, extension, type, size in bytes, constructors, mutators, accesors). The types of
 * files are predefined and stored in a Hashtable object (for example "image"->0, "text"->1, "application"->2, etc.) Create a
 * list of objects from this class and read from the keyboard the associated info. Print all the specific extensions of the
 * predefined file types. Order the file list based on size and print the result.
 */


class UserFile {
	private String name;
	private String extension;
	private String type;
	private Hashtable<String, Integer> types;
	private int sizeInBytes;

	public UserFile() {
		this.name = null;
		this.type = null;
		this.extension = null;
		this.types = new Hashtable<String, Integer>() {{ 
			put("imgae", 0);
			put("executable", 1);
			put("binary", 2);
			put("text", 3);
		}};
		this.sizeInBytes = 0;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type.toLowerCase();
	}
	public int getSizeInBytes() {
		return sizeInBytes;
	}
	public void setSizeInBytes(int sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}
	public boolean checkType() {
		return this.types.containsKey((String)this.type);
	}
}

public class OvidiuGherman_Lab07_P04 {
	public static void main(String[] args) {
		
		Comparator<UserFile> comparator = new Comparator<UserFile>() {
			@Override
			public int compare(UserFile f1, UserFile f2) {
				if(f1.getSizeInBytes() > f2.getSizeInBytes())
					return 1;
				else if(f1.getSizeInBytes() < f2.getSizeInBytes())			
					return -1;		
				else
					return 0;
			}
		};
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<UserFile> files = new ArrayList<>();
		System.out.print("Please enter the number of files: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			UserFile tempObj = new UserFile();
			System.out.print("File " + (i + 1) + "\n");
			System.out.print("Please enter the name of the file: ");
			tempObj.setName(scanner.nextLine());
			System.out.print("Please enter the extension of the file: ");
			tempObj.setExtension(scanner.nextLine());
			System.out.print("Please enter the type of the file(Predefined values: Image, Binary, Executable, Text): ");
			tempObj.setType(scanner.nextLine());
			System.out.print("Enter file size in bytes: ");
			tempObj.setSizeInBytes(scanner.nextInt());
			scanner.nextLine();
			
			files.add(tempObj);
		}
		scanner.close();
		
		System.out.println("Predefined data extension: ");
		for (UserFile o : files) {
			if(o.checkType()) {
				 System.out.print("File: "+o.getName() + " -> Type: " + o.getType() + " -> Extension: " + o.getExtension() + "\n");
			}
		}
		
		
		System.out.println("Sorted list: ");
		files.sort(comparator);
		for (UserFile o : files)
	         System.out.print("File: "+o.getName() + " -> Size: " + o.getSizeInBytes() + " bytes\n");
	}
}

