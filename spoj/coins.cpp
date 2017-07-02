#include <iostream>
#include <cstdio>

using namespace std;
long long cache[1000000];


long long max(long long n) {
    if(n == 0) {
        return 0;
    }
    if (n < 1000000 and cache[n] != 0)
        return cache[n];
    long long chain = n/2 + n/3 + n/4;
    long long ans;
    if (chain >= n) {
        long long  temp = max(n/2) + max(n/3) + max(n/4);
        ans = temp;
    }
    else 
        ans = n;
    if (n < 1000000)
        cache[n] = ans;
    return ans;
}


int  main(void) {
    long long  n;
    for (long long  i = 0; i < 1000000; i++) {
        cache[i] = 0;
    }
    while (scanf("%lld", &n)!= EOF) {
        cout << max(n) << endl;
    }
    return 0;
}