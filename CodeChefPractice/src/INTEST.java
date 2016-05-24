import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class INTEST {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k  = Integer.parseInt(input[1]);
        long num;
        int count = 0;
        for (int i = 0; i < n; i++) {
            num = Long.parseLong(reader.readLine());
            if (num % k == 0)
                count++;
        }
        System.out.println(count);
        reader.close();
    }
}
