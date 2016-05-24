import java.util.Scanner;


public class CodeChefAndTheGuessingGame {

	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		long n,m;
		long upper;
		long lower;
		long gcd;
		for(int i = 1; i <=t ; i++)
		{
			n = in.nextLong();
			m = in.nextLong();
			lower = n*m;
			upper = (n>>1)*(((m&1) == 1)?((m>>1)+1) :(m>>1));
			upper +=(m>>1)*(((n&1) == 1)?((n>>1)+1) :(n>>1)); 
			gcd = gcd(upper,lower);
			System.out.println((upper/gcd)+"/"+(lower/gcd));
		}
		in.close();
	}
	
	public static long gcd(long a,long b)
	{
		if(b == 0)
			return a;
		
		else
			return gcd(b,a%b);
	}
}
