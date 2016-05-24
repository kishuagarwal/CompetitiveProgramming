import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 21-02-2015.
 */
public class SuperTwoLetterStrings {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        //number of strings of length n ending in y
        BigInteger dp[] = new BigInteger[10001];
        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger ans;
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int p = in.nextInt();
            dp[0] = BigInteger.ONE;
            ans = BigInteger.ONE;
            for (int j = 1; j < n; j++) {
                dp[j] = ans;

                ans = ans.shiftLeft(1);
                if(j-p >= 0) {
                    ans = ans.subtract(dp[j-p]);
                }
            }
            System.out.println(ans.mod(mod));
        }
        in.close();
    }
}
