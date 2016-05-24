import java.util.Scanner;

public class MatrixRotations {

	static int n;
	static short matrix[][];
	static int totalRotations;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		matrix = new short[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = in.nextShort();
		char first = in.next().charAt(0);
		int second, third;
		totalRotations = 0;
		while (first != '-') {
			switch (first) {

			case 'A':
				second = in.nextInt();
				totalRotations = (totalRotations + second) % 360;
				break;
			case 'Q':
				second = in.nextInt()-1;
				third = in.nextInt()-1;
				print(second, third);
				break;
			case 'U':
				second = in.nextInt()-1;
				third = in.nextInt()-1;
				matrix[second][third] = in.nextShort();
				break;
			}
			first = in.next().charAt(0);
		}
		in.close();
	}

	private static void print(int x, int y) {
		// TODO Auto-generated method stub
		IntegerWrapper r = new IntegerWrapper();
		r.value = x;
		IntegerWrapper c = new IntegerWrapper();
		c.value = y;
		switch (totalRotations) {
		case 0:
			System.out.println(matrix[x][y]);
			break;
		case 90:
			getRotate90Position(r, c);
			System.out.println(matrix[r.value][c.value]);
			break;
		case 180:
			getRotate180Positon(r, c);
			System.out.println(matrix[r.value][c.value]);
			break;
		case 270:
			getRotate270Position(r, c);
			System.out.println(matrix[r.value][c.value]);
			break;

		}
	}

	private static void getRotate90Position(IntegerWrapper x, IntegerWrapper y) {
		int temp = y.value;
		y.value = x.value;
		x.value = (n - 1 - temp);
		
	}

	private static void getRotate180Positon(IntegerWrapper x, IntegerWrapper y) {
		getRotate90Position(x, y);
		getRotate90Position(x, y);
	}

	private static void getRotate270Position(IntegerWrapper x, IntegerWrapper  y) {
		getRotate180Positon(x, y);
		getRotate90Position(x, y);

	}
	
	static class IntegerWrapper{
		int value;
	}

}
