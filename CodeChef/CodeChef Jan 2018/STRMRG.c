#include <stdio.h>

#define min(a, b) ((a) < (b)) ? (a) : (b) 

int n,m;
char first[5005], second[5005];
int dp[5005][5005];

int solve() {
	for (int i = 1; i <= n; i++) {
		dp[i][0] = 1;
	}
	for (int i = 1; i <= m; i++) {
		dp[0][i] = 1;
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			
		}
	}
}

int main(void) {
	int t;
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d", &n, &m);
		scanf("%s", first);
		scanf("%s", second);
		printf("%d\n", solve()); 
	}
	return 0;
}