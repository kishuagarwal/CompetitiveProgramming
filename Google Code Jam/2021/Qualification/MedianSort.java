import java.util.LinkedList;
import java.util.Scanner;

public class MedianSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            LinkedList<Integer> list = new LinkedList<>();

            // Initial order
            for (int j = 0; j < n; j += 1) {
                list.add(j + 1);
            }

            System.out.println("1 2 3");
            int median = in.nextInt();
            if (median == 1) {
                list.set(0, 2);
                list.set(1, 1);
            } else if (median == 3) {
                list.set(2, 2);
                list.set(1, 3);
            }

            // First 3 elements are in order now

            for (int j = 3; j < n; j += 1) {
                // Find correct position using binary search
                int pos = findPos(list, j, in);
                // Set the element in the correct position
                list.add(pos, list.get(j));
                list.remove(j + 1);
            }

            for (int j = 0; j < n; j += 1) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
            in.nextInt(); // ignore the judge result
        }
    }

    private static int findPos(LinkedList<Integer> list, int targetIndex, Scanner in ) {
        int lo = 0, hi = targetIndex - 1;

        while (lo < hi) {
            int middle = lo + (hi - lo + 1) / 2;
            System.out.println(list.get(lo) + " " + list.get(middle) + " " + list.get(targetIndex));
            int median = in.nextInt();
            if (median == list.get(lo)) {
                return 0;
            } else if (median == list.get(middle)) {
                lo = middle;
            } else {
                hi = middle - 1;
            }
        }

        return hi + 1;
    }
}
