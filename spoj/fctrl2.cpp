#include <iostream>
using namespace std;
int arr[200];
int limit;

void multiply(int n) {
    int temp = 0;
    for (int i = 0; i <= limit; i++) {
        temp += arr[i] * n;
        arr[i] = temp % 10;
        temp /= 10;
    }
    while (temp > 0) {
        arr[++limit] = temp % 10;
        temp /= 10; 
    }
}


int main(void) {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        arr[0] = 1;
        limit = 0;
        for (int i = 2; i <= n; i++)
            multiply(i);
        for (int i = limit; i >=0 ; i-- )
            cout << arr[i];

        cout << endl;
    }

    return 0;
}