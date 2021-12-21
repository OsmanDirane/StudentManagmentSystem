
import java.io.*;
import java.util.Scanner;

public class UniversitySystemTest {
	public static String data = "";
	static File studentFile = new File("./students.txt");

	public static void main(String[] args) {
		// Prompt user for name of university and number of students
		Scanner input = new Scanner(System.in);

		int loop = 0;
		String name = "";
		int n = 0;
		try {

			System.out.print("Enter the name of University: ");
			name = input.nextLine();
			System.out.print("Enter Number of Students: ");
			n = input.nextInt();
		} catch (Exception e) {
			System.err.println("Mismatch Input Exception");
		} finally {
			UniversityClass c1 = new UniversityClass(name, n);
			while (loop == 0) {
				try {

					menu();
					System.out.print("Enter Your Choice: ");
					String choice = input.next();
					if (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
						throw new Exception("Input Mismatch Exception");
					}

					// selecting
					if (choice.equals("1")) {

						// call methods
						System.out.println("1-Read from file");
						System.out.println("2-Read from the user");
						int select = input.nextInt();
						if(select == 2) {
							String data = "";
							c1.readStudentsDetails();
							if(c1.studentType == 1) {
							//	data = "\n" + Student.getData() + " $" + fullTimeStudent.tuitionFees;
								c1.studentType = 0;
							}else if(c1.studentType == 2) {
							//	data =  "\n" + Student.getData() + " $" + partTimeStudent.courseFees + " " + partTimeStudent.creditHours;
								c1.studentType = 0;
							}
						
						
						}else if(select == 1) {
					    Scanner Scanner = new Scanner(new File("students.txt"));
						c1.detailsFromFile(Scanner);
                              
						}

					}
					if (choice.equals("2")) {
							
							c1.printStudentDetails();

					}
					if (choice.equals("3")) {
						// terminate the program
						System.out.print("Exiting.");
						for (int i = 0; i < 4; i++) {
							System.out.print(".");
							Thread.sleep(300);
						}
						System.out.println("\nProgram shutdown successfully");
						break;
					}
				} catch (Exception e) {

					System.err.println(e.getLocalizedMessage());
					System.err.println();
				}
			}
		}
	}

	public static void menu() {
		System.out.println("\n----------------------");
		System.out.println("1-Register Students");
		System.out.println("2-Display Students");
		System.out.println("3-exit");
		System.out.println("----------------------\n");
	}

	public static void readFromFile() throws Exception {
		try {

			Scanner reader = new Scanner(studentFile);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String readFromFile(int a) throws Exception {
		try {
			StringBuilder data = new StringBuilder();
			FileInputStream fn = new FileInputStream(studentFile);
			InputStreamReader input = new InputStreamReader(fn);
			BufferedReader reader = new BufferedReader(input);

//			while (reader.hasNextLine()) {
//				data.append(reader.nextLine());
//				data.append("\n");
//			}
			String sentence;
//			if((sentence = reader.readLine()) != null) {
//				String wordlist = sentence.replaceAll("\\s+", "\t");
//				System.out.println(wordlist);
//			}
			while ((sentence = reader.readLine()) != null) {
				String wordlist = sentence.replaceAll("\\s+", "|   \t");
				data.append(wordlist);
				data.append("|\n");
			}

			return data.toString();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
