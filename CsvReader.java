import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.Collections;
import java.util.List;  
import java.io.*;
import java.util.*;

public class CsvReader {

	public List<MiniDatabase> miniDbList = new ArrayList<MiniDatabase>();
	public int numLines;
	
	public int loadData(String fileName) throws FileNotFoundException, IOException
	{
		String line = "";
		String splitChar = ";";
		numLines = 0;
		BufferedReader csvFile = new BufferedReader(new FileReader(fileName));
		
		while((line = csvFile.readLine()) != null)
		{
			numLines++;
			String[] dbLine = line.split(splitChar);
			
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
	
	
}
