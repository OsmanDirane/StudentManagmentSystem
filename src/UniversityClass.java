
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityClass {
// initializing variables

	ArrayList<Student> students = new ArrayList<>();
	private String name;
	Scanner input = new Scanner(System.in);
	public int studentType = 0;

	// no arg constructor
	public UniversityClass() {

	}

	// constructor to put students in array
	public UniversityClass(String name, int numofstudents) {

		this.name = name;
	}

//print title
	public void printTitle() {
		System.out.println(name + " List of Students\r\n"

				+ "************************************\r\n"

				+ "    Program|Student#|               Name|              Email|               Phone|       GPA|              Fees|    Credits| ");
	}

//reads student details
	public void readStudentsDetails() throws Exception {

		System.out.println("\n---------------\n1-Full Time\n2-Part Time\n---------------");

//		System.out.println("\n---------------\n2-Part Time\n---------------");
		while (!(studentType == 1 || studentType == 2)) {
			System.out.print("Enter Student type: ");
			studentType = input.nextInt();
			if (!(studentType == 1 || studentType == 2)) {
				System.err.print("Wrong Student Type ");
			}
		}
		Student student;
		if (studentType == 1) {
			student = new fullTimeStudent();
		} else {
			student = new partTimeStudent();
		}
		student.readInfo();
		students.add(student);
	}

	public void detailsFromFile(Scanner input) {
		while (input.hasNextLine()) {
			Student student;
			String employeeType = input.next();
			if (employeeType.equals("f")) {
				student = new fullTimeStudent();
			} else {
				student = new partTimeStudent();
			}
			student.readFromFile(input);
			students.add(student);
		}
	}

// prints info for student in array
	public void printStudentDetails() throws Exception {
		if (students.size() == 0) {
			System.err.print("No Students to Display..");
		} else { printTitle();
			for (int i = 0; i < students.size(); i++) {
				students.get(i).printInfo();
			}
		}
	}
}