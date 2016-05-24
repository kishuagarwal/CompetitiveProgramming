import java.util.Scanner;

public class ChefAndBalls {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean found = false;
		System.out.println(1);
		System.out.println(3 + " " + 1 + " " + 2 + " " + 2);
		System.out.println(3 + " " + 3 + " " + 4 + " " + 4);
		System.out.flush();
		int diff = in.nextInt();
		if (diff != 0) {
			found = true;
			System.out.println(2);
			if (diff < 0)
				System.out.println((diff == -1) ? 3 : 4);
			else
				System.out.println((diff == 1) ? 1 : 2);
		}
		if (!found)
			System.out.println(2 + "\n" + 5);
		in.close();

	}

}
