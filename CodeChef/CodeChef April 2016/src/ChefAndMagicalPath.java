import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndMagicalPath {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= t; i++) {
			String input[] = reader.readLine().split(" ");
			long n = Long.parseLong(input[0]);
			long m = Long.parseLong(input[1]);
			if ((n % 2 == 0 && m > 1) || (m % 2 == 0 && n > 1 ) || (n == 1 && m == 2) || (m == 1 && n == 2))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		reader.close();

	}

}
