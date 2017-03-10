import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndCakes {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		long n, m;
		for (int i = 0; i < t; i++) {
			String[] line = reader.readLine().split(" ");
			n = Long.parseLong(line[0]);
			m = Long.parseLong(line[1]);

			 if (m == 0) {
			 if (1 == n)
			 System.out.println("Yes");
			 else
			 System.out.println("No 1");
			 } else {
			 long firstInM = m - (n % m) + 1;
			 long termsInGroup = m / (firstInM - 1);
			 long ans = termsInGroup * (n / m) + (n % m) / (firstInM - 1);
			 if (ans == n)
			 System.out.println("Yes");
			 else
			 System.out.println("No " + ans);
			 }

//			if (n == m) {
//				if (n == 1)
//					System.out.println("Yes");
//				else
//					System.out.println("No 1");
//			} else {
//				if (n % 2 == 1) {
//					if (m == 0 && n == 1)
//						System.out.println("Yes");
//					if (m == 0 && n != 1)
//						System.out.println("No 1");
//					if (m != 0)
//						System.out.println("Yes");
//				} else {
//					if (m == 0)
//						System.out.println("No 1");
//					else if (m == n / 2) {
//						if (n == 2)
//							System.out.println("Yes");
//						else
//							System.out.println("No 2");
//					} else {
//						if (m % 2 == 1)
//							System.out.println("Yes");
//						if (m % 2 == 0)
//							System.out.println("No " + (n / 2));
//					}
//				}
//			}

		}

		reader.close();
	}
}
