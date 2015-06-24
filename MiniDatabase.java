import java.util.Comparator;

public class MiniDatabase implements Comparator<MiniDatabase> {
	private
		String userName;
		String firstName;
		String lastName;
		String department;
		String accountEndDate;
		String phoneNumber;
		
	public MiniDatabase(String initUserName, String initFirstName, String initLastName, String initDepartment,
						String initAccountEndDate, String initPhoneNumber)
	{
		userName = initUserName;
		firstName = initFirstName;
		lastName = initLastName;
		department = initDepartment;
		accountEndDate = initAccountEndDate;
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
	
	public String getAccountEndDate()
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
