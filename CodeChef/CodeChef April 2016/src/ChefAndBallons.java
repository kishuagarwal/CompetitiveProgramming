import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndBallons {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0 ; i < t; i++) {
			String input[] =reader.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int g = Integer.parseInt(input[2]);
			int k = Integer.parseInt(reader.readLine());
			long ans = (long)Math.min(k-1, b) + Math.min(k-1, g) + Math.min(k-1, r) + 1;
			System.out.println(ans);
 		}
		reader.close();

	}

}
