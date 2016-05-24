import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 18-12-2014.
 */
public class SuperpowerOfTwo {

    public static void solve(Scanner in){
        long a,b;
        a = in.nextLong();
        b = in.nextLong();
        long ans = mod(a,b);
        System.out.println(mod(ans,b));
    }

    public static long mod(long b,long mod){
        if(b == 0)
            return 1;
        if(b == 1)
            return 2;
        long ans = mod(b >> 1,mod);
        ans = (ans *ans) % mod;
        if(b %  2 == 1) ans = (ans << 1) % mod;
        return ans;
    }

}
