import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 24-12-2014.
 */
public class SEV {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a,h,theta;
        int ans;
        double temp;
        for (int i = 0; i < t; i++) {
            a = in.nextInt();
            h = in.nextInt();
            theta = in.nextInt();
            temp = (0.5 * a * Math.tan(theta * 3.141593 / 180));
            ans = (int)Math.ceil(h - temp);
            System.out.println(ans);
        }
        in.close();
    }
}
