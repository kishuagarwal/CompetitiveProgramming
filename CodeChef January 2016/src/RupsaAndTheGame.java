import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RupsaAndTheGame {

	
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(reader.readLine());
		int nums[] = new int[100000];
		long dp;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			String input[] = reader.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				nums[j] = Integer.parseInt(input[j]);
			}
			
		}
		reader.close();
	}
}
