import java.util.*;

public class ConsistencyA1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Map<Character, Set<Character>> replacements = new HashMap<>();

        for (int c = 0; c < 26; c += 1) {
            char currentChar = (char) ('A' + c);
            replacements.put(currentChar, new HashSet<>());
            if (currentChar == 'A' || currentChar == 'E' || currentChar == 'I' ||
                currentChar == 'O' || currentChar == 'U') {
                for (int d = 0; d < 26; d += 1) {
                    char replacementChar = (char) ('A' + d);
                    if (replacementChar != 'A' && replacementChar != 'E' && replacementChar != 'I'
                    &&  replacementChar != 'O' && replacementChar != 'U') {
                        replacements.get(currentChar).add(replacementChar);
                    }
                }
            } else {
                replacements.get(currentChar).add('A');
                replacements.get(currentChar).add('E');
                replacements.get(currentChar).add('I');
                replacements.get(currentChar).add('O');
                replacements.get(currentChar).add('U');
            }
        }

        for (int i = 1; i <= t ; i += 1) {
            String s = in.next();
            int min = Integer.MAX_VALUE;

            for (int k = 0; k < 26; k += 1) {
                char currentChar = (char) ('A' + k);
                int count = 0;
                for (char c : s.toCharArray()) {
                    if (c == currentChar) {
                        continue;
                    }
                    if (replacements.get(c).contains(currentChar)) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
                min = Math.min(min, count);
            }
            System.out.println("Case #" + i + ": " + min);
        }
    }
}