#include <iostream>
#include <cstring>

using namespace std;

int hasUnique(int freq[2][26], int pos) {
    int count = 0;
    for (int i = 0; i < 26; i++) {
       if (freq[pos][i] > 0 and freq[1 - pos][i] == 0) {
            if (freq[pos][i] > count)
                count = freq[pos][i]; 
       } 
    }
    return count;
}

int main(void) {
    int t;
    cin >> t;
    char str[2][1000];
    while (t--) {
        cin >> str[0];
        cin >> str[1];
        int freq[2][26];
        for (int i = 0; i < 26; i++) {
            freq[0][i] = 0;
            freq[1][i] = 0;
        }
        int length = strlen(str[0]);
        for (int i = 0; i < length; i++) {
            freq[0][str[0][i] - 'a']++;
            freq[1][str[1][i] - 'a']++;
        }
        if (hasUnique(freq, 0)) {
            if (not hasUnique(freq, 1)) {
                cout << "A" << endl;
                continue;
            }
            if (hasUnique(freq,0) > 1) {
                cout << "A" << endl;
                continue;
            }
        } 
        cout << "B" << endl;
    }
    return 0;
}