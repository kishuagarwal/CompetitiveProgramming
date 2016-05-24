import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 18-05-2016.
 */
public class ArjitAndPrintingPress {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int pos;
        for (int i = 0; i < t; i++) {
            char w[] = in.next().toCharArray();
            char r[] = in.next().toCharArray();
            Arrays.sort(r);
            pos = 0;
            for (int j = 0; j < w.length && pos < r.length; j++) {
                if (w[j] > r[pos]) {
                    w[j] = r[pos];
                    pos++;
                }
            }
            System.out.println(new String(w));
        }
    }
}
