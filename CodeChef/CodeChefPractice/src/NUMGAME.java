import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class NUMGAME {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(reader.readLine());
            if (num % 2 == 0)
                System.out.println("ALICE");
            else
                System.out.println("BOB");
        }
        reader.close();
    }
}
