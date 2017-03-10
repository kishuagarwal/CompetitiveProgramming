#include <stdio.h>
#include <math.h>
int main(void) {
    int i;
    int min = 2000000000,max=0;
    int n;
    long pos[100000], speed[100000];
    double x0,x1,f,fd,mid;
    double e = 0.0000001;
    double tol = 0.0000001;

    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        scanf("%ld", &pos[i]);
        if (pos[i] < min) {
            min = pos[i];
        } 
        if (pos[i] > max) 
            max = pos[i];
    }
    for (i = 0; i < n; i++) {
        scanf("%ld", &speed[i]);
    }

    x0 = min;
    x1 = max;
    while (1) {
        mid = (x0 + x1) / 2;
        f = 0;
        fd = 0;
        for (i = 0; i < n; i++) {
            if (mid >= pos[i]) {
                f += (mid - pos[i]) / speed[i];
                fd += 1.0 / speed[i];
            } else {
                f += (pos[i]-mid) / speed[i];
               fd += -1.0 / speed[i];
           }
        }
        if (abs(fd) < e) {
            break;
        }
        if (abs(x1 - x0) <= tol) {
            break;
        }
        printf("%lf %lf %lf %lf %lf %.10lf %.10lf\n", x1,x0,mid, f, fd, abs(fd), abs(x1-x0));
        if (fd > 0) {
            x1 = mid;
        } else {
            x0 = mid;
        }
    }
    f = 0;
    for (i = 0; i < n; i++) {
        if (x0 >= pos[i]) {
            f += (x0 - pos[i]) / speed[i];
        } else {
            f += (pos[i]-x0) / speed[i];
        }
    }   
    printf("%lf\n", f);
    return 0;
}