import java.net.*; 
import java.io.*;
 
class tcpdateclient
{
	public static void main (String args[])
	{
		Socket soc; 
		BufferedReader dis;
		String sdate; 
		PrintStream ps;
		try 
		{
			InetAddress ia = InetAddress.getLocalHost();
			if (args.length == 0)
			{
				soc = new Socket(InetAddress.getLocalHost(),4444);
			}
			else 
			{
				soc = new Socket(InetAddress.getByName(args[0]),4444);
			}
			dis = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
			sdate=dis.readLine(); 
			System.out.println("The date/time on server is : " +sdate); 
			ps = new PrintStream(soc.getOutputStream());
			ps.println(ia); 
			ps.close();
		}
		catch(IOException e)
		{
			System.out.println("THE EXCEPTION is :" + e);
		}
	}
}
