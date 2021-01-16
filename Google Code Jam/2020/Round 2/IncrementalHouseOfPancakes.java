import java.util.Scanner;

class IncrementalHouseOfPancakes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i += 1) {
            long l = in.nextLong();
            long r = in.nextLong();

            boolean leftBigger = l >= r;
            long diff = Math.abs(l - r);

            // Phase 1
            // How many customers will be served using the higher stack till the stack becomes lesser in size
            long low = 0, high = (long)Math.sqrt(diff * 2);
            while (low < high) {
                long mid = low + ((high - low + 1) >> 1);
                // Check if mid number of customers can be served
                long required = (mid * (mid + 1)) >> 1;
                if (required <= diff) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            long customersServed = low;
            long initialCustomersServed = low;

            if (leftBigger) {
                l -= (customersServed * (customersServed + 1)) >> 1;
            } else {
                r -= (customersServed * (customersServed + 1)) >> 1;
            }

            // Phase 2
            // Stack 1
            leftBigger = l >= r;
            long bigStackTarget = leftBigger ? l : r;
            low = 0;
            high = (long)Math.sqrt(bigStackTarget * 2);
            while (low < high) {
                long mid = low + ((high - low + 1) >> 1);
                // Check if mid number of customers can be served
                long required = (mid * mid) + mid * initialCustomersServed;
                if (required <= bigStackTarget) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            if (leftBigger) {
                l -= (low * low) + low * initialCustomersServed;
            } else {
                r -= (low * low) + low * initialCustomersServed;
            }
            customersServed += low;

            // Stack 2
            long smallStackTarget = leftBigger ? r : l;
            low = 0;
            high = (long)Math.sqrt(smallStackTarget * 2);
            while (low < high) {
                long mid = low + ((high - low + 1) >> 1);

                // Check if mid number of customers can be served
                long required = (mid * mid) + mid * (initialCustomersServed + 1);
                if (required <= smallStackTarget) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            if (leftBigger) {
                r -= (low * low) + low * (initialCustomersServed + 1);
            } else {
                l -= (low * low) + low * (initialCustomersServed + 1);
            }
            customersServed += low;

            System.out.println("Case #" + i + ": " + customersServed + " " + l + " " + r);
        }
    }
}
