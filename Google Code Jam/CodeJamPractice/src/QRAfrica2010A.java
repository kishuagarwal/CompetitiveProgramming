import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 09-03-2015.
 */
public class QRAfrica2010A {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int items[] = new int[2000];
        int first = 0,second = 0;
        for (int i = 1; i <= n; i++) {
            int c = in.nextInt();
            int nitems = in.nextInt();
            for (int j = 0; j < nitems; j++) {
                items[j] = in.nextInt();
            }
            boolean found = false;

            for (int j = 0; j < nitems && !found; j++) {
                for (int k = j+1; k < nitems && !found; k++) {
                    if (items[k] + items[j] == c){
                        found= true;
                        first = j+1;
                        second = k+1;
                    }
                }
            }
            System.out.println("Case #"+i+": "+first+ " "+second);
        }
        in.close();
    }
}
