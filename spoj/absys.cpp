#include <iostream>

using namespace std;

int parseNumber(char *num) {
    int ans = 0;
    char *ptr = num;
    while (*ptr != '\0') {
        ans = ans * 10 + (*ptr - '0');
        ptr++;
    }

    return ans;
}

int main(void) {
    int t;
    cin >> t;
    int nums[3];
    char s_nums[3][100];
    char s[100];
    int pos = -1;
    while (t--) {
        cin >> s_nums[0];
        char *temp = s_nums[0];
        while (*temp != '\0') {
            if (*temp == 'm') {
                pos = 0;
            }
            temp++;
        }
        cin >> s;
        cin >> s_nums[1];

        temp = s_nums[1];
        while (*temp != '\0') {
            if (*temp == 'm') {
                pos = 1;
            }
            temp++;
        }

        cin >> s;
        
        cin >> s_nums[2];
        temp = s_nums[2];
        while (*temp != '\0') {
            if (*temp == 'm') {
                pos = 2;
            }
            temp++;
        }
        if (pos == 0) {
            nums[1] = parseNumber(s_nums[1]);
            nums[2] = parseNumber(s_nums[2]);
            cout << nums[2] - nums[1] << " + " << nums[1] << " = " << nums[2] << endl;
        } else if (pos == 1) {
            nums[0] = parseNumber(s_nums[0]);
            nums[2] = parseNumber(s_nums[2]);
            cout << nums[0] << " + " << nums[2] - nums[0] << " = " << nums[2] << endl;
        } else {
            nums[0] = parseNumber(s_nums[0]);
            nums[1] = parseNumber(s_nums[1]);
            cout << nums[0] << " + " << nums[1] << " = " << nums[0] + nums[1] << endl;
        }

    }
    return 0;
}