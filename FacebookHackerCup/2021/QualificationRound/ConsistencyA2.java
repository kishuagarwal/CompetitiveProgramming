import java.util.*;

public class ConsistencyA2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t ; i += 1) {
            String s = in.next();
            int[][] replacementSeconds = new int[26][26];
            for (int r = 0; r < 26; r += 1) {
                Arrays.fill(replacementSeconds[r], -1);
                replacementSeconds[r][r] = 0;
            }

            int replacementCount = in.nextInt();
            for (int x = 1; x <= replacementCount; x += 1) {
                String replacementPair = in.next();
                replacementSeconds[replacementPair.charAt(0) - 'A'][replacementPair.charAt(1) - 'A'] = 1;
            }

            for(int x = 1; x <= 26; x += 1) {
                for (int r = 0; r < 26; r += 1) {
                    for (int c = 0; c < 26; c += 1) {
                        for (int k = 0; k < 26; k += 1) {
                            if (replacementSeconds[r][k] != -1 && replacementSeconds[k][c] != -1) {
                                if (replacementSeconds[r][c] == -1) {
                                    replacementSeconds[r][c] = replacementSeconds[r][k] + replacementSeconds[k][c];
                                } else {
                                    replacementSeconds[r][c] = Math.min(replacementSeconds[r][c],
                                            replacementSeconds[r][k] + replacementSeconds[k][c]);
                                }
                            }
                        }
                    }
                }
            }


            int min = Integer.MAX_VALUE;

            for (int k = 0; k < 26; k += 1) {
                char currentChar = (char) ('A' + k);
                int count = 0;
                boolean possible = true;
                for (char c : s.toCharArray()) {
                    if (c == currentChar) {
                        continue;
                    }
                    if (replacementSeconds[c - 'A'][currentChar - 'A'] == -1) {
                        possible = false;
                        break;
                    } else {
                        count += replacementSeconds[c - 'A'][currentChar - 'A'];
                    }
                }
                if (possible) {
                    min = Math.min(min, count);
                }
            }
            System.out.println("Case #" + i + ": " + (min == Integer.MAX_VALUE ? -1 : min));
        }
    }
}