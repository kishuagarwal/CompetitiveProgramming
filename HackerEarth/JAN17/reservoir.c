#include <stdio.h>

int main(void) {
    int i,j,t,n,m,possible;
    char r[1000][1001];
    scanf("%d", &t);
    while (t--) {
        scanf("%d %d", &n,&m);
        for (i = 0;i < n;i++) {
            scanf("%s", r[i]);
        }
        possible = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m ;j++) {
                if (r[i][j] == 'W') {
                    possible |= (j == 0) || (r[i][j-1] == 'A');
                    possible |= (j == m-1) || (r[i][j+1] == 'A');
                    possible |= (i == n-1) || (r[i+1][j] == 'A');
                }
                if (r[i][j] == 'B') {
                    possible |= ((i != n-1) && (r[i+1][j] == 'A'));
                }
            }
        }
        if (!possible)
            printf("yes\n");
        else
            printf("no\n");
    }
    return 0;
}