import java.util.Scanner;

public class ChefAndPrimeDivisors {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long a,b,gcd;  
		for (int i = 1; i <= t; i++) {
			a = in.nextLong();
			b = in.nextLong();
			gcd = gcd(a,b);
			while (gcd != 1) {
				b /= gcd;
				gcd = gcd(b,gcd);
			}
			if (b == 1) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			
		}
		in.close();
	}
	
	private static long gcd(long a,long b) {
		if (b == 0) return a;
		return gcd(b,a%b);
	}

}
