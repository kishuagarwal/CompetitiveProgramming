#include <iostream>

using namespace std;

int main(void){
    int t;
    int n;
    cin >> t;
    int max;
    int arr[120];
    while (t--) {
        cin >> n;
        int possible = 1;
        max = 0;
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < 1 or arr[i] > 7)
                possible = 0;
        }
        int curNum = 0;
        int increasing = 1;
        if (max != 7) {
            possible = 0;
        }
        int limit = n/2;
        if (n % 2 == 0)
            limit--;

        for(int i = 0; i <= limit; i++) {
            if (arr[i] != arr[n-1-i]) {
                possible = 0;
                break;
            }
            if (arr[i] == curNum or arr[i] == curNum + 1) {
                curNum = arr[i];
            } else {
                possible = 0;
                break;
            }
        }
        if (possible) {
            cout << "yes" << endl;
        } else {
            cout << "no" << endl;
        }
    }

    return 0;
}