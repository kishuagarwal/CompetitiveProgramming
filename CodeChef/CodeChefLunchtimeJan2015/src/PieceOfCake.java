import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kishu Agarwal on 25-01-2015.
 */
public class PieceOfCake {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int freq[] = new int[26];
        for (int i = 0; i < t; i++) {
            String input = in.next();
            Arrays.fill(freq,0);
            for (int j = 0; j < input.length(); j++) {
                freq[input.charAt(j)-'a']++;
            }
            boolean found = false;
            for (int j = 0; j < 26; j++) {
                if(freq[j] == input.length()-freq[j])
                {
                    found = true;
                    break;
                }
            }
            if(found) System.out.println("YES");
            else
                System.out.println("NO");

        }
        in.close();
    }
}
