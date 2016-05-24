/*
 * luckystone.c
 *
 *  Created on: 05-Jul-2015
 *      Author: Kishu Agarwal
 */

#include <stdio.h>

int main2(void) {
	int n,i,count,j;
	long num , temp;
	long ans;
	scanf("%d", &n);
	for (i = 0; i < n ;i++) {
		scanf("%ld", &num);
		count = 0;
		temp = num;
		while (temp != 0) {
			if (temp % 5 == 0)
				count++;
			temp /= 5;
		}
		ans = num;
		for (j = 1; j <= count/2 ;j++)
			ans <<= 2;
		if (count & 1)
			ans <<= 2;
		printf("%ld\n", ans);

	}
	return 0;
}


