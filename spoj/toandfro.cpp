#include <iostream>
#include <cstring>

using namespace std;

int main(void) {
    int n;
    char s[202];
    char mat[200][20];
    while (true) {
        cin >> n;
        if (n == 0)
            break;
        cin >> s;
        int pos = 0;
        int rows = strlen(s) / n;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n ; j++) {
                if (i % 2 == 0)
                    mat[i][j] = s[pos++];
                else
                    mat[i][n-1-j] = s[pos++];
            }
        }
        for (int i = 0; i<n; i++) {
            for (int j =0; j < rows; j++) {
                cout << mat[j][i];
            }
        }
        cout << endl;
    }
}