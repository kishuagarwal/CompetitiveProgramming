import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Kishu Agarwal on 04-01-2015.
 */
public class GCD {
    static int num[] = new int[100005];
    static int gcdl[] =  new int[100005];
    static int gcdr[] = new int[100005];

    public static void main(String args[])throws IOException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int q = in.nextInt();
            num[0] = in.nextInt();
            gcdl[0] = num[0];
            for (int j = 1; j < n; j++) {
                num[j] = in.nextInt();
                gcdl[j] = gcd(num[j],gcdl[j-1]);
            }
            gcdr[n-1] = num[n-1];
            for (int j = n-2; j >= 0 ; j--) {
                gcdr[j] = gcd(gcdr[j+1],num[j]);
            }
            for (int j = 0; j < q; j++) {
                int l = in.nextInt()-1;
                int r = in.nextInt()-1;
                if(l != 0){
                    l = gcdl[l-1];
                }
                else
                    l = 0;
                if(r != n-1){
                    r = gcdr[r+1];
                }
                else
                    r = 0;
                System.out.println(gcd(l,r));

            }
        }
        in.close();
    }
    public static int gcd(int a, int b){
        int t;
        while(b != 0){
            t = b;
            b = a%b;
            a = t;
        }
        return a;
    }
}
