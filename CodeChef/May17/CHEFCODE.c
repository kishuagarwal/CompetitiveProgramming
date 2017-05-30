#include <stdio.h>
#include <stdlib.h>

long long pow2(int p) {
    long long temp = 1;
    for (int i = 0; i < p; i++) {
        temp = temp << 1;
    }
    return temp;
}
long long calculate(long long l[], int pos, long long k) {
    if (pos < 0)
        return 0;
    if (l[pos] > k)
        return 0;
    long long ways = 1;
    long long left = k / l[pos];
    long long temp = 1;
    int i;
    for (i = 0; i < pos; i++) {
        temp = temp * l[pos];
        if (temp > left || temp <= 0) {
            break;
        }
    }
    ways += pow2(i) - 1;

    for (; i < pos; i++) {
        ways += calculate(l, i, left);
    }
    return ways;
}

int cmpfunc(const void *a, const void *b) {
    //long long x = *(long long*)a;
    //long long y = *(long long*)b;
    // return *(long long*)a;
    long long x = *(long long*)a - *(long long*)b;
    if (x < 0)
        return -1;
    if (x == 0)
        return 0;
    return 1; 
}

int main(void) {
    int n = 30;
    long long k = 1000;
    long long ans = 0;
    long long a=  1e18;
    long long b=  1e18;
    printf("%lld\n", a*b);
    //scanf("%d %lld", &n, &k);
    long long l[30];
    for (int i = 0; i < n; i++) {
        //scanf("%lld", &l[i]);
        l[i] = 1;
    }
    qsort(l, n, sizeof(long long), cmpfunc);
    //printf("%lld %lld %lld", l[0], l[1], l[2]);
    for (int i = 0; i < n; i++) {
        ans += calculate(l, i, k);
    }
    printf("%lld", ans);

}