#include <iostream>
#include <cmath>

using namespace std;

int main(void){
    int t;
    cin >> t;
    long long int arr[100005];
    while (t--) {
        int n,d;
        cin >> n >> d;
        long long int total = 0;
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
            total += arr[i];
        }
        long long int ans = 0;
        if (total % n != 0) {
            cout << -1 << endl;
            continue;
        }
        total /= n;
        for(int i = 0; i < d; i++) {
            for(int j = i; j < n; j += d) {
                if (j + d < n) {
                    arr[j+d] += (arr[j] - total);
                    ans += abs(arr[j] - total);
                } else {
                    if (arr[j] != total) {
                        ans = -1;
                        break;
                    }
                }
            }
            if (ans == - 1)
                break;
            
        }
        cout << ans << endl;
    }

    return 0;
}