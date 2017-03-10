import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Kishu Agarwal on 04-01-2015.
 */
public class OneDimensionalKingdom {

    public static void main(String args[])throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int pos[] = new int[2004];
        String[] p = new String[2];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            Arrays.fill(pos,0);
            for (int j = 0; j < n; j++) {
                p = reader.readLine().split(" ");
                int a = Integer.parseInt(p[0]);
                int b = Integer.parseInt(p[1]);

            }
        }
        reader.close();
    }
}
