import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 04-01-2015.
 */
public class SerejaAndVots {

    public static void main(String args[]) throws IOException{
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        int n;
        long sum,zeros;
        for (int i = 0; i < t; i++) {
            n = reader.nextInt();
            sum = 0;
            zeros = 0;
            for (int j = 0; j < n; j++) {
                int temp = reader.nextInt();
                sum += temp;
                if(temp == 0)
                    zeros++;
            }
            if(sum == 100 || (sum > 100 & sum < (100+n-zeros)) )
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        reader.close();
    }
}
