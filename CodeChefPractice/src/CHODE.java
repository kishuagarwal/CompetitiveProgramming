import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class CHODE {
    public static void main(String args[])throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());
        int freq[] = new int[26];
        char mapping[] = new char[26];
        int checked;
        for (int i = 0; i < t; i++) {
            String frequency = reader.readLine();
            String input = reader.readLine();
            Arrays.fill(freq, 0);
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                c = Character.toLowerCase(c);
                if (c >= 'a' && c <= 'z')
                    freq[c-'a']++;

            }
            checked = 25;
            for (int k = 0; k < 26; k++) {
                int largest = - 1;
                int largestPos = -1;
                for (int l = 0; l < 26; l++) {
                    if (freq[l] != 0 && freq[l] >= largest){
                        largest = freq[l];
                        largestPos = l;
                    }
                }
                if(largestPos != -1){
                    mapping[largestPos] = frequency.charAt(checked);
                    freq[largestPos] = 0;
                    checked--;
                }
            }
            StringBuffer buffer = new StringBuffer(input);
            for (int k = 0; k < input.length(); k++) {
                char ch = input.charAt(k);
                if ( Character.toLowerCase(ch) >= 'a'  && Character.toLowerCase(ch) <= 'z'){
                    if(Character.isUpperCase(ch))
                        buffer.setCharAt(k,Character.toUpperCase(mapping[ch-'A']));
                    else
                        buffer.setCharAt(k,mapping[ch-'a']);
                }
                else
                    buffer.setCharAt(k,ch);
            }
            pw.println(buffer);
        }
        reader.close();
        pw.flush();
        pw.close();
    }



}
