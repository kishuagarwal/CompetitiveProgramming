#include <iostream>
#include <cmath>

using namespace std;

int main(void) {
    int n;
    int items[10000];
    while (true) {
        cin >> n;
        if (n == -1) {
            break;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cin >> items[i];
            sum += items[i];
        }
        if (sum % n != 0) {
            cout << -1 << endl;
            continue;
        }
        int min = 0;
        int avg = sum / n;
        for (int i = 0; i < n; i++) {
            min += abs(items[i] - avg);
        }

        cout << min/2<< endl;
    }


    return 0;
}