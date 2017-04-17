import java.util.*;

/**
 * Created by kishu on 11/4/17.
 */
public class CHEFDIV {

    private static int primes[];
    private static long left[];
    private static long a,b;
    private static ArrayList<Map<Integer, Integer>> factors;

    public static void findPrimeFactorization() {
        for (int i = 2; i <= 1000000; i++) {
            if (primes[i] != 0)
                continue;
            primes[i] = i;
            for (long j = (long) i * i; j <= 1000000; j += i) {
                if (primes[(int)j] == 0) {
                    primes[(int)j] = i;
                }
            }
                long start = a / i;
                if ((a / i) * i < a) {
                    start++;
                }
                for (long j = start * i; j <= b; j += i) {
                    long temp = left[(int) (j - a)];
                    if (!factors.get((int) (j - a)).containsKey(i)) {
                        factors.get((int) (j - a)).put(i, 0);
                    }
                    while (temp % i == 0) {
                        temp /= i;
                        factors.get((int) (j - a)).put(i, factors.get((int) (j - a)).get(i) + 1);
                    }
                    left[(int) (j - a)] = temp;
                }

            }
        for (long i = a; i <= b; i++) {
            if (left[(int)(i-a)] > 1) {
                factors.get((int)(i-a)).put(1000007, 1);
            } 
        }

    }

    private static long find(long num) {
        if (num == 1)
            return 0;
        long ans = 0;
        Map<Integer, Integer> factorization;
        if (num > 1000000) {
            factorization = factors.get((int)(num - a));
        } else {
            factorization = new HashMap<Integer, Integer>();
            while (num > 1) {
                int primeFactor = primes[(int)num];
                num /= primeFactor;
                if (factorization.containsKey(primeFactor)) {
                    factorization.put(primeFactor, factorization.get(primeFactor) + 1);
                }else {
                    factorization.put(primeFactor, 1);
                }
            }
        }
        while (true) {
            int temp = 1;
            int max_key = 0;
            int max_value = 0;
            for (int key: factorization.keySet()) {
                int count = factorization.get(key);
                temp = temp * (count + 1);
                if (count > max_value) {
                    max_value = count;
                    max_key = key;
                }
            }
            ans += temp - 1;
            int num_primes = factorization.keySet().size();
            if (max_value == 1 && num_primes == 1) {
                ans += 1;
                break;
            }
            if (max_value == 1 && num_primes == 2) {
                ans += 3;
                break;
            }
            if(max_key == 0)
                System.out.println("Max key " + num);
            if (max_value == 1)
                factorization.remove(max_key);
            else
                factorization.put(max_key, factorization.get(max_key) - 1);
            ans += 1;
        }
        return ans;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        a = in.nextLong();
        b = in.nextLong();
        primes = new int[10000007];
        
        factors = new ArrayList<Map<Integer, Integer>>();
        int size = (int)(b-a+1);
        left = new long[size];
        for (int i = 0; i < size; i++) {
            factors.add(new HashMap<Integer,Integer>());
            left[i] = i + a;
        }
        findPrimeFactorization();
        long ans = 0;
        for (long c = a; c <= b; c++) {
                ans += find(c);
        }
        System.out.println(ans);
    }


}
