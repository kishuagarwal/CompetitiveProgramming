#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    string s;
    cin >> s;
    int count = 0;
    string ans = "";

    int i = 0;
    if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' && s[i] != 'y') {
        ans += s[i];
    } else {
        count = 1;
    }
    char prev = s[0];

    for (i = 1; i < n; i++) {
        if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' && s[i] != 'y') {
            if (count == 2 &&  (prev == 'e' || prev == 'o')) {
                ans += prev;
                ans += prev;
            } else if (count > 0){
                ans += prev;
            }
            ans += s[i];
            count = 0;
            prev = s[i];

        } else {
            if (s[i] == s[i-1]) {
                count++;
            } else {
                if (count == 2 &&  (prev == 'e' || prev == 'o')) {
                    ans += prev;
                    ans += prev;
                } else if (count > 0) {
                    ans += prev;
                }
                count = 1;
                prev = s[i];
            }
        }

    }
    if (count > 0) {
        if (count == 2 &&  (prev == 'e' || prev == 'o')) {
            ans += prev;
            ans += prev;
        } else {
            ans += prev;
        }
    }


    cout << ans;
    return 0;
}