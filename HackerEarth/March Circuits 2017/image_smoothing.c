#include <stdio.h>


int main(void) {
    int n,m;
    scanf("%d %d", &n, &m);
    int filter[2*m+1][2*m+1];
    for (int i = 0; i < 2 * m + 1; i++) {
        for (int j = 0; j < 2 * m + 1; j++) {
            scanf("%d",&filter[i][j]);
        }
    }
    int image[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d",&image[i][j]);
        }
    }    

    int output[n][n];

    for (int i = 0; i < n ; i++) {
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int x = -m; x <= m; x++) {
                for (int y = -m; y <=m ;y++) {
                    if (i + x < 0 || i + x >= n || j + y < 0 || j + y >= n) {
                        continue;
                    }
                    sum += image[i+x][j+y] * filter[m+x][m+y];
                }
            }
            output[i][j] = sum;
        }
    }

    for (int i =0 ; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", output[i][j]);
        }
        printf("\n");
    }
    return 0;
}