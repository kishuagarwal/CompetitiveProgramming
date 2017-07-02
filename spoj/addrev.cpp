#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void) {
    int n;
    std::string a, b;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a >> b;
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        int result = stoi(a) + stoi(b);
        string c = to_string(result);
        reverse(c.begin(), c.end());
        cout << stoi(c) << endl;

    }

    return 0;
}