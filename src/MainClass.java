import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
	
	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException
	{
		CsvReader searchDatabase = new CsvReader();
		Scanner scanner = new Scanner(System.in);
		String inputFileName;
		int numEntries;
		int selectMode;
		String firstName, lastName, departmentName, phoneNumber, intervalStartDate, intervalEndDate;
		
		System.out.println("Welcome to the MiniDatabase Program.");
		System.out.println("Please enter the database name :");
		inputFileName = scanner.nextLine();
		inputFileName = "src/" + inputFileName;
		
		numEntries = searchDatabase.loadData(inputFileName);
		System.out.println("Number of entries in the database: " + numEntries);
		
		//resultArray stores the return array of the functions
		//It is not used in the main function but it is there for debugging purposes
		//The functions itself print the results into the console
		MiniDatabase[] resultArray = new MiniDatabase[numEntries]; 
		
		
		// User interface at the console
		while(true)
		{
			System.out.println("-------------------------------");
			System.out.println("Please select a search criteria");
			System.out.println("1.Find by Name");
			System.out.println("2.Find by Department");
			System.out.println("3.Find by Phone Number");
			System.out.println("4.Find by Account End Date Interval");
			System.out.println("5.Exit");
			selectMode = scanner.nextInt();
			
			// Search mode selection
			switch(selectMode)
			{
				case 1: 
				{
					System.out.println("Please enter the first name: ");
					scanner.nextLine();
					firstName = scanner.nextLine();
					System.out.println("Please enter the last name: ");
					
					lastName = scanner.nextLine();
					
					resultArray = searchDatabase.findByName(firstName,lastName);
					break;
				}
				case 2:
				{
					System.out.println("Please enter the department name: ");
					scanner.nextLine();
					departmentName = scanner.nextLine();
					resultArray = searchDatabase.findByDepartment(departmentName);
					break;
				}
				case 3:
				{
					System.out.println("Please enter the phone number as +xx xxx xxxxxxx: ");
					scanner.nextLine();
					phoneNumber = scanner.nextLine();
					resultArray = searchDatabase.findByPhone(phoneNumber);
					break;
				}
				case 4:
				{
					System.out.println("Please enter the interval start date in the format YYYY-MM-DD: ");
					intervalStartDate = scanner.next();
					System.out.println("Please enter the interval end date in the format YYYY-MM-DD: ");
					intervalEndDate = scanner.next();
					
					resultArray = searchDatabase.findEndDate(intervalStartDate, intervalEndDate);
					break;
				}
				case 5:
				{
					scanner.close();
					System.out.println("Thank You");
					System.out.println("Exiting...");
					System.exit(0);
					break;
				}
			}
		}
		
		// Functions for debugging without using the interface
		// For using these functions, comment out the while(true) loop
		//searchDatabase.findByName("Ege", "Gülcan");
		//searchDatabase.findByDepartment("Engineering");
		//searchDatabase.findByPhone("+90 532 5166668");
		//searchDatabase.findEndDate("2015-05-01", "2015-10-10");
	}
	
	
	
}