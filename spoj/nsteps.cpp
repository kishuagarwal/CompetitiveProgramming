#include <iostream>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    while (t--) {
        int x,y;
        cin >> x >> y;
        if (x != y and x - y != 2) {
            cout << "No Number" << endl;
            continue;
        }

        if (x == y) {
            if (x % 2 == 0)
                cout << (x / 2) * 4  << endl;
            else
                cout << (x / 2) * 4 + 1 << endl;
        } else {
            if (x % 2 == 0)
                cout << (x - 1) * 2  << endl;
            else
                cout << (x - 2) * 2 + 1  << endl;
        }
    }

    return 0;
}