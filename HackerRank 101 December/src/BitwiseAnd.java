import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 18-12-2014.
 */
public class BitwiseAnd {


    public static void solve(Scanner in){
        int t = in.nextInt();
        long a,b,count,ans,athbit,bthBit;
        for (int i = 0; i < t; i++) {
            a = in.nextLong();
            b = in.nextLong();
            ans = 0L;
            int bits = (int)(Math.log(b)/Math.log(2));
            for (int j = 0; j <= bits; j++) {
                count = 1L << j;
                athbit = a & count;
                bthBit = b & count;
                if(athbit != 0 && bthBit != 0 && (b-a) <=count){
                    ans = ans | count;
                }
            }
            System.out.println(ans);
        }
    }
}
