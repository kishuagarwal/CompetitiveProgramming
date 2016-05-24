import java.util.Scanner;


public class GamesOfThrones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int freq[] = new int[26];
		for (int i = 0; i < input.length(); i++) {
			freq[input.charAt(i)-'a']++;
		}
		int oddCount = 0;
		for (int i = 0; i < freq.length; i++) {
			if(freq[i] % 2 == 1)
				oddCount++;
		}
		if((input.length() % 2 == 0 && oddCount == 0) || 
				input.length() % 2 == 1 && oddCount == 1)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
