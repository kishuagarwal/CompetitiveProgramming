#include <stdio.h>
int presence[2500][2501];
int main(void) {
    int t;
    scanf("%d", &t);
    int lengths[2500];
    for (int i = 0; i < t; i++) {
        int n,k;
        scanf("%d %d", &n, &k);
        for (int j = 0; j < n; j++) {
            for (int x = 0; x <= k; x++)
                presence [j][x] = 0;
        }
        for (int j = 0; j < n; j++) {
            int count;
            scanf("%d", &count);
            lengths[j] = count;
            for (int x = 0; x < count; x++) {
                int num;
                scanf("%d", &num);
                presence[j][num] = 1;
            }
        }
        int ans = 0;
        for (int first = 0; first < n; first++) {
            for (int second = first + 1; second < n; second++) {
                if (lengths[first] + lengths[second] >= k) {
                    int possible = 1;
                    for (int x = 1; x <= k ;x++) {
                        if (presence[first][x] == 0 && presence[second][x] == 0) {
                            possible = 0;
                            break;
                        }
                    }
                    if (possible)
                        ans++;
                }
            }
        }

        printf("%d\n", ans);
    }
}