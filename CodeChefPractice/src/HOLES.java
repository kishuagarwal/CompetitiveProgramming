import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class HOLES {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int holes;
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            holes = 0;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if(c ==  'A' || c == 'B' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R')
                    holes += 1;
                if(c == 'B')
                    holes += 1;
            }
            System.out.println(holes);
        }
        reader.close();
    }
}
