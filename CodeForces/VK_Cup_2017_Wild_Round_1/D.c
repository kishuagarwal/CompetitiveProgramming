    #include <stdio.h>
    #include <stdlib.h>

    int cmp(const void *a, const void *b) {
        return (*(int*)a - *(int*)b);
    }

    int main(void) {
        int n,l,r,i,truth;
        int a[100004];
        int b[100004];
        scanf("%d %d %d", &n, &l, &r);
        for (i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
        for (i = 0; i < n; i++) {
            scanf("%d", &b[i]);
        }

        truth = 1;
        qsort(a+l-1, r-l+1, sizeof(int),cmp);
        qsort(b+l-1, r-l+1, sizeof(int),cmp);

        for (i = 0; i < n; i++) {
            //printf("%d %d\n", a[i], b[i]);
            if (a[i] != b[i]) {
                truth = 0;
                break;
            }
        }
        if (truth) {
            printf("TRUTH\n");
        }
        else 
            printf("LIE\n");
        return 0;
    }