package mypkg;

/* 10. 
 * Consider a package of classes and interfaces called dbInteraction that simulates a database interaction based on a
 * user authentication mechanism. The package includes the following components:
 * 			- a class that defines objects of type Person with the private attributes: name, surname, e-mail address, userID and password along with the getter and setter methods
 * 			- an interface with the methods createUser(), deleteUser() and login(). All methods return a boolean value that represent the success state of the corresponding operation. 
 * 			The first 2 methods take as input a Person object. The 3rd method receives as parameters a userID and a password.
 * 			- an abstract class VerifyPerson that extends the Person class and implements the methods that check the formats of the name, surname and e-mail address with the following specs:
 * 					->the name and surname can only contain alphabetic characters
 * 					->the length of the name and surname cannot be greater than 50 characters
 * 					->the e-mail address should be formatted as: [a-zA-Z._]@[a-zA-Z.].[a-zA-Z]{2-5}
 * 			- the abstract class declares but does not implement the the methods for checking the userID and the password
 * 			- a class that extends the abstract class Verify and implements the check methods for userID and password according to the following specs:
 * 					->The userID can only contain alphanumeric symbols plus the “.” symbol
 * 					->The password should be at least 8 characters long, with at lease one upper-case symbol and a non-alphanumeric symbol
 * Write a Test class that manages a list of persons and uses all the functionalities implemented in the package.
 */

public class OvidiuGherman_Lab06_P10 {

	public static void main(String[] args) {
		

	}

}
