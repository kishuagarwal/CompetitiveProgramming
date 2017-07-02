#include <iostream>
#include <algorithm>


using namespace std;

int main(void) {
    int t;
    cin >> t;

    int first[1000];
    int second[1000];
    while (t--) {
        int n;
        cin >> n;
        for(int i = 0; i < n; i++) {
            cin >> first[i];
        }
        for(int i = 0; i < n; i++) {
            cin >> second[i];
        }
        sort(first, first + n);
        sort(second, second + n);
        //sort(begin(first), end(first));
        //sort(begin(second), end(second));
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += first[i] * second[i];

        cout << ans << endl;

    }

    return 0;
}