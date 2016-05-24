import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefAndTimeMachine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		int n, k, m;
		int tasks[], white[], black[];

		String input[];
		for (int i = 0; i < t; i++) {
			input = reader.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			m = Integer.parseInt(input[2]);
			input = reader.readLine().split(" ");
			tasks = new int[n];
			white = new int[k];
			black = new int[m];
			for (int j = 0; j < n; j++) {
				tasks[j] = Integer.parseInt(input[j]);
			}
			input = reader.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				tasks[j] -= Integer.parseInt(input[j]);
			}
			input = reader.readLine().split(" ");
			for (int j = 0; j < white.length; j++) {
				white[j] = Integer.parseInt(input[j]);
			}
			input = reader.readLine().split(" ");
			for (int j = 0; j < black.length; j++) {
				black[j] = Integer.parseInt(input[j]);
			}
			Arrays.sort(tasks);
			Arrays.sort(white);
			Arrays.sort(black);

			long ans = 0;
			boolean changed;
			int whiteIndex = k - 1, blackIndex = m - 1;
			for (int j = n - 1; j >= 0; j--) {
				changed = true;
				while (changed) {
					changed = false;
					if (whiteIndex >= 0 && white[whiteIndex] > tasks[j]) {
						whiteIndex--;
						changed = true;
					}
					if (blackIndex >= 0 && black[blackIndex] > tasks[j]) {
						blackIndex--;
						changed = true;
					}

				}
				// while (tasks[j] > 0 && changed) {
				// changed = false;
				if (whiteIndex >= 0 && blackIndex >= 0) {
					if (white[whiteIndex] > black[blackIndex] && tasks[j] - white[whiteIndex] >= 0) {
						// changed = true;
						tasks[j] -= white[whiteIndex];
						whiteIndex--;
					} else if (black[blackIndex] <= tasks[j]) {
						// changed = true;
						tasks[j] -= black[blackIndex];
						blackIndex--;
					}
				} else if (whiteIndex >= 0) {
					if (tasks[j] - white[whiteIndex] >= 0) {
						tasks[j] -= white[whiteIndex];
						// changed = true;
						whiteIndex--;
					}
				} else {
					if (blackIndex >= 0 && black[blackIndex] <= tasks[j]) {
						tasks[j] -= black[blackIndex];
						// changed = true;
						blackIndex--;
					}
				}
				// }
				ans += tasks[j];
			}
			System.out.println(ans);

		}
		reader.close();

	}

}
