import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 08-02-2015.
 */
public class RankList {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            long s=  in.nextLong();
            long temp = 0;
            int count = 0;
            while (temp < s){
                count++;
                temp += count;
            }
            System.out.println(n - count);
        }
        in.close();
    }
}
