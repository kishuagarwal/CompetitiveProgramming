#include <stdio.h>
#include <stdlib.h>

int comp(const void* elem1, const void* elem2) {
	int first = *((int*)elem1);
    int second = *((int*)elem2);
    if (first < second) return -1;
    if (first > second) return  1;
    return 0;
}

int arr[702][702];
int main(void) {
	int t, n;
	int a,b,c,d;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				scanf("%d", &arr[i][j]);
			}
			qsort(arr[i], n, sizeof(int), comp);
		}
		long long int ans = arr[n-1][n-1];
		int nums_found = 1;
		int last = arr[n-1][n-1];
		for (int i = n - 2; i >= 0; i--) {
			int found = 0;
			for (int j = n - 1; j >= 0; j--) {
				if (arr[i][j] < last) {
					ans += arr[i][j];
					last = arr[i][j];
					found = 1;
					nums_found++;
					break;
				}
			}
			if (!found) {
				break;
			}
		}
		if (nums_found != n) {
			printf("-1\n");
		} else {
			printf("%lld\n", ans);
		}

	}
	return 0;
}