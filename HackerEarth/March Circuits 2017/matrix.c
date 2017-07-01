#include <stdio.h>

int main(void) {
    int n,m;
    scanf("%d %d", &n, &m); 

    int arr[n][n];
    long long int total = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &arr[i][j]);
            total += arr[i][j];
            arr[i][j] = 1;
        }
    }

    total -= n*n;
    for (int i = n-1; i >= 0; i--) {
        for (int j = n-1; j >= 0; j--) {
            if (total <=  m-1) {
                arr[i][j] += total;
                total = 0;
                break;
            } else {
                arr[i][j] = m;
                total -= m-1;
            }
        }
        if (total == 0)
            break;

    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }



}