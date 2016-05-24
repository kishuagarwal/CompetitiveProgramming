import java.util.Scanner;

public class Main {

    static long mod = 1000000007;
    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int  t = in.nextInt();
        long n;
        long m;

        long ans;
        for (int i = 0; i < t; i++) {
            n = in.nextLong();
            m = in.nextLong();
            ans = m % mod;
            if(n > 1)
                ans = (ans * (m-1))%mod;
            if(n > 2)
                ans = (ans * exp(m-2,n-2))%mod;

            System.out.println(ans);
        }
        in.close();
    }

    public static long exp(long a,long b){
        long ans;
        if(b == 0)
            return 1;
        if(b == 1)
            return a % mod;
        ans = exp(a,b >> 1);
        ans = (ans*ans )%mod;
        if( b % 2 == 1)
            ans = (ans * a)%mod;
        return ans;
    }
}
