#include <stdio.h>
#include <math.h>

int primes[1000001];
int primeFactors[50];
int primeFactorCount[50];
int primesFactorFound = -1;
void primeFactorize(long long int m) {
    for (long long int i = 0; i <= m; i++) {
        primes[i] = 1;
    }
    long long int temp = m;
    long long int limit = sqrt(m);
    for (long long int i = 2; i <= m; i++) {
        if(!primes[i]) 
            continue;
        for (long long int j = i * i; j <= m; j++) {
            primes[j]=0;
            if (j == m) {
                primesFactorFound++;
                primeFactors[primesFactorFound] = i;
                while (temp % i == 0) {
                    temp /= i;
                    primeFactorCount[primesFactorFound]++;
                }
            }
        }
    }
}


long long int nCr(long long int n, long long int r, long long int mod) {
    primeFactorize(mod);
    for(int i = 0; i < primesFactorFound; i++) {
        
    } 

}

int main(void) {
    int t;
    long long int n,k,m;
    scanf("%d", &t);

    for (int i = 0; i < t; i++) {
        scanf("%lld %lld %lld", &n, &k, &m);
        if (k > n)
            k = n;
        long long int min = n / k;
        if (n % k)
            min++;
        long long int ways = nCr();
        printf("%lld %lld\n",min, ways);
    }
    return 0;
}