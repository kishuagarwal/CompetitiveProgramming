import java.util.Arrays;
import java.util.Scanner;

public class TrafficControl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            int[][] matrix = new int[n][m];
            if (a < (n + m - 1) || b < (n + m - 1)) {
                System.out.println("Case #" + i + ": Impossible");
                continue;
            }

            for (int j = 0; j < n; j += 1) {
                Arrays.fill(matrix[j], 1);
            }

            matrix[0][0] = a - (n + m - 2);
            matrix[0][m - 1] = b - (n + m - 2);

            System.out.println("Case #" + i + ": Possible");
            for (int r = 0; r < n; r += 1) {
                for (int c = 0; c < m; c += 1) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
