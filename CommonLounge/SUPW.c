#include <stdio.h>
#define min(a,b) ((a < b) ? (a) : (b))

int main(void) {
    int n;
    scanf("%d", &n);
    int m[n];
    int result[n];
    int whileTaking[n];
    for (int i = 0; i < n ; i++) {
        scanf("%d", &m[i]);
        if (i == 0 ) {
            whileTaking[0] = m[0];
            result[0] = m[0];
        } else if (i == 1) {
            whileTaking[1] = m[1];
            result[1] = min(m[0], m[1]);
        } else if (i == 2) {
            whileTaking[2] = m[2];
            result[2] = min(m[0], min(m[1], m[2]));
        } else {
            whileTaking[i] = m[i] + result[i-1];
            result[i] = min(whileTaking[i], min(whileTaking[i-1], whileTaking[i-2]));
        }
    }   

    printf("%d\n", result[n-1]);
    return 0;
}