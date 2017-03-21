import java.util.Scanner;
import java.math.*;
class FairyTale {
    public static void main(String args[]) {
        Scanner in =  new Scanner(System.in);
        long n,m;
        n = in.nextLong();
        m = in.nextLong();
        long ans = m;
        double temp = (-1 + Math.sqrt(1.0 + 8 * n - 8 *m)) / 2.0;
        ans += (long)(Math.ceil(temp));

        System.out.println(ans);
        in.close();
    }

}