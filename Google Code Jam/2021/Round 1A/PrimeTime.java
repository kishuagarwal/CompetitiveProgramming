import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrimeTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int m = in.nextInt();
            Map<Integer, Long> primeCount = new LinkedHashMap<>();
            long sum = 0;
            for (int j = 1; j <= m; j += 1) {
                int prime = in.nextInt();
                long count = in.nextLong();
                primeCount.put(prime, count);
                sum += prime * count;
            }
            long ans = 0;
            for (long j = 1; j < sum && j <= 30303; j += 1) {
                if (possible(sum - j, primeCount)) {
                    ans = sum - j;
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static boolean possible(long num, Map<Integer, Long> primeCount) {
        if (num < 0) {
            return false;
        }
        Map<Integer, Long> primeCountClone = new HashMap<>(primeCount);

        long numCopy = num;
        for (Integer prime: primeCountClone.keySet()) {
            while (num > 1 && primeCountClone.get(prime) > 0 && num % prime == 0) {
                primeCountClone.put(prime, primeCountClone.get(prime) - 1);
                num /= prime;
            }
        }

        long sum = 0;
        for (Integer prime: primeCountClone.keySet()) {
            sum += prime * (long) primeCountClone.get(prime);
        }
        return sum == numCopy && num == 1;
    }
}
