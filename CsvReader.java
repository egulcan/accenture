import java.io.BufferedReader;  
import java.io.FileNotFoundException;    
import java.io.IOException;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.Collections;
import java.util.List;  
import java.util.Comparator;
import java.util.Date;
import java.io.InputStreamReader;
import java.io.FileInputStream;


public class CsvReader {

	public List<MiniDatabase> miniDbList = new ArrayList<MiniDatabase>();
	public int numLines;
	
	public int loadData(String fileName) throws FileNotFoundException, IOException, ParseException
	{
		String line = "";
		String splitChar = ";";
		numLines = 0;
		BufferedReader csvFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF8"));
		
		while((line = csvFile.readLine()) != null)
		{
			numLines++;
			String[] dbLine = line.split(splitChar);
			
			if(dbLine[0].length()<6 || dbLine[0].length()>10)
			{
				System.out.println("Invalid username size at position " + numLines);
				System.exit(0);
			}
			if(dbLine[1].getBytes().length > 30)
			{
				System.out.println("First name too long at position " + numLines);
				System.exit(0);
			}
			if(dbLine[2].getBytes().length > 30)
			{
				System.out.println("Last name too long at position " + numLines);
				System.exit(0);
			}
			if(dbLine[3].getBytes().length > 20)
			{
				System.out.println("Department name too long at position " + numLines);
				System.exit(0);
			}
			if(dbLine[4].length() > 25)
			{
				System.out.println("Phone number too long at position " + numLines);
				System.exit(0);
			}
			
			MiniDatabase miniDbObj = new MiniDatabase(dbLine[0],dbLine[1],dbLine[2],dbLine[3],dbLine[4],dbLine[5]);
			
			miniDbList.add(miniDbObj);
		}
		
		csvFile.close();
		
		return numLines;
	}
	
	public MiniDatabase[] findByName(String firstName, String lastName)
	{
		List<MiniDatabase> results = new ArrayList<MiniDatabase>();
		int numResults = 0;
		
		for(int i=0;i<numLines;i++)
		{
			if(miniDbList.get(i).getFirstName().equals(firstName))
			{
				if(miniDbList.get(i).getLastName().equals(lastName))
				{
					results.add(miniDbList.get(i));
					numResults++;
				}
			}
		}
		
		Collections.sort(results,new Comparator<MiniDatabase>(){
			public int compare(MiniDatabase comp1, MiniDatabase comp2)
			{
				return comp1.getAccountEndDate().compareTo(comp2.getAccountEndDate());
			}
		});
		
		MiniDatabase[] miniDbArray = new MiniDatabase[numResults];
		miniDbArray = results.toArray(miniDbArray);
		
		return miniDbArray;
			
	}
	
	public MiniDatabase[] findByDepartment(String department)
	{
		List<MiniDatabase> results = new ArrayList<MiniDatabase>();
		int numResults = 0;
		
		for(int i=0;i<numLines;i++)
		{
			if(miniDbList.get(i).getDepartment().equals(department))
			{
				results.add(miniDbList.get(i));
				numResults++;
			}
			
		}
		
		Collections.sort(results,new Comparator<MiniDatabase>(){
			public int compare(MiniDatabase comp1, MiniDatabase comp2){
				String comp1Upper = comp1.getFirstName().toUpperCase();
				String comp2Upper = comp2.getFirstName().toUpperCase();
				
				return comp1Upper.compareTo(comp2Upper);
				}
		});
		
		MiniDatabase[] miniDbArray = new MiniDatabase[numResults];
		miniDbArray = results.toArray(miniDbArray);
		
		return miniDbArray;
			
	}
	
	public MiniDatabase[] findByPhone(String phone)
	{
		List<MiniDatabase> results = new ArrayList<MiniDatabase>();
		int numResults = 0;
		
		for(int i=0;i<numLines;i++)
		{
			if(miniDbList.get(i).getPhoneNumber().equals(phone))
			{
				results.add(miniDbList.get(i));
				numResults++;
			}
			
		}
		
		Collections.sort(results,new Comparator<MiniDatabase>(){
			public int compare(MiniDatabase comp1, MiniDatabase comp2){
				String comp1Upper = comp1.getFirstName().toUpperCase();
				String comp2Upper = comp2.getFirstName().toUpperCase();
				
				return comp1Upper.compareTo(comp2Upper);
				}
		});
		
		MiniDatabase[] miniDbArray = new MiniDatabase[numResults];
		miniDbArray = results.toArray(miniDbArray);
		
		return miniDbArray;
			
	}
	
	public MiniDatabase[] findEndDate(String intervalStart, String intervalEnd) throws ParseException
	{
		List<MiniDatabase> results = new ArrayList<MiniDatabase>();
		int numResults = 0;
		
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date intervalStartDate = sdformat.parse(intervalStart);
		Date intervalEndDate = sdformat.parse(intervalEnd);
		
		for(int i=0;i<numLines;i++)
		{
			if(miniDbList.get(i).getAccountEndDate().after(intervalStartDate))
			{
				if(miniDbList.get(i).getAccountEndDate().before(intervalEndDate))
					{
						results.add(miniDbList.get(i));
						numResults++;
					}
			}
		}
		
		Collections.sort(results,new Comparator<MiniDatabase>(){
			public int compare(MiniDatabase comp1, MiniDatabase comp2){

				return comp1.getAccountEndDate().compareTo(comp2.getAccountEndDate());
				}
		});
		
		MiniDatabase[] miniDbArray = new MiniDatabase[numResults];
		miniDbArray = results.toArray(miniDbArray);
		
		return miniDbArray;
		
	}
}
