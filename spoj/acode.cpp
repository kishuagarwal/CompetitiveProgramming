#include <iostream>
#include <cstring>

using namespace std;

int main(void) {
    char c[5001];
    int digits[5001];
    while(true) {
        cin >> c;
        if (c[0] == '0') {
            break;
        }
        long long temp;
        int length = strlen(c);
        long long  prev = 1;
        long long prevprev = 1;
        for (int i = 0; i < length; i++) {
            digits[i] = c[i] - '0';
        }
        for (int i = 1; i < length; i++) {
            temp = prev;
            if (digits[i-1] != 0 and digits[i-1] * 10 + digits[i] <= 26) {
                if (digits[i] == 0) {
                    prev = prevprev;
                }
                else
                    prev = prevprev + prev;
            } else {
                if (digits[i] == 0) {
                    prev = 0;
                    break;
                }
            }
            prevprev = temp;
        }
        cout << prev << endl;
    }

    return 0;
}