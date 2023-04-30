package main;

/* 4. 
 * Implement a class called UserFile (name, extension, type, size in bytes, constructors, mutators, accesors). The types of
 * files are predefined and stored in a Hashtable object (for example "image"->0, "text"->1, "application"->2, etc.) Create a
 * list of objects from this class and read from the keyboard the associated info. Print all the specific extensions of the
 * predefined file types. Order the file list based on size and print the result.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OvidiuGherman_Lab07_P04 {
    public static void main(String[] args) {
        ArrayList<UserFile> files = addFiles();
        orderFilesAndShow(files);
    }

    private static ArrayList<UserFile> addFiles() {
        ArrayList<UserFile> files = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of files: ");
            int noFiles = scanner.nextInt();
            for (int i = 0; i < noFiles; i++) {
                System.out.printf("\nFile %d\n", i + 1);
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Extension: ");
                String extension = scanner.next();
                System.out.print("Type (image, text or application): ");
                String type = scanner.next();
                while (!isValidType(type)) {
                    System.out.println("\nNot a valid input!\nTry again!");
                    System.out.print("Type (image, text or application): ");
                    type = scanner.next();
                }
                System.out.print("Enter file size in bytes: ");
                int sizeInBytes = scanner.nextInt();
                UserFile file = new UserFile(name, extension, type, sizeInBytes);
                files.add(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return files;
    }

    private static boolean isValidType(String type) {
        return type.equalsIgnoreCase("image")
                || type.equalsIgnoreCase("text")
                || type.equalsIgnoreCase("application");
    }

    private static void orderFilesAndShow(ArrayList<UserFile> files) {
        System.out.println("\nYour ordered list: ");
        Collections.sort(files);
        for (UserFile file : files) {
            System.out.printf("\nFile name: %s.%s\n", file.getName(), file.getExtension());
            System.out.printf("File size: %d bytes\n", file.getSizeInBytes());
        }
    }
}

class UserFile implements Comparable<UserFile> {
    private String name;
    private String extension;
    private String type;
    private int sizeInBytes;

    public UserFile(String name, String extension, String type, int sizeInBytes) {
        this.name = name;
        this.extension = extension;
        this.type = type;
        this.sizeInBytes = sizeInBytes;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public String getType() {
        return type;
    }

    @Override
    public int compareTo(UserFile file) {
        if (this.getSizeInBytes() != file.getSizeInBytes()) {
            return this.getSizeInBytes() - file.getSizeInBytes();
        } else {
            return this.getName().compareTo(file.getName());
        }
    }
}
