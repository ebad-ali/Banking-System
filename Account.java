public class Account implements java.io.Serializable
{
	

	String nam,addre,phn,sour;
	double amnt;
	int pi;
	
	
	
	public Account(String n,String addr,String ph,String sc,double am,int pin)
	{
		nam = n;
		addre =addr;
		phn = ph;
		sour = sc;
		amnt = am;
		pi = pin;	
	}
	
	
}