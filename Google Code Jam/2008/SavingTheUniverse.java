import java.util.*;

public class SavingTheUniverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i += 1) {
            int n = in.nextInt();
            in.nextLine();
            for (int j = 0; j < n; j += 1) {
                // Don't need the actual names
                in.nextLine();
            }
            int q = in.nextInt();
            in.nextLine();
            Set<String> seenEngines = new HashSet<>();
            int switchesCount = 0;
            for (int j = 0; j < q; j += 1 ) {
                String engine = in.nextLine();
                seenEngines.add(engine);

                if (seenEngines.size() == n) {
                    switchesCount += 1;
                    seenEngines.clear();
                    seenEngines.add(engine);
                }
            }
            System.out.format("Case #%d: %d\n", i + 1, switchesCount);
        }
    }
}