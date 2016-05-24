/*
 * bread.c
 *
 *  Created on: 06-Jul-2015
 *      Author: Kishu Agarwal
 */

#include <stdio.h>
#define getc getchar

int read_int() {
	int temp = 0;
	char c = getc();
	while (!(c >= '0'  && c <= '9' )) c = getc();
	while (c >= '0'  && c <= '9' ) {
		temp = temp * 10 + c - '0';
		c = getc();
	}
	return temp;
}

long long read_long() {
	long long temp = 0;
	char c = getc();
	wh
	t = read_int();
	while (t--) {
		n = read_long();
		k = read_long();
		curb = 0;
		count = 0;
		while (n--) {
			curd = read_long();
			if (curd <= curb) {
				curb -= curd;
			}
			else {
				curd -= curb;
				count += curd / k;
				if (curd % k != 0) count++;
				curb = k - (curd % k);
			}
			if (curb > 0 ) curb--;
		}
		printf("%ld\n",count);
	}
	return 0;
}
