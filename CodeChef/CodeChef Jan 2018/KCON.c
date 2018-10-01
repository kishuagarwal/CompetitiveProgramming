#include <stdio.h>

#define max(a, b) ((a) > (b)) ? (a) : (b)

long long int arr[200005];
long long int toThis[200005];

int main(void) {
	int t, n, k;
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d",&n, &k);
		long long int total = 0;
		for (int i = 0; i < n; i++) {
			scanf("%lld", &arr[i]);
			total += arr[i];
			if ( k > 1)
				arr[i + n] = arr[i];
		}
		long long int maxSoFar = arr[0];
		toThis[0] = arr[0];
		int currentStart = 0, currentEnd = 0, maxStart = 0, maxEnd = 0;
		int limit = (k > 1) ? (2 * n) : n;
		for (int i = 1; i < limit; i++) {
			if (arr[i] > toThis[i-1] + arr[i]) {
				currentStart = i;
				currentEnd = i;
				toThis[i] = arr[i];
			} else {
				currentEnd++;
				toThis[i] = toThis[i-1] + arr[i];				
			}
			if (maxSoFar < toThis[i]) {
				maxStart = currentStart;
				maxEnd = currentEnd;
				maxSoFar = toThis[i];
			}
		}
/*		long long int maxFromFirst = arr[0];
		long long int currentFromFirst = arr[0];
		for (int i = 1; i < n; i++) {
			currentFromFirst += arr[i];
			maxFromFirst = max(maxFromFirst, currentFromFirst);
		}
*/
		long long int ans = maxSoFar;
		if (total > 0 &&  k > 2 && maxStart <= n - 1 && maxEnd >= n) {
			ans += total * (k - 2);
		}
		printf("%lld\n", ans);
	}
	return 0;
}