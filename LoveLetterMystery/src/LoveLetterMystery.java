import java.util.Scanner;


public class LoveLetterMystery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		for (int i = 0; i < t; i++) {
			String input = in.nextLine();
			int count = 0;
			for (int j = 0; j < input.length()/2; j++) {
				count += Math.abs(input.charAt(j)-input.charAt(input.length()-j-1));
			}
			System.out.println(count);
		}
		in.close();
	}

}
