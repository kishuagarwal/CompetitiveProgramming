import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 03-01-2015.
 */
public class ChefAndStones {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        long times[] = new long[100003];
        for (int i = 0; i < t; i++) {
            String input[] = in.readLine().split(" ");
            long n = Long.parseLong(input[0]);
            long k = Long.parseLong(input[1]);
            input = in.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                times[j] = k/Long.parseLong(input[j]);
            }
            input = in.readLine().split(" ");
            long max = times[0] * Long.parseLong(input[0]);
            for (int j = 1; j < n; j++) {
               long temp = times[j] * Long.parseLong(input[j]);
                if(temp > max)
                    max = temp;
            }
            System.out.println(max);
        }
    }
}
