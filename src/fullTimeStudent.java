
import java.util.Scanner;

public class fullTimeStudent extends Student {
	// declaring variables
	protected double tuitionFees = 0;
	protected Scanner input = new Scanner(System.in);

	@Override
	public void readInfo() {

		// input for full time student
		super.readInfo();
		System.out.print("Enter total tuition fees: ");
		tuitionFees = input.nextDouble();

	}

	@Override
	public void printInfo()  {
		// printing information for full time student
		System.out.println();
		super.printInfo();
		System.out.printf("%18s|", "$" + tuitionFees);

	}
	@Override
	public void readFromFile(Scanner input) {
		super.readFromFile(input);
		tuitionFees = input.nextDouble();
        
       
	}

}
