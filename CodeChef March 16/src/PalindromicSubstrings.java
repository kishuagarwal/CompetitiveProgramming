import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicSubstrings {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0 ; i < t; i++) {
			String a = reader.readLine();
			String b = reader.readLine();
			int freqA[] = new int[26];
			int freqB[] = new int[26];
			for (int j = 0; j < a.length(); j++) 
				freqA[a.charAt(j) - 'a']++;
			for (int j = 0; j < b.length(); j++)
				freqB[b.charAt(j) - 'a']++;
			boolean found = false;
			for (int j = 0; j < 26; j++) {
				if (freqA[j] > 0 && freqB[j] > 0) {
					found = true;
					break;
				}
			}
			if (found)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		reader.close();

	}

}
