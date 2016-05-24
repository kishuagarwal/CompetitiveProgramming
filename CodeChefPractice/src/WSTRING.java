import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class WSTRING {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        int max;
        int counts[] = new int[10000];
        int freq[] = new int[26];
        int pos;
        for (int i = 0; i < t; i++) {
            String input = reader.readLine();
            max = 0;
            pos = 0;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch != '#')
                    freq[ch - 'a']++;
                else {
                    int m = 0;
                    for (int k = 0; k < 26; k++) {
                        if (freq[k] > m) m = freq[k];
                        freq[k] = 0;
                    }
                    counts[pos++] = m;

                }
            }
            if (input.charAt(input.length()-1) != '#'){
                int m = 0;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > m) m = freq[k];
                    freq[k] = 0;
                }
                counts[pos++] = m;
            }
            else
                counts[pos++] = 0;
            for (int j = 0; j < pos-2; j++) {
                if (counts[j] != 0 && counts[j+1] != 0 && counts[j+2] != 0 && counts[j+3] != 0){
                    int sum = counts[j] + counts[j+1] + counts[j+2] + counts[j+3];
                    if (sum > max) max = sum;
                }
            }
            if (max != 0)
                pw.println(max+3);
            else
                pw.println(max);
        }
        reader.close();
        pw.flush();
        pw.close();
    }
}
