import java.math.BigInteger;
import java.util.Scanner;


public class GardenGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); 
		int n,t,currentPos,temp,count;
		t = in.nextInt();
		int permutation[]  = new int[100000];
		BigInteger mod = new BigInteger("1000000007");
		long tep;
		long ans;
		for (int i = 1; i <= t; i++) {
			n = in.nextInt();
			ans = 1;
			for (int j = 0; j < n; j++) {
				permutation[j] = in.nextInt();
			}
			for (int j = 0; j < n; j++) {
				if(permutation[j] == 0)
					continue;
				currentPos = j;
				count= 0;
				do{
					temp = permutation[currentPos]-1;
					permutation[currentPos] = 0;
					currentPos =  temp;   
					count++;
				}while(currentPos != j);
				BigInteger countB = new BigInteger(""+count);
				tep = new BigInteger(""+ans).multiply(countB).mod(mod).longValue();
				ans = tep/gcd(ans,count);
			}
			System.out.println(ans);
		}
		in.close();
	}
	
	public static long gcd(long a,long b){
		long t;
		while(b!=0)
			{
				
				t = b;
				b = a%b;
			 	a = t;
			}
		return a;
	}

}
