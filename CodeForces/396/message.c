#include <stdio.h>
#define max(a,b) ((a) > (b)) ? (a) : (b)
#define min(a,b) ((a) < (b)) ? (a) : (b)
long long dp[1004][3];

int main(void) {
    int n,f[26], count, start, c,i, j, k, rc[26],cont;
    long mod = 1000000007;
    char s[1004];
    scanf("%d", &n);
    scanf("%s", s);
    for (i = 0; i < 26; i++) {
        scanf("%d", &f[i]);
        rc[i] = 0;
    }
    for (i = 0; i < n; i++) {
        dp[i][0] = 0;
        dp[i][1] = 0;
        dp[i][2] = 100000;
    }
    dp[0][0] = 1;
    dp[0][1] = 1;
    dp[0][2] = 1;
    rc[s[0] - 'a']++;
    start = 0;
    for (i = 1; i < n; i++) {
        c = (int)(s[i] - 'a');
        count = f[c];
        rc[c]++;
        cont = 1;
        while (cont) {
           cont = 0;
            for (k =0 ; k < 26; k++) {
                if (rc[k] > 0 && (i-start+1) > f[k]) {
                    rc[s[start] - 'a']--;
                    start++;
                    cont = 1;
                }
            }
        }
        for (j = i; j >= 0 && j >= start; j--) {
            if (j == 0) {
                dp[i][0] = (dp[i][0] + 1) % mod;
                dp[i][1] =  (i + 1) % mod;
                dp[i][2] = 1;
            }
            else {
                dp[i][0] = (dp[i][0] + dp[j-1][0]) % mod;
                dp[i][1] = (max(dp[i][1], max(i - j + 1, dp[j-1][1])))  % mod;
                dp[i][2] = (min(dp[j-1][2] + 1, dp[i][2]) )  % mod;
            }

        }
    }
    printf("%ld\n%ld\n%ld", (long int)dp[n-1][0], (long int)dp[n-1][1], (long int)dp[n-1][2]);
    return 0;
}