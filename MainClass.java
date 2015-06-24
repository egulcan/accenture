import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


//import java.io.*;
//import java.util.*;
 

public class MainClass {
	
	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException
	{
		String fileName = "src/test.csv";
		CsvReader createDatabase = new CsvReader();
		
		createDatabase.loadData(fileName);	
		createDatabase.findByName("Ege", "Gülcan");
		createDatabase.findByDepartment("Engineering");
		createDatabase.findByPhone("+90 532 5166668");
		createDatabase.findEndDate("2015-05-01", "2015-10-10");
	}
	
	
	
}