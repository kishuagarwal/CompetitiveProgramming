#include <iostream>

using namespace std;

int main(void) {
    int n;
    cin >> n;
    int ans = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            if (i * j <= n) {
                ans++;
            }
            else
                break;
        }
    }
    cout << ans << endl;
}