import java.util.Arrays;
import java.util.Scanner;

public class ReverseSortEngineering {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int c = in.nextInt();

            if (!possible(n, c)) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j += 1) {
                arr[j ] = j + 1;
            }

            int[] costs = new int[n];
            computeCosts(costs, c);
            findString(arr, costs);

            System.out.print("Case #" + i + ": ");
            for(int j = 0; j < n; j += 1) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean possible(int n, int c) {
        int min = n - 1;
        int max = ((n * (n + 1)) / 2) - 1;

        return c >= min && c <= max;
    }

    private static void computeCosts(int[] costs, int c) {
        int n = costs.length;

        Arrays.fill(costs, 1);
        costs[n - 1] = 0;

        int left = c - (n - 1);
        for (int j = 0; j < n - 1; j += 1) {
            if (n - j - 1 <= left) {
                costs[j] += n - j - 1;
                left -= n - j - 1;
            } else {
                costs[j] += left;
                left = 0;
                break;
            }
        }
    }

    private static void findString(int[] arr, int[] costs) {
        int n = arr.length;

        for (int j = n - 2; j >= 0; j -= 1) {
            // Reverse the string j..arr[costs[j]]

            int start = j;
            int end = j + costs[j] - 1;

            int middle = (start + end) / 2;
            int count = 0;
            for (int k = start; k <= middle; k += 1) {
                int temp = arr[start + count];
                arr[start + count] = arr[end - count];
                arr[end - count] = temp;
                count += 1;
            }
        }
    }
}
