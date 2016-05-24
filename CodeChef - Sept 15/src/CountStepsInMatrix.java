import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CountStepsInMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 1; i <=t  ;i++) {
			int n = Integer.parseInt(reader.readLine());
			int a[][] = new int[n][n];
			for (int j = 0; j < n ;j++) {
				String line = reader.readLine();
				StringTokenizer tokens = new StringTokenizer(line);
				
				for (int k = 0; k < n; k++) {
					a[j][k] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			int steps = 0;
			int positions[][] = new int[n*n][2];
			int curx,cury;
			for (int j = 0; j < n ;j++) {
				for (int k = 0; k < n; k++) {
					positions[a[j][k]-1][0] = j;
					positions[a[j][k]-1][1] = k;
				}
			}
			
			for (int j = 1; j < n*n; j++) {
				steps += Math.abs(positions[j][0] - positions[j-1][0]) +
						 Math.abs(positions[j][1] - positions[j-1][1]);
			}
			System.out.println(steps);
		}
		reader.close();
	}

}
