#include <iostream>
#include <set>
#include <string.h>


#define min(a,b) ((a) <= (b) ? (a) : (b))
#define maxi(a,b) ((a) >= (b) ? (a) : (b))


long long gcd(long long a, long long b) {
     if (b == 0) {  
        return a;
    }
    return gcd(b, a % b);
}

int main(void) {
 int t,n,i,j,k,m,x,y;
 long long max, temp,g;
 char s[310];
 std::set<long long> dp[310][310];
 long long num[310][310];
 std::cin >> t;
 while(t--) {
     memset(dp,0, sizeof(long long));
     memset(num, 0, sizeof(long long));
     std::cin >> n;
     std::cin >> s;
     std::cin >> m >> x >> y;
     for (i = 0; i < n; i++) {
        for (k = 0; k <= y+1; k++) {
            dp[i][k].clear();
        }
     }
     for (i = 0; i < m; i++) {
         for (j = 0; j+i<n;j++) {
                 if (i == 0) {
                     num[j][j] = (int)(s[j] - '0');
                 }
                 else 
                    num[j][j+i] = num[j][j+i-1]*10 + (int)(s[j+i] - '0'); 
        }
    }
    
    // When only one separator is being used
    for (i = 0; i < min(m,n); i++) {
        dp[i][1].insert(num[0][i]);
    }

    for (i = 0; i < n; i++) {
        for (k = 1; k <= y; k++) {
            for (j = i+1; j <= min(n-1, i+m); j++) {
                temp = num[i+1][j];
                for (auto g: dp[i][k]) {
                    dp[j][k+1].insert(gcd(g, temp));
                }
            }
        }
    }

    max = 0;
    for (i = x+1; i <= y+1;i++) {
        for (auto g: dp[n-1][i]) {
            max = maxi(max, g);
        }

    }

    std::cout << max << std::endl;
}
    return 0;
 }
