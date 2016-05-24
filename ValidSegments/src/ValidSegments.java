import java.util.Arrays;
import java.util.Scanner;


public class ValidSegments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int k = in.nextInt();
		int l = in.nextInt(),u = in.nextInt();
		String words[] = new String[k];
		for (int i = 0; i < words.length; i++) {
			words[i] = in.next().toLowerCase();
		}
		input = input.toLowerCase();
		int positionsfound[] = new int[30000];
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			
		}
		Arrays.sort(positionsfound);
		int totalsegments = 0;
	
	}

}
