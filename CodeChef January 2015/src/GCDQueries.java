import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Kishu Agarwal on 04-01-2015.
 */
public class GCDQueries {
    static int num[] = new int[100005];
    static int gcdl[] =  new int[100005];
    static int gcdr[] = new int[100005];
    static BufferedInputStream bis;

    public static void main(String args[])throws IOException{
        bis = new BufferedInputStream(System.in);
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            int q = nextInt();
            num[0] = nextInt();
            gcdl[0] = num[0];
            for (int j = 1; j < n; j++) {
                num[j] = nextInt();
                gcdl[j] = gcd(num[j],gcdl[j-1]);
            }
            gcdr[n-1] = num[n-1];
            for (int j = n-2; j >= 0 ; j--) {
                gcdr[j] = gcd(gcdr[j+1],num[j]);
            }
            for (int j = 0; j < q; j++) {
                int l = nextInt()-1;
                int r = nextInt()-1;
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
        bis.close();
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

    public static int nextInt()throws IOException{
        int c =  bis.read();
        while( !(c >= (int)'0' && c<= (int)'9') ){
            c = bis.read();
        }
        int ans = c - '0';
        while( !(c >= (int)'0' && c<= (int)'9')){
            ans = ans*10 + c - '0';
            c = bis.read();
        }
        return ans;

    }

}
