import java.io.FileNotFoundException;
import java.io.IOException;


//import java.io.*;
//import java.util.*;
 

public class MainClass {
	
	public static void main (String[] args) throws FileNotFoundException, IOException
	{
		String fileName = "src/test.csv";
		CsvReader createDatabase = new CsvReader();
		
		createDatabase.loadData(fileName);	
		createDatabase.findByName("Ege", "Gulcan");
		createDatabase.findByDepartment("Engineering");
	}
	
	
	
}