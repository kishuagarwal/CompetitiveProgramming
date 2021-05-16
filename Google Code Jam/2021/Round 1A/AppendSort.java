import java.util.Scanner;

public class AppendSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            StringBuilder prev = new StringBuilder(String.valueOf(in.nextLong()));

            int ans = 0;
            for (int j = 1; j < n; j += 1) {
                StringBuilder current = new StringBuilder(String.valueOf(in.nextLong()));
                ans += findCount(prev, current);
                prev = current;
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static int findCount(StringBuilder prevString, StringBuilder currentString) {
        int prevLength = prevString.length();
        int currentLength = currentString.length();

        // 123 and 1234
        if (currentLength > prevLength) {
            return 0;
        }

        boolean currentLarger = false;
        int index;
        for (index = 0; index < currentLength; index += 1) {
            if (currentString.charAt(index) != prevString.charAt(index)) {
                if (currentString.charAt(index) > prevString.charAt(index)) {
                    currentLarger = true;
                }
                break;
            }
        }

        // 123 and 13
        if (currentLarger) {
            currentString.append("0".repeat((prevLength - currentLength)));
            return prevLength - currentLength;
        } else {
            // Current number digits matches the prefix of the prev number
            if (index == currentLength) {
                // 123 and 12 => 123 and 124
                // 129 and 12 => 129 and 1200
                // 1299499 and 12 => 1299499 and 1299500
                // Copy over the remaining characters
                int count = 0;

                boolean found = false;
                // Find the first non-nine digit from the right
                for (int j = prevLength - 1; j >= index; j -= 1) {
                    if (prevString.charAt(j) != '9') {
                        found = true;
                        for (int k = index; k < j; k += 1) {
                            currentString.append(prevString.charAt(k));
                        }
                        currentString.append((char) (prevString.charAt(j) + 1));
                        currentString.append("0".repeat(Math.max(0, prevLength - (j + 1))));
                        break;
                    }
                }
                count = prevLength - currentLength;

                if (!found) {
                    currentString.append("0".repeat(prevLength - currentLength + 1));
                    count += 1;
                }
                return count;
            }

            // 123 and 11
            currentString.append("0".repeat(prevLength - currentLength + 1));
            return prevLength - currentLength + 1;
        }
    }
}