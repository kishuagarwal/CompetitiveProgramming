import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w[] = new int[n];
        for (int i = 0; i < n; i++) w[i] = in.nextInt();
        Arrays.sort(w);
        int units = 1,lastItem = w[0];
        for (int i = 1; i < n; i++)
            if (w[i] > (lastItem + 4)) {
                lastItem = w[i];
                units++;
            }
        System.out.println(units);
        in.close();
    }
}
