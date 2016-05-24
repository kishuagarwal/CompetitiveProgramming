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

    public static void main(String args[])throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < t; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tokenizer.nextToken());
            int q = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine()," ");
            num[0] = Integer.parseInt(tokenizer.nextToken());
            gcdl[0] = num[0];
            for (int j = 1; j < n; j++) {
                num[j] = Integer.parseInt(tokenizer.nextToken());
                gcdl[j] = gcd(num[j],gcdl[j-1]);
            }
            gcdr[n-1] = num[n-1];
            for (int j = n-2; j >= 0 ; j--) {
                gcdr[j] = gcd(gcdr[j+1],num[j]);
            }
            for (int j = 0; j < q; j++) {
                tokenizer = new StringTokenizer(reader.readLine()," ");
                int l = Integer.parseInt(tokenizer.nextToken())-1;
                int r = Integer.parseInt(tokenizer.nextToken())-1;
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
        reader.close();
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
