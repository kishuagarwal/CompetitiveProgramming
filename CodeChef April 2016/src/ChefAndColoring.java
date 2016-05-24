import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndColoring {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			reader.readLine();
			String input = reader.readLine();
			int count[] = new int[3];
			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);
				if (c == 'R') count[0]++;
				else if (c == 'B') count[1]++;
				else count[2]++;
			}
			System.out.println(input.length() - Math.max(count[0], Math.max(count[1], count[2])));
		}
		reader.close();
	}

}
