import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndStones {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= t; i++) {
			String input[] = reader.readLine().split(" ");
			long n1 = Long.parseLong(input[0]);
			long n2 = Long.parseLong(input[1]);
			long m = Long.parseLong(input[2]);
			
			long sum = m * (m + 1) / 2;
			if (sum >= Math.min(n1, n2)) {
				System.out.println(Math.abs(n1-n2));
			}
			else {
				System.out.println(n1- sum + n2 - sum);
			}
			
			
		}
		
		reader.close();

	}

}
