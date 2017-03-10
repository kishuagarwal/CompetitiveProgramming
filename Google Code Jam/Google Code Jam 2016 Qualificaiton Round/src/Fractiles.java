import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fractiles {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine()); 
		for (int i = 1; i <= t ; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
			int k = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			System.out.print("Case #"+ i + ": ");
			for (int j = 1; j <= s;j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		reader.close();
	}

}
