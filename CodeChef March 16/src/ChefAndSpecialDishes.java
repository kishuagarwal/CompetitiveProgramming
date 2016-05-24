import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndSpecialDishes {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int d = Integer.parseInt(reader.readLine());
		for (int i = 0; i < d; i++) {
			char input[] = reader.readLine().toCharArray();
			boolean mismatch = false;
			if (input.length == 1)
				mismatch = true;
			else if (input.length % 2 == 0) {
				// even, check the two halfs
				mismatch = false;
				for (int j = 0; j < input.length >> 1; j++) {
					// System.out.println(input.charAt(j) + " " +
					// input.charAt((input.length() >> 1) + j));
					if (input[j] != input[(input.length >> 1) + j]) {

						mismatch = true;
						break;
					}
				}
			} else {
				/*
				 * int freq[] = new int[26]; for (int j = 0; j < input.length();
				 * j++) { freq[input.charAt(j) - 'a']++; } int count = 0; int
				 * pos = -1; for (int j = 0 ; j < 26; j++) if (freq[j] % 2 != 0)
				 * { pos = j; count++; } if (count > 1) { mismatch = true;
				 * //can't be special } else { //check if deleting character at
				 * pos, makes it a special string for (int j = 0; j <
				 * input.length(); j++) { if (input.charAt(j) == (pos + 'a')) {
				 * int firstIndex = 0; int secondIndex = input.length() >> 1;
				 * mismatch = false; count = input.length() >> 1; int
				 * currentCount = 0; while (currentCount < count) { if
				 * (firstIndex == j) firstIndex++; if (secondIndex == j)
				 * secondIndex++; if (input.charAt(firstIndex) !=
				 * input.charAt(secondIndex)) { mismatch = true; }
				 * currentCount++; } if (mismatch == false) break; } } }
				 */
				// Assume that odd character is in the second half
				int firstStart = 0, firstEnd = (input.length >> 1) - 1;
				int secondStart = input.length >> 1, secondEnd = input.length - 1;
				while (firstStart <= firstEnd && secondStart <= secondEnd && input[firstStart] == input[secondStart]) {
					firstStart++;
					secondStart++;
				}
				while (firstEnd >= firstStart && secondEnd >= secondStart && input[firstEnd] == input[secondEnd]) {
					firstEnd--;
					secondEnd--;
				}
				if (Math.abs(firstEnd - firstStart) == 1 && secondEnd == secondStart) {
					mismatch = false;
				} else
					mismatch = true;

				if (mismatch) {

					// Assume that odd character is in the first half
					firstStart = 0;
					firstEnd = (input.length >> 1);
					secondStart = (input.length >> 1) + 1;
					secondEnd = input.length - 1;
					while (firstStart <= firstEnd && secondStart <= secondEnd
							&& input[firstStart] == input[secondStart]) {
						firstStart++;
						secondStart++;
					}
					while (firstEnd >= firstStart && secondEnd >= secondStart && input[firstEnd] == input[secondEnd]) {
						firstEnd--;
						secondEnd--;
					}
					if (Math.abs(secondEnd - secondStart) == 1 && firstStart == firstEnd) {
						mismatch = false;
					} else
						mismatch = true;
				}

			}
			if (mismatch)
				System.out.println("NO");
			else
				System.out.println("YES");

		}

		reader.close();

	}

}
