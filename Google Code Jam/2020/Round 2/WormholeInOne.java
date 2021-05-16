import java.util.HashMap;
import java.util.Scanner;

public class WormholeInOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int[][] holes = new int[n][2];
            for (int j = 0; j < n; j += 1) {
                holes[j][0] = in.nextInt();
                holes[j][1] = in.nextInt();
            }

            // Compute holes pair-wise line equations. y = mx + y0.
            // m is slope and y0 in y-intercept.
            // For each m, we calculate how many times, have we seen y0.
            // Basically how many times have we seen this line before.

            HashMap<Double, HashMap<Double, Integer>> counts = new HashMap<>();
            for (int j = 1; j < n ;j += 1) {
                for (int k = 0; k < j; k += 1) {
                    double slope = Double.MAX_VALUE;
                    if (holes[k][0] != holes[j][0]) {
                        slope = ((double) holes[j][1] - holes[k][1]) / (holes[j][0] - holes[k][0]);
                    }
                    if (!counts.containsKey(slope)) {
                        counts.put(slope, new HashMap<>());
                    }

                    double intercept = holes[k][0];
                    if (slope != Double.MAX_VALUE) {
                        intercept = slope * holes[k][0] - holes[k][1];
                    }

                    if (!counts.get(slope).containsKey(intercept)) {
                        counts.get(slope).put(intercept, 2);
                    } else {
                        counts.get(slope).put(intercept, counts.get(slope).get(intercept) + 1);
                    }
                }
            }

            // For each direction
            int ans = 0;
            if (counts.isEmpty()) {
                ans = 1;
            }
            for (Double slope: counts.keySet()) {
                int otherPoints = 0;
                //System.out.println("Current slope:" + slope);
                for (Integer count: counts.get(slope).values()) {
                    //System.out.println("Count " + count);
                    otherPoints += count;
                }
                int standalone = n - otherPoints;
                if (otherPoints % 2 == 1) {
                    ans = Math.max(ans, otherPoints + Math.min(1, standalone));
                } else {
                    ans = Math.max(ans, otherPoints + Math.min(2, standalone));
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
