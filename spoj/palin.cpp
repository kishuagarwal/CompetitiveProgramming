#include <iostream>
#include <cstring>

using namespace std;

int digits[1000002];
int length;
int LIMIT = 1000002;


void incrementOne(int start, int end) {
    int i;
    int spilled = 0;
    for (i = end; i >= start; i--) {
        digits[i] += 1;
        spilled = 0;
        if (digits[i] > 9) {
            digits[i] = 0;
            spilled = 1;
        } else {
            break;
        }
    }
    if (spilled) {
        digits[i] += 1;
        if (start == LIMIT - length)
            length++;
    }
}

void nextLargest(int start, int end) {
    if (start == end) {
        return;
    }
    if (end == start + 1) {
        if (digits[start] >= digits[end]) {
            digits[end] = digits[start];
        } else {
            digits[start]++;
            digits[end] = digits[start];
        }
        return;
    }

    if (digits[start] >= digits[end]) {
        digits[end] = digits[start];
        nextLargest(start+1, end-1);
    } else {
        incrementOne(start+1, end-1);
        nextLargest(start+1, end-1);
        digits[end] = digits[start];
    }


}


int main(void) {
    int t;
    cin >> t;
    char c[1000001];
    while (t--) {
        cin >> c;
        length = strlen(c);
        for (int i = 0; i < length; i++) {
            digits[LIMIT-length+i] = c[i] - '0';
        }
        digits[LIMIT-length-1] = 0;
        incrementOne(LIMIT- length, LIMIT-1);
        nextLargest(LIMIT-length, LIMIT-1);
        for (int i = LIMIT - length; i < LIMIT; i++) {
            cout << digits[i];
        }
        cout << endl;

    }
}