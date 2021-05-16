import java.util.Scanner;

public class Reversort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int[] arr= new int[n];
            for (int j = 0; j < n; j += 1) {
                arr[j] = in.nextInt();
            }

            int cost = 0;
            for (int j = 0; j < n - 1; j += 1) {
                cost += computeCost(arr, j);
            }

            System.out.println("Case #" + i + ": " + cost);
        }
    }

    private static int computeCost(int[] arr, int i) {
        int pos = i;
        for (int j = i + 1; j < arr.length; j += 1) {
            if (arr[j] < arr[pos]) {
                pos = j;
            }
        }

        // Reverse Sort
        int middle = (pos + i) / 2;
        int count = 0;
        for (int j = i; j <= middle; j += 1) {
            int temp = arr[i + count];
            arr[i + count] = arr[pos - count];
            arr[pos - count] = temp;
            count += 1;
        }
        return pos - i + 1;
    }
}