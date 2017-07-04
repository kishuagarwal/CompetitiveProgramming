#include <iostream>
#include <string>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    string blank;

    while (t--) {
        getline(cin, blank);
        long long n;
        cin >> n;
        long long total = 0;
        long long temp;
        for (long long i = 0; i < n; i++) {
            cin >> temp;
            total += temp;
        }
        if (total % n == 0) {
            cout << "YES" << endl;
        } else 
            cout << "NO" << endl;
    }
    return 0;
}