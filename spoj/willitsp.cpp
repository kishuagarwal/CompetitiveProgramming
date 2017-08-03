#include <iostream>

using namespace std;

int main(void) {
    unsigned long long n;

    cin >> n;

/*    while (n > 1) {
        if (n == 3)
            break;
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = n * 3 + 3;
        }
    }
*/

    while (n % 2 == 0) {
        n /= 2;
    }

    if (n != 1) {
        cout << "NIE" << endl;
    } else 
        cout << "TAK" << endl;

    return 0;
}