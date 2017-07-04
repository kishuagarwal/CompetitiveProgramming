#include <iostream>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    while (t--) {
        long long k;
        cin >> k;
        k--;
        long long ans = (k / 4) * 1000;
        int mod = (k%4);
        if (mod == 0) {
            ans += 192;
        } else if (mod == 1) {
            ans += 442;
        } else if (mod == 2) {
            ans += 692;
        } else
            ans += 942;
        cout << ans << endl;
    }

    return 0;
}