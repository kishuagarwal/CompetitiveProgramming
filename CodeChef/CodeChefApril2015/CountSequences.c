#include <stdio.h>
#define gc getchar


int read_int()
{
    char c = gc();
    while(c<'0' || c>'9') c = gc();
    int ret = 0;
    while(c>='0' && c<='9')
    {
        ret = 10 * ret + c - 48;
        c = gc();
    }
    return ret;
}

long read_long()
{
    char c = gc();
    while(c<'0' || c>'9') c = gc();
    long ret = 0;
    while(c>='0' && c<='9')
    {
        ret = 10 * ret + c - 48;
        c = gc();
    }
    return ret;
}


int main(void) {
	int t;
	long n,l,r,mod = 1000003,numbers,ans,i,temp;
	t = read_int();
	while(t--) {
		n = read_long();
		l = read_long();
		r = read_long();
		numbers = r - l + 1;
		ans = numbers % mod;
		l = ans;
		for (i = 1; i < n; i++) {
			temp = (long)(l * (double)(numbers + i) / (i+1));
			l = temp % mod;
			ans = (ans + l) % mod;
		}
		printf ("%ld\n",ans);
	}
	return 0;
}
