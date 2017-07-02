#include <iostream>
#include <cmath>

using namespace std;

int initial[32000]; 
int primes[100001];

void generatePrimes(int m, int n) {
    for(int i = 0; i < 32000; i++) {
        initial[i] = 1;
    }
    for (int i = 0; i <= (n -m); i++) {
        primes[i] = 1;
    }
    int limit = sqrt(n)+1;
    if (m == 1) {
        primes[0] = 0;
    }
    for (int i = 2; i <= limit; i++) {
        if (initial[i]) {
            int start;
            if (m <= i) {
                start = i * i;
            } else {
                start = (m / i) * i;
                if (start == i)
                    start += i;
            }
        for (int j = start; j <= n; j += i) {
            if (j >= m && j <= n) {
                primes[j - m] = 0;
            }
            if (j < 32000) {
                initial[j] = 0;
            }
        }
    }
    }
}


int main(void) {
    int t;
    int m,n;
    cin >> t;
    while (t--) {
        cin >> m >> n;
        generatePrimes(m,n);
        for (int i = 0; i <= (n -m); i++) {
            if (primes[i]) {
                cout << m + i << endl;
            }
        } 
        cout << endl;
    }

    return 0;
}