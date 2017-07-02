#include <iostream>

using namespace std;

int main(void) {
    int n;
    while (true) {
        cin >> n;
        if (n == 0)
            break;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                count += ((n - i + 1) < (n - j + 1)) ? (n - i + 1) : (n - j + 1);
            }
        }

        cout << count << endl;
    }


    return 0;
}