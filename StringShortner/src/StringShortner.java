import java.util.Scanner;


public class StringShortner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		input = input.trim();
		int pos = 0;
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == ' ')
			{
				System.out.print(input.charAt(pos) + " ");
				pos = i+1;
			}
		}
		System.out.print(input.subSequence(pos, input.length()));
		in.close();
		
	}

}
