/*
 * chefandcube.c
 *
 *  Created on: 05-Jul-2015
 *      Author: Kishu Agarwal
 */
#include <stdio.h>
#include <string.h>

int triplet(char s[6][10], int first, int second , int third) {
	if (strcmp(s[first] , s[second]) == 0) {
		if (strcmp(s[second] , s[third]) == 0)
			return 1;
	}
	return 0;
}

int main1(void) {
	int t,i;
	char s[6][10];
	scanf("%d", &t);
	while (t--) {
		for (i = 0; i < 6; i++)
			scanf("%s",s[i]);
		if (triplet(s,0,2,4) ||
			triplet(s,0,2,5) ||
			triplet(s,0,3,4) ||
			triplet(s,0,3,5) ||
			triplet(s,1,2,4) ||
			triplet(s,1,2,5) ||
			triplet(s,1,3,4) ||
			triplet(s,1,3,5) )
			printf("YES\n");
		else
			printf("NO\n");
	}

	return 0;
}




