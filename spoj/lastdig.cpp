#include <iostream>

using namespace std;


int lastDigit(int a, int b){
    if (b == 0) {
        return 1;
    }
    int digit = lastDigit(a,b/2); 
    digit *= digit;
    if (b % 2 == 1) {
        digit *= a;
    }
    return digit % 10;
}

int main(void) {
    int t;
    cin >> t;
    while (t--) {
        int a,b;
        cin >> a >> b;
        cout << lastDigit(a,b) << endl;
    }
    return 0;
}