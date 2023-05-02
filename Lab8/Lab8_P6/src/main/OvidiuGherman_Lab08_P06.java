package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 6. 
 * You are given a *.csv file which contains the following fields separated by the "/" symbol: name, surname, phone
 * number, date of birth, link to Facebook profile. Read the information in the file and generate individual files containing
 * the following information: people born in December, people whose phone numbers are international (not Romanian) or
 * are landline numbers, people named Andrei and Nicolae and people whose Facebook profile link is not customised (have
 * a random sequence of digits at the end of the link).
 */
class Person{
	private String name;
	private String surname;
	private String dateOfBirth;
	private String link;
	private String phone_no;

	public Person(String name, String surname, String phone_no, String dateOfBirth, String link) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.link = link;
		this.phone_no = phone_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}

public class OvidiuGherman_Lab08_P06 {

	static void printData(List<Person> in, BufferedWriter id, String className) {
		try {
			for(Person obj : in) {
				id.write(className + ": ->" + obj.getName() + "/" + obj.getSurname() + "/" + obj.getPhone_no() + "/" + obj.getDateOfBirth() + "/" + obj.getLink() + "\n");

			}
			id.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {	
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader("data.csv"));	
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read the file!");
		}

		ArrayList<Person> persons = new ArrayList<>();

		String line = null;
		try {
			while ((line = buffer.readLine()) != null) {
				String[] fields = line.split("/");
				persons.add(new Person(fields[0], fields[1], fields[2], fields[3], fields[4]+"/"+fields[5]));
			} 
			buffer.close();
			System.out.println("Data read succesfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Person> bornInDecember = new ArrayList<>();
		List<Person> internationalNumbers = new ArrayList<>();
		List<Person> namedAndreiNicolae = new ArrayList<>();
		List<Person> nonCustomFacebookLinks = new ArrayList<>();
		String[] substr = null;
		for(Person obj : persons) {
			substr = obj.getDateOfBirth().split("-");
			if(substr[1].equalsIgnoreCase("12")) {
				bornInDecember.add(obj);
			}
			if(obj.getPhone_no().length() != 10) {
				internationalNumbers.add(obj);
			}
			if(obj.getName().equalsIgnoreCase("Andrei") || obj.getName().equalsIgnoreCase("Nicolae")) {
				namedAndreiNicolae.add(obj);
			}
			substr = obj.getLink().split("/");
			if(substr[1].matches("\\d+")) {
				nonCustomFacebookLinks.add(obj);
			}
		}

		try {
			printData(bornInDecember, new BufferedWriter(new FileWriter("bornInDecember.csv")), "bornInDecember");
			printData(internationalNumbers, new BufferedWriter(new FileWriter("internationalNumbers.csv")), "internationalNumbers");
			printData(namedAndreiNicolae, new BufferedWriter(new FileWriter("namedAndreiNicolae.csv")), "namedAndreiNicolae");
			printData(nonCustomFacebookLinks, new BufferedWriter(new FileWriter("nonCustomFacebookLinks.csv")), "nonCustomFacebookLinks");  
			System.out.println("Wrote data to the new files succesfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
