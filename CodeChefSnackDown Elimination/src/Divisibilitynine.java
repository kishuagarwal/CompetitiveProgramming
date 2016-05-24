import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Divisibilitynine {
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		String line;
		long sum,leftOver;
		int c;
		
		for (int i = 1; i <= t; i++) {
			line = reader.readLine();
			sum = 0;
			leftOver = 0;
			for (int j = 0; j < line.length(); j++) {
				c = line.charAt(j) - '0';
				sum += c;
				leftOver += 9 - c;
			}
			if (line.length() == 1) {
				System.out.println(Math.min(sum % 9, 9 - (sum % 9)));
			}
			else {
				if (sum < 9) {
					System.out.println(9 - sum);
				}
				else {
					if (leftOver >= (9 - (sum % 9)))
							System.out.println(Math.min(sum % 9, 9 - (sum % 9)));
					else
						System.out.println(sum % 9);
				}
			}
		}
		reader.close();
	}

}
