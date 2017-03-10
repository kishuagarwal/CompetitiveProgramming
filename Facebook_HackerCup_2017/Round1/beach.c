#include <stdio.h>
#define size 100000007
typedef long long int ll;

ll mod = 1000000007;

ll fact[size];

void factorials() {
    long s = 40,i;
    ll t = 1;
    fact[0] = 1;
    for (i = 1; i <= mod; i++) {
        t = (t * i) % mod;
        if (i % s == 0) {
            fact[i/s] = t;
        }
    }
}

ll get_fact(ll n) {
    long s =40;
    long i;
    ll start= (n/s) * s, end=n;
    ll ans = fact[n/s];
    for (i = start + 1; i <= end; i++) {
        ans = (ans * i) % mod;
    }
    return ans;
}

ll power(ll a, ll b){
    ll ans = 1;
    ll y = a;
    while (b > 0) {
        if (b % 2 == 1) {
            ans = ans * y;
            if (ans > mod)
                ans %= mod;
        }
        y = y * y;
        if (y > mod)
            y %= mod;
        b /= 2;;
    }
    return ans;
}

ll inverse(ll n) {
    return power(n,mod-2);
}

ll ncr(ll n,ll r) {
    ll i;
    ll numer = 1,denom;
    if (r == 0 || r == n)
        return 1;
    numer = get_fact(n);
    denom = (inverse(get_fact(r)) * inverse(get_fact(n-r))) % mod;
    return (numer * denom) % mod;
}

void main(void) {
    ll t,n,m,i,j,k, total_ways, left,right,s,ways,covered,left_over_space;
    ll r[2010];
    factorials();
    scanf("%lld", &t);

    for (i = 1; i <= t; i++) {
        scanf("%lld %lld", &n, &m);
        s = 0;
        for (j = 0; j < n; j++) {
                scanf("%lld", &r[j]);
                s += r[j];
        }
        total_ways = 0;
        if (n == 1)
            total_ways = m % mod;
        if (n <= m && n >= 2) {
            for(left = 0; left <n ;left++) {
                for (right = left+1;right <n; right++) {
                    ways = 0;
                    covered = 2 * s - r[left] - r[right];
                    if (covered <= (m-1)) {
                        ways += 2 * get_fact(n-2);
                        if (ways >= mod)
                            ways = ways % mod;
                        left_over_space = m- 1 - covered;
                        ways *= ncr(left_over_space + n, n);
                        if (ways >= mod)
                            ways = ways % mod;
                    }
                    total_ways += ways;
                    if (total_ways >= mod)
                        total_ways = total_ways % mod;
                }
            }
        }
        printf("Case #%lld: %lld\n", i, total_ways % mod);
    }
}   