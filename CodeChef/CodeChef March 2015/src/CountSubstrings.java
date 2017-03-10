import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kishu Agarwal on 10-03-2015.
 */
public class CountSubstrings {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int n, q, k, l, r, pos;
        long ans;
        String s;
        String input[];
        long substrings[] = new long[100000];
        int startings[] = new int[100000];
        int starting, zeroCount, oneCount;

        for (int i = 0; i < t; i++) {
            input = reader.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);
            q = Integer.parseInt(input[2]);
            s = reader.readLine();
            substrings[0] = 1;
            zeroCount = 0;
            oneCount = 0;
            if (s.charAt(0) == '1')
                oneCount = 1;
            else
                zeroCount = 1;
            starting = 0;
            pos = 0;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    if (oneCount == k) //can't increase ones,so need to shift till one 1 is removed
                    {
                        while (s.charAt(starting) != '1') {
                            starting++;
                            zeroCount--;
                        }
                        starting++; //skip the 1

                        while (pos != starting) {
                            startings[pos] = j - 1;
                            pos++;
                        }

                    } else
                        oneCount++;
                } else {
                    if (zeroCount == k) {
                        while (s.charAt(starting) != '0') {
                            starting++;
                            oneCount--;
                        }
                        starting++; //skip the 0
                        while (pos != starting) {
                            startings[pos] = j - 1;
                            pos++;
                        }
                    } else
                        zeroCount++;
                }
                substrings[j] = substrings[j - 1] + j - starting + 1; //substrings which ends at j
            }
            for (int j = pos; j < s.length(); j++) {
                startings[j] = s.length() - 1;
            }
            for (int j = 0; j < q; j++) {
                input = reader.readLine().split(" ");
                l = Integer.parseInt(input[0]);
                r = Integer.parseInt(input[1]);

                int len = Math.min(startings[l - 1] - (l - 1) + 1, r - l + 1);
                if (startings[l - 1] <= (r - 1))
                    ans = substrings[r - 1] - substrings[startings[l - 1]] + (len * (len + 1) >> 1);
                else
                    ans = (len * (len + 1) >> 1);
                System.out.println(ans);

            }
        }
        reader.close();
    }
}
