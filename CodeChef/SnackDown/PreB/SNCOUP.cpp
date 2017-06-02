#include <iostream>
using namespace std;

int main(void) {
    int t;
    cin >> t;
    char a[2][100005];
    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;
        cin >> a[0];
        cin >> a[1];

        int count = 1;
        int pendingTop = 0;
        int pendingBottom = 0;
        int upCount = 0;
        int DownCount = 0;

        for (int j = 0; j < n ; j++) {
            
            if (a[0][j] == '.' && a[1][j] == '.')
                continue;

            if (a[0][j] == '*' && a[1][j] == '.') {
                upCount++;
                if (!pendingTop) {
                    pendingTop = 1;
                    continue;
                }
                pendingBottom = 0;
                count++;
                continue;
            }

            if (a[0][j] == '.' && a[1][j] == '*') {
                DownCount++;
                if (!pendingBottom) {
                    pendingBottom = 1;
                    continue;
                }
                pendingTop = 0;
                count++;
                continue;
            }

            if (a[0][j] == '*' && a[1][j] == '*') {
                upCount++;
                DownCount++;
                if (pendingBottom || pendingTop) {
                    count++;
                }
                pendingTop = 1;
                pendingBottom = 1;
                continue;
            }
        }
        if (upCount == 0 && DownCount == 0) {
            count = 0;
        }
        else if (upCount + DownCount == 1) {
            count = 0;
        }
        else if (upCount == 0 || DownCount == 0)
            count--;

        cout << count << endl;

    }

    return 0;
}