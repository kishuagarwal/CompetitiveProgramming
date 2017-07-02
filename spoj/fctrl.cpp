#include <iostream>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int twoPower = 0;
        int fivePower = 0;
        int temp = n;
        int twos = 2;
        while (twos <= temp) {
            twoPower += temp / twos;
            twos = twos << 1;
        }
        int fives = 5;
        temp = n;
        while (fives <= temp) {
            fivePower += temp / fives;
            fives *= 5;
        }
        int ans = (twoPower < fivePower) ? (twoPower) : (fivePower);
        cout << ans << endl;
    }
    return 0;
}