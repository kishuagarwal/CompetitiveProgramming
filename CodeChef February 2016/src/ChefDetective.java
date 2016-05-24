import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefDetective {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int count[]  = new int[n+1];
		String input[] = reader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			count[Integer.parseInt(input[i])]++;
		}
		for (int i = 1; i < count.length; i++) {
			if (count[i] == 0)
				System.out.print(i+" ");
		}
		reader.close();

	}

}
