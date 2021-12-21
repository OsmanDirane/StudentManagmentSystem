
import java.util.Scanner;

public class Student implements Person {
	// declare variables
	public static String checkData;
	protected String firstName;
	protected String lastName;
	protected String emailID;
	protected long phoneNumber;
	protected int studentNumber;
	protected String programName;
	protected double gpa;
	public static String data;

	protected Scanner input = new Scanner(System.in);

	@Override
	public void readInfo() {

		// Prompting user and input

		System.out.print("Enter Program name: ");
		programName = input.nextLine();
		System.out.print("Enter Student Number: ");
		studentNumber = input.nextInt();
		input.nextLine();
		System.out.print("Enter First Name: ");
		firstName = input.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = input.nextLine();
		System.out.print("Enter Email ID: ");
		emailID = input.nextLine();
		System.out.print("Enter Phone number: ");
		phoneNumber = input.nextLong();
		checkData = firstName;
		readMarks();
		//data = " " + programName + " " + studentNumber + " " + firstName + "-" + lastName + " " + emailID + " "
		//		+ phoneNumber + " " + (Math.round(gpa * 100.0) / 100.0);
//		System.out.println();
	}

	@Override
	public void printInfo() {
		// prints this students information

//		System.out.println("Testing");

		System.out.printf("%11s|%8s|%19s|%19s|%20s|%10s|", programName, studentNumber, firstName + " " + lastName,
				emailID, phoneNumber, gpa);
	}

//
	//public static String getData() {
		//return data;
	//}

	private void readMarks() {

		System.out.print("Enter number of courses: ");
		// array of marks
		int courses = input.nextInt();
		double[] marks = new double[courses];
		for (int i = 0; i < marks.length; i++) {
			System.out.print("Enter mark " + (i + 1) + ": ");
			marks[i] = input.nextDouble();
		}
		calculateGpa(marks);
	}

	public void calculateGpa(double[] array) {
		// calculating gpa
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		gpa = total / 25 / array.length;
		gpa = Math.round(gpa * 100.0) / 100.0;
	}

	@Override
	public void readFromFile(Scanner input) {
		studentNumber = input.nextInt();
        firstName = input.next();
        lastName = input.next();
        emailID = input.next();
        phoneNumber = input.nextLong();
        programName = input.next();
        gpa = input.nextDouble();
       
       
	}

}
