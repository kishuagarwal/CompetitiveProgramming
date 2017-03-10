import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 08-02-2015.
 */
public class ChefAndEquality {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int hist[] = new int[100001];
        for (int i = 0; i < t; i++) {
            int n  = in.nextInt();
            Arrays.fill(hist, 0);
            for (int j = 0; j < n; j++) {
                hist[in.nextInt()]++;
            }
            int max = hist[1];
            for (int j = 2; j < hist.length; j++) {
                if( hist[j] > max) {
                    max = hist[j];
                }
            }
            System.out.println(n-max);
        }
        in.close();
    }
}
