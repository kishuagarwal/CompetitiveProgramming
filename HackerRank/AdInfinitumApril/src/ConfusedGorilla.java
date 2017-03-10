import java.util.Scanner;


public class ConfusedGorilla {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			for (int j = 0; j <= n/2; j++) {
				if (j == (n-j))
					System.out.println(j+" "+(n-j));
				else
					System.out.println(j+" "+(n-j) + "\n" + (n-j) + " " + j);
			}
		}
		in.close();
	}

}
