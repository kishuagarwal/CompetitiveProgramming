import java.util.Arrays;
import java.util.Scanner;


public class ChainOfDonuts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			long n = in.nextLong();
			int m = in.nextInt();
			int chains[] = new int[m];
			for (int j = 0; j < m; j++) 
				chains[j] = in.nextInt();
			Arrays.sort(chains);
			int cuts = 0;
			int chainsLeft = m;
			for (int j = 0; j < m; j++) {
				if ()
			}
			
		}
		in.close();
	}

}
