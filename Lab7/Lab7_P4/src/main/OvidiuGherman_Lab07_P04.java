package main;

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
	private byte size;
	
	public UserFile() {
		this.name = null;
		this.extension = null;
		this.type = null;
		this.size = 0;
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
		this.type = type;
	}

	public byte getSize() {
		return size;
	}

	public void setSize(byte size) {
		this.size = size;
	}
}

public class OvidiuGherman_Lab07_P04 {

	public static void main(String[] args) {
		byte e = 127;
		System.out.println(e);
	}

}
