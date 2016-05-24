#include <stdio.h>
#include <string.h>

#define min(a,b) ((a < b) ? a : b)

int notmain(void) {
	int t,n,keysRequired,i,ans,keys;
	char pattern[103];
	scanf("%d",&t);
	while (t--) {
		scanf("%s",pattern); //read pattern
		scanf("%d",&n); //read number of octaves
		//Find out the number of keys required for the pattern
		keysRequired = 0;
		keys = 12 * n;
		for (i = 0; i < strlen(pattern) ; i++) {
			keysRequired += (pattern[i] == 'T' ? 2 : 1);
		}
		if (keysRequired >= 12*n)
			ans = 0;
		else
		{
			ans = 0;
			for (i = keys; i > keysRequired; i--) {
				ans += ((i-1) / keysRequired);
			}
		}
		printf ("%d\n", ans);
	}

	return 0;
}


