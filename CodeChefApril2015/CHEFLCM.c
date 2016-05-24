#include <stdio.h>
#include <math.h>


int notmainmain(void) {
	int t,i;
	long long n,sq,ans;
	scanf("%d",&t);
	while (t--) {
		scanf("%lld",&n);
		sq = sqrt(n);
		ans = 0L;
		for (i = 1 ; i <= sq; i++) {
			if (n % i == 0) {
				ans += i + n/i;
			}
		}
		if (sq * sq == n) //perfect square
			ans -= sq;
		printf ("%lld\n",ans);
	}
	return 0;
}
