import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 21-12-2014.
 */
public class Player {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int p;
        double oldValue,newValue,nth,threshold = 0.001;
        for (int i = 0; i < t; i++) {
            int n;
            n = in.nextInt();
            newValue = 1.0/n;
            nth  = (n-1)/(double)n;
            p = 2;
            do {
                oldValue = newValue;
                newValue = oldValue + p*nth*(1.0/n);
                p++;
                nth *= (n-1)/(double)n;
            //    System.out.println(oldValue + "   "+newValue);
            }while((newValue-oldValue) > threshold);

            double ans = newValue*n;
            System.out.println(ans);
        }
    }
}
