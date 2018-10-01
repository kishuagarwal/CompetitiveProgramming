#include <stdio.h>

char ans[1000001];

int solve(int n, int x, long long int l, long long int r) {
	if (n == x) {
		ans[n-1] = '2';
		return solve(n-1,x,l,r);
	}
	if (n == 0) {
		return l == r;
	}
	if (l < r) {
		if (solve(n-1, x, l+n, r)) {
			ans[n-1] = '0';
			return 1;
		} else {
			ans[n-1] = '1';
			return solve(n-1, x, l, r+n);
		}
	} else {
		if (solve(n-1, x, l, r+n)) {
			ans[n-1] = '1';
			return 1;
		} else {
			ans[n-1] = '0';
			return solve(n-1, x, l+n, r);
		}
	}

}

int main(void) {
	long long int t, x, n;
	scanf("%d", &t);
	while (t--) {
		scanf("%lld %lld", &x, &n);
		long long int l = 0, r = 0;
		int possible = solve(n, x, l, r);
		if (possible) {
			ans[n] = '\0';
			printf("%s\n", ans);
		} else {
			printf("impossible\n");
		}
	}
 	return 0;
}