
import java.util.Scanner;

public class partTimeStudent extends Student {
	protected static double courseFees;
	protected static double creditHours;
	protected Scanner input = new Scanner(System.in);

	@Override
	public void readInfo() {
		// input for part time student
		super.readInfo();
		System.out.print("Enter Total Course Fees: ");
		courseFees = input.nextInt();
		System.out.print("Enter Credit Hours: ");
		creditHours = input.nextDouble();

	}

	@Override
	public void printInfo() {
		// printing information for part time student
		System.out.println();
		super.printInfo();
		System.out.printf("%18s|%11s|     ", "$" + courseFees, creditHours);
	}

	public void readFromFile(Scanner input) {
		super.readFromFile(input);

		courseFees = input.nextDouble();
		creditHours = input.nextDouble();

	}

}
