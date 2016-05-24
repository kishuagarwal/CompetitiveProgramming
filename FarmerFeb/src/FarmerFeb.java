import java.util.Scanner;


public class FarmerFeb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t =in.nextInt();
		int x,y;
		for(int i = 1; i <= t; i++){
		x = in.nextInt();
		y = in.nextInt();
		System.out.println(nextPrime(x+y+1) - (x+y));
		
		}
		in.close();
	}
	
	public static int nextPrime(int n){
		
		int j;
		boolean isPrime; 
		if(n % 2 == 0)
			 n++; 
		for(int i = n ;; i+=2)
		{
			isPrime = true;
			for(j = 3; j <= Math.sqrt(i); j+= 2)
				if(i % j == 0)
					{
					isPrime = false;
					break;
					}
			if(isPrime)
				return i;
		}
	}

}
