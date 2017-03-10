import java.util.Scanner;

public class Laddu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <=t ;i++) {
			int n = in.nextInt();
			boolean isIndian = in.next().equals("INDIAN") ? true : false;
			int points = 0;
			for (int j = 1 ; j <= n ; j++)  {
				String input = in.next();
				if (input.equals("CONTEST_WON")) {
					points += 300 + Math.max(0, 20 - in.nextInt());
				}
				else if (input.equals("TOP_CONTRIBUTOR")) {
					points += 300;
				}
				else if (input.equals("BUG_FOUND"))
					points += in.nextInt();
				else
					points += 50;
			}
			
			if (isIndian)
				System.out.println(points/200);
			else
				System.out.println(points/400);
			
		}
		in.close();

	}

}
