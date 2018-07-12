public class stat implements java.io.Serializable
{
	public String statement;
	
	public stat(String sta)
	{
		statement = sta;
	}
	
	public String toString()
	{
		String s ="";
		s+=statement;
		return s;
	}
	
}