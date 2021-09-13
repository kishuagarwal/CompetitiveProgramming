import java.util.*;

public class XAndO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            char[][] matrix = new char[n][n];
            for (int j = 0; j < n; j += 1) {
                String s = in.next();
                matrix[j] = s.toCharArray();
            }

            int minCellCount = Integer.MAX_VALUE;
            List<Set<Integer>> sets = new ArrayList<>();

            for (int r = 0; r < n; r += 1) {
                boolean possible = true;
                Set<Integer> set = new HashSet<>();
                for (int c = 0; c < n; c += 1) {
                    if (matrix[r][c] == 'X') {
                        continue;
                    }
                    if (matrix[r][c] == 'O') {
                        possible = false;
                        break;
                    }
                    set.add(r * n + c);
                }
                if (possible && set.size() <= minCellCount) {
                    if (set.size() < minCellCount) {
                        minCellCount = set.size();
                        sets.clear();
                    }
                    if (isDifferentSet(sets, set)) {
                        sets.add(set);
                    }
                }
            }

            for (int c = 0; c < n; c += 1) {
                boolean possible = true;
                Set<Integer> set = new HashSet<>();
                for (int r = 0; r < n; r += 1) {
                    if (matrix[r][c] == 'X') {
                        continue;
                    }
                    if (matrix[r][c] == 'O') {
                        possible = false;
                        break;
                    }
                    set.add(r * n + c);
                }
                if (possible && set.size() <= minCellCount) {
                    if (set.size() < minCellCount) {
                        minCellCount = set.size();
                        sets.clear();
                    }
                    if (isDifferentSet(sets, set)) {
                        sets.add(set);
                    }
                }
            }

            if (minCellCount == Integer.MAX_VALUE) {
                System.out.println("Case #" + i + ": Impossible");
            } else {
                System.out.println("Case #" + i + ": " + minCellCount + " " + sets.size());
            }
        }
    }

    private static boolean isDifferentSet(List<Set<Integer>> sets, Set<Integer> set) {
        for (Set<Integer> x: sets) {
            if (x.equals(set)) {
                return false;
            }
        }
        return true;
    }
}
