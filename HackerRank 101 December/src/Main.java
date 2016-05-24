import java.util.Scanner;

public class Main {


    public static void solve(Scanner in){
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
         long n = in.nextLong();
            n = n ^ Long.MAX_VALUE;
            long nNumber = (1L << 32) - 1;
            n = n & nNumber;
                System.out.println(n);
        }

    }

}
