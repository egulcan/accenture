import java.util.Comparator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiniDatabase implements Comparator<MiniDatabase> {
	private
		String userName;
		String firstName;
		String lastName;
		String department;
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date accountEndDate;
		String phoneNumber;
		
	public MiniDatabase(String initUserName, String initFirstName, String initLastName, String initDepartment,
						String initAccountEndDate, String initPhoneNumber) throws ParseException
	{
		userName = initUserName;
		firstName = initFirstName;
		lastName = initLastName;
		department = initDepartment;
		accountEndDate = sdformat.parse(initAccountEndDate);
		phoneNumber = initPhoneNumber;
	}
		
	public String getUserName()
	{
		return userName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public Date getAccountEndDate()
	{
		return accountEndDate;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public int compare(MiniDatabase comp1, MiniDatabase comp2)
	{
		String comp1Upper = comp1.getFirstName().toUpperCase();
		String comp2Upper = comp2.getFirstName().toUpperCase();
		
		return comp1Upper.compareTo(comp2Upper);
	}

}
