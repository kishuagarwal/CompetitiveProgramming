import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 18-12-2014.
 */
public class PlayWithWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in);
        in.close();
    }

    public static void solve(Scanner in){
        String s = in.next();
        int length = s.length();
        int dp[][] = new int[length][length];
        for(int i = 0; i < length; i++) dp[i][i] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int r = j;
                int c = j+i;
                if( c >= length) continue;
                int k;
                for (k = c; k > r; k--) {
                    if(s.charAt(k) == s.charAt(r)){
                        int max = Math.max(dp[r][c-1],dp[r+1][c]);
                        dp[r][c] = Math.max(max,dp[r+1][k-1] + 2);
                        break;
                    }
                }
                if(k == r) dp[r][c] = Math.max(dp[r][c-1],dp[r+1][c]);

            }
        }
        long ans = 0;
        for (int i = 0; i < length-1; i++) {
            ans = Math.max(ans, dp[0][i] * dp[i+1][length-1]);
        }
        System.out.println(ans);
    }
}
