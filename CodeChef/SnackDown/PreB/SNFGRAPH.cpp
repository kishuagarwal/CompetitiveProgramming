#include <iostream>

using namespace std;

int main(void) {
    int t;
    cin >> t;
    int a[100006];
    int d[100006];
    for (int i = 0; i < t; i++) {
        int n,m;
        cin >> n >> m;
        for(int j = 0; j < n; j++) {
            d[j] = 0;
            a[j] = 0;
        }

        for (int j = 0; j < m; j++) {
            int u,v;
            cin >> u >> v;
            a[u-1]++;
            a[v-1]++;
        }
        for (int j = 0; j < n; j++) {
            d[a[j]]++;
        }
        int total = 0;
        for (int j = 0; j < n; j++) {
            total += d[j];
            if (total == n)
                total--;
            cout << total << " ";
        }
        cout << endl;
    }

    return 0;
}