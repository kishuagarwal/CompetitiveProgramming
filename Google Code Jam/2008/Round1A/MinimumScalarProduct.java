package Round1A;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author kishu.agarwal
 */
public class MinimumScalarProduct {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            Integer[] first = new Integer[n];
            Integer[] second = new Integer[n];
            for (int j = 0; j < n; j += 1) {
                first[j] = in.nextInt();
            }
            for (int j = 0; j < n; j += 1) {
                second[j] = in.nextInt();
            }
            Arrays.sort(first, Comparator.reverseOrder());
            Arrays.sort(second);
            long ans = 0;
            for (int j = 0; j < n; j += 1) {
                ans += first[j] * (long) second[j];
            }
            System.out.format("Case #%d: %d\n", i, ans);
        }
    }
}
