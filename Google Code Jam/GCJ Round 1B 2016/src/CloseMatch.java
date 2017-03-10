import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CloseMatch {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			String c = tokenizer.nextToken();
			String j = tokenizer.nextToken();
			long num1 = 0, num2 = 0;
			char n1[] = new char[c.length()];
			char n2[] = new char[c.length()];
			for (int k = 0; k < c.length(); k++) {
				char first = c.charAt(k);
				char second = j.charAt(k);

				if (first != '?' && second != '?') { // 11
					num1 = num1 * 10 + (first - '0');
					num2 = num2 * 10 + (second - '0');
					n1[k] = first;
					n2[k] = second;
				}

				if (first == '?' && second != '?') { // ?1
					long num3 = num1;
					num2 = num2 * 10 + (second - '0');
					long diff = 30, first1 = 0;
					for (int s = 0; s <= 9; s++) {
						num3 = num1 * 10 + s;
						if (Math.abs(num3 - num2) < diff) {
							first1 = s;

							diff = Math.abs(num3 - num2);
						}
					}

					num1 = num1 * 10 + first1;
					n1[k] = (char) (first1 + '0');
					n2[k] = second;

				}

				if (first != '?' && second == '?') { // 1?
					long num4 = num1;
					num1 = num1 * 10 + (first - '0');
					long diff = 30, second1 = 0;
					for (int s = 0; s <= 9; s++) {
						num4 = num2 * 10 + s;
						if (Math.abs(num4 - num1) < diff) {
							second1 = s;

							diff = Math.abs(num4 - num1);
						}
					}

					num2 = num2 * 10 + second1;
					n1[k] = first;
					n2[k] = (char) (second1 + '0');
				}

				if (first == '?' && second == '?') { // ??
					long num3 = num1;
					long num4 = num2;
					long diff = 30, first1 = 0, second1 = 0;
					for (int s = 0; s <= 9; s++) {
						for (int r = 0; r <= 9; r++) {
							num3 = num1 * 10 + s;
							num4 = num2 * 10 + r;
							if (Math.abs(num3 - num4) < diff) {
								first1 = s;
								second1 = r;
								diff = Math.abs(num3 - num4);
							}
						}

					}
					num1 = num1 * 10 + first1;
					num2 = num2 * 10 + second1;
					
					n1[k] = (char) (first1 + '0');
					n2[k] = (char) (second1 + '0');
				}

			}
			System.out.println("Case #" + i + ": " + new String(n1) + " " + new String(n2));
		}
		reader.close();

	}

}
